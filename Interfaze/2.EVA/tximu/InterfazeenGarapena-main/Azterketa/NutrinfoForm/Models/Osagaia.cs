using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NutrinfoForm.Models
{
    public partial class Osagaia
    {
        [Key]
        public int Id { get; set; }
        public string Izena { get; set; }

        public string Unitatea { get; set; }

        public int Konparaketa { get; set; }
    }
}
