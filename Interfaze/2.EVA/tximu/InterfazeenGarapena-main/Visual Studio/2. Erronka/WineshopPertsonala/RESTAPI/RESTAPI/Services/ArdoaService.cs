using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc;
using RESTAPI.Models;
using RESTAPI.Data;

namespace RESTAPI.Services
{
    public class ArdoaService : IArdoaService
    {
        private readonly WineShopDbContext _context;

        public ArdoaService(WineShopDbContext context)
        {
            _context = context;
        }
        public async Task<List<ArdoaUpeltegiDto>> GetMota(int id)
        {
            return await _context.Ardoa
                .Where(m => m.MotaId == id)
                .Select(x => new ArdoaUpeltegiDto()
                {
                    Id = x.Id,
                    Izena = x.Izena,
                    UpeltegiIzena = x.Upeltegia.Izena
                })
                .ToListAsync();

        }
        public async Task<List<Ardoa>> GetArdoak()
        {
            return await _context.Ardoa.ToListAsync();
        }
        public async Task<Ardoa> GetArdoa(int id)
        {
            return await _context.Ardoa
                .Include(a => a.Mota)
                .SingleOrDefaultAsync(a => a.Id == id);
        }
    }
}
