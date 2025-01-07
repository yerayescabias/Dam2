using System.ComponentModel.DataAnnotations;

namespace Nutrinfo_RESTAPI.Models
{
    public class Berria
    {
        [Key]
        public int Id { get; set; }
        public string Titularra { get; set; }
        public string Deskripzioa { get; set; }
        public bool Nabarmena { get; set; }
        public string Autorea { get; set; }
        public DateTime Data { get; set; }
    }
}
