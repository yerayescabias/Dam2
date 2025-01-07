using WineShop.Models;

namespace WineShop.Services
{
    public interface ISaskiaService
    {
        Task SaskiaGehitu(int ardoaId, string saskiaId);

        Task<List<SaskiaAlea>> SaskiaLortuAleak(String saskiaID);

        Task<List<SaskiaAlea>> GetSaskiaAlea(string id);
    }
}

