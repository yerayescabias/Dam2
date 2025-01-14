using Microsoft.EntityFrameworkCore;
using RESTAPI.Data;
using RESTAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace RESTAPI.Services
{
    public class EskualdeaService : IEskualdeaService
    {
        private readonly WineShopDbContext _context;

        public EskualdeaService(WineShopDbContext context)
        {
            _context = context;
        }
        public async Task<List<Eskualdea>> GetEskualdeak()
        {
            return await _context.Eskualdea.ToListAsync();
        }
    }
}
