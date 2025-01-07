using Nutrinfo_RESTAPI.Data;
using Nutrinfo_RESTAPI.Models;

namespace Nutrinfo_RESTAPI.Services
{
    public interface IElikagaiaService
    {
        public Task<List<Elikagaia>> Get();
    }
}
