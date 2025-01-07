using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc;
using RESTAPI.Models;
using RESTAPI.Data;
using System.Runtime.CompilerServices;

namespace RESTAPI.Services
{
    public class SaskiaAleaService : ISaskiaAleaService
    {
        private readonly WineShopDbContext _context;

        public SaskiaAleaService(WineShopDbContext context)
        {
            _context = context;
        }
        public async Task<List<SaskiaAlea>> GetSaskiaAleak()
        {
            return await _context.SaskiaAlea.ToListAsync();
        }
        public async Task<List<SaskiaAlea>> GetSaskiaAlea(string id)
        {
            return await _context.SaskiaAlea
                .Where(a => a.SaskiaId == id).ToListAsync();
        }
        public async Task PutSaskiaAlea(SaskiaAlea saskiaAlea)
        {
            _context.Entry(saskiaAlea).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }
        public async Task PostSaskiaAlea(SaskiaAlea saskiaAlea)
        {
            _context.SaskiaAlea.Add(saskiaAlea);
            await _context.SaveChangesAsync();
        }
        public async Task DeleteSaskiaAlea(SaskiaAlea saskiaAlea)
        {
            _context.SaskiaAlea.Remove(saskiaAlea);
            await _context.SaveChangesAsync();
        }
        public bool SaskiaAleaExists(int id)
        {
            return _context.SaskiaAlea.Any(e => e.Id == id);
        }
        public async Task PostBezeroaEskaera(BezeroaEskaera bezeroaEskaera)
        {
            _context.BezeroaEskaera.Add(bezeroaEskaera);
            await _context.SaveChangesAsync();
        }
        public async Task PostErosketa(Erosketa erosketa)
        {
            _context.Erosketa.Add(erosketa);
            await _context.SaveChangesAsync();
        }
    }
}
