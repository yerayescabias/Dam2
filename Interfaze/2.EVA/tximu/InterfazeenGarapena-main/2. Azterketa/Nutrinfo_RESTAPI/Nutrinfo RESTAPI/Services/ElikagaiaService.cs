using Microsoft.EntityFrameworkCore;
using Nutrinfo_RESTAPI.Data;
using Nutrinfo_RESTAPI.Models;

namespace Nutrinfo_RESTAPI.Services
{
    public class ElikagaiaService : IElikagaiaService
    {
        private readonly NutrinfoDbContext _context;
        public ElikagaiaService(NutrinfoDbContext context)
        {
            _context = context;
        }
        public async Task<List<Elikagaia>> Get()
        {
            return await _context.Elikagaia.ToListAsync();
        }
    }
}
