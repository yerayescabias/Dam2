using WineShop.Models;

namespace WineShop.Services
{
    public interface IArdoaService
    {
        Task<IList<ArdoaUpeltegi>> GetMota(int id);

    }
}
