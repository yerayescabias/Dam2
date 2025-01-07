using System.ComponentModel.DataAnnotations;

namespace NutrinfoWeb.Models
{
    public class Berria
    {
        [Key]
        public int Id { get; set; }
        public string Titularra { get; set; }
        public string Deskripzioa { get; set; }
        public bool Nabarmena { get; set; }
        public DateTime Data { get; set; }
        public string? Autorea { get; set; }
    }
}
