using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Nutrinfo_RESTAPI.Models
{
    public partial class Elikagaia
    {
        [Key]
        public int Id { get; set; }
        public string Izena { get; set; }
        public string Marka { get; set; }
        public string Deskripzioa { get; set; }
        public string Irudia { get; set; }
        public virtual List<Informazioa> Informazioa { get; set; }
    }
}
