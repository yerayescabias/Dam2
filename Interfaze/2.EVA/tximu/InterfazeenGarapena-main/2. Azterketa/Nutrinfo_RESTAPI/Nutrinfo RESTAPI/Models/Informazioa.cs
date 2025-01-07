using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Nutrinfo_RESTAPI.Models
{
    public partial class Informazioa
    {
        [Key]
        public int Id { get; set; }
        public int ElikagaiaId { get; set; }
        public virtual Elikagaia Elikagaia { get; set; }
        public int OsagaiaId { get; set; }
        public virtual Osagaia Osagaia { get; set; }
        public int Urtea {  get; set; }
        public int Kantitatea { get; set; }
    }
}
