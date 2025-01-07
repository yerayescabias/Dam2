using System.ComponentModel.DataAnnotations;

namespace NutrinfoWeb.Models
{
    public class Elikagaia
    {
        [Key]
        public int Id { get; set; }
        public string Izena { get; set; }
        public string Marka { get; set; }
        public string Deskripzioa { get; set; }
        public string Irudia { get; set;}
    }
}
