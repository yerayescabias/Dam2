using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.ComponentModel.DataAnnotations;

namespace RESTAPI.Models
{
    public class Upeltegia
    {

        [Key]
        public int Id { get; set; }
        public string Izena { get; set; }
        public virtual IList<Ardoa> Ardoak { get; set; }
        public int EskualdeaId { get; set; }
        public virtual Eskualdea Eskualdea { get; set; }
    }
}
