using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using RESTAPI.Models;

namespace RESTAPI.Services
{
    public interface IArdoaService
    {
        Task<List<Ardoa>> GetArdoak();
        Task<List<ArdoaUpeltegiDto>> GetMota(int id);
        Task<Ardoa> GetArdoa(int id);
    }
}
