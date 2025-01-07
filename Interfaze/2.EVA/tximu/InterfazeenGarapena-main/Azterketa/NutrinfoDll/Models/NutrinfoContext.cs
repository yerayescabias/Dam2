using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Data.Entity;
using NutrinfoForm.Models;

namespace NutrinfoForm
{
    public class NutrinfoContext : DbContext
    {
        public NutrinfoContext() : base("NutrinfoContext") { }

        public DbSet<Elikagaia> Elikagaiak { get; set; }
        public DbSet<Osagaia> Osagaiak { get; set; }
        public DbSet<Informazioa> Informazioak { get; set; }
    }
}

