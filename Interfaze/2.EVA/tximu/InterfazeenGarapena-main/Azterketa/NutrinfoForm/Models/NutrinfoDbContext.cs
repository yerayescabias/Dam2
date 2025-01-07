using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NutrinfoForm.Models
{
    public class NutrinfoDbContext : DbContext
    {
        public NutrinfoDbContext() : base(nameOrConnectionString: "NutrinfoDbContext")
        { }
        public DbSet<Elikagaia> Elikagaia { get; set; }
        public DbSet<Informazioa> Informazioa { get; set; }
        public DbSet<Osagaia> Osagaia { get; set; }
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.HasDefaultSchema("public");
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}
