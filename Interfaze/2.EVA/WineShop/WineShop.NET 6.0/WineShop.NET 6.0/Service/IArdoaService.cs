using WineShop.NET_6._0.Models;

namespace WineShop.NET_6._0.Service
{
    public interface IArdoaService
    {
        Task<IList<ArdoaUpeltegi>> GetMota(int id);
        Task<List<Ardoa>> GetArdoak();
    }
}
