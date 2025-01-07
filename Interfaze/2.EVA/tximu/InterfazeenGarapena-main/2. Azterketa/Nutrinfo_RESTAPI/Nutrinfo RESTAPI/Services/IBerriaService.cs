using Nutrinfo_RESTAPI.Models;

namespace Nutrinfo_RESTAPI.Services
{
    public interface IBerriaService
    {
        public Task<List<Berria>> Get();
        public Task PostBerria(Berria berria);
    }
}