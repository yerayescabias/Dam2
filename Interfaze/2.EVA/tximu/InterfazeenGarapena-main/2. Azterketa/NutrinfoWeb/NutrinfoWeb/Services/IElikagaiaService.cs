using NutrinfoWeb.Models;

namespace NutrinfoWeb.Services
{
    public interface IElikagaiaService
    {
        Task<List<Elikagaia>> GetElikagaiak();
    }
}
