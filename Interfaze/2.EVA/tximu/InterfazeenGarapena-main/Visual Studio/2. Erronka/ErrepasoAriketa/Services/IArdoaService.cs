using ErrepasoAriketa.Controllers;
using ErrepasoAriketa.Models;

namespace ErrepasoAriketa.Services
{
    public interface IArdoaService
    {
        Task<List<Ardoa>> GetArdoak();
    }
}
