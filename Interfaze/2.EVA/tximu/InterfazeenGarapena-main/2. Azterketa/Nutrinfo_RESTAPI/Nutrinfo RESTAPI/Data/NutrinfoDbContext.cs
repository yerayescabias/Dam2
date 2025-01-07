using Microsoft.EntityFrameworkCore;
using Nutrinfo_RESTAPI.Models;

namespace Nutrinfo_RESTAPI.Data
{
    public class NutrinfoDbContext : DbContext
    {
        public NutrinfoDbContext(DbContextOptions<NutrinfoDbContext> options) : base(options)
        {
        }
        public DbSet<Elikagaia> Elikagaia { get; set; }
        public DbSet<Informazioa> Informazioa { get; set; }
        public DbSet<Osagaia> Osagaia { get; set; }
        public DbSet<Berria> Berria { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            var configuration = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json")
                .Build();

            var connectionString = configuration.GetConnectionString("NutrinfoConnection");
            optionsBuilder.UseSqlServer(connectionString);
        }

    }
}
