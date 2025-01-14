using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RESTAPI.Models;

namespace RESTAPI.Data
{
    public class WineShopDbContext : DbContext
    {
        public WineShopDbContext(DbContextOptions<WineShopDbContext> options) : base(options)
        {
        }
        public DbSet<Ardoa> Ardoa { get; set; }
        public DbSet<Herrialdea> Herrialdea { get; set; }
        public DbSet<Eskualdea> Eskualdea { get; set; }
        public DbSet<Upeltegia> Upeltegia { get; set; }
        public DbSet<Mota> Mota { get; set; }
        public DbSet<SaskiaAlea> SaskiaAlea { get; set; }
        public DbSet<Erosketa> Erosketa { get; set; }
        public DbSet<BezeroaEskaera> BezeroaEskaera { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            var configuration = new ConfigurationBuilder()
                .SetBasePath(Directory.GetCurrentDirectory())
                .AddJsonFile("appsettings.json")
                .Build();

            var connectionString = configuration.GetConnectionString("WineShopConnection");
            optionsBuilder.UseSqlServer(connectionString);
        }

    }
}
