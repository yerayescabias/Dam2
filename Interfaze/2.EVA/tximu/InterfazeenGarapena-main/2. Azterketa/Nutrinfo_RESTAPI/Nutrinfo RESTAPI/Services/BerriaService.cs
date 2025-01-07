using Microsoft.EntityFrameworkCore;
using Nutrinfo_RESTAPI.Data;
using Nutrinfo_RESTAPI.Models;

namespace Nutrinfo_RESTAPI.Services
{
    public class BerriaService : IBerriaService
    {
        private readonly NutrinfoDbContext _context;
        public BerriaService(NutrinfoDbContext context)
        {
            _context = context;
        }
        public async Task<List<Berria>> Get()
        {
            return await _context.Berria.ToListAsync();
        }
        public async Task PostBerria(Berria berria)
        {
            _context.Berria.Add(berria);
            await _context.SaveChangesAsync();
        }
    }
}
