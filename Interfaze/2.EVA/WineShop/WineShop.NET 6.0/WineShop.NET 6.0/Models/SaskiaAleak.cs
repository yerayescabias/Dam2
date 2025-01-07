using System.ComponentModel.DataAnnotations;

namespace WineShop.NET_6._0.Models
{
    public class SaskiaAleak
    {
        [Key]
        public int Id { get; set; }
        public string SaskiaId { get; set; }
        public int Kantitatea { get; set; }
        public System.DateTime Data { get; set; }
        public int ArdoaId { get; set; }
    }
}
