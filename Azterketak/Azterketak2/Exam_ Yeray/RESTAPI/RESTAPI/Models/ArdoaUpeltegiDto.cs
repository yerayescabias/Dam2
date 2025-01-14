using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace RESTAPI.Models
{
    public class ArdoaUpeltegiDto
    {
        public int Id { get; set; }
        public string Izena { get; set; }
        public string UpeltegiIzena { get; set; }
    }
}
