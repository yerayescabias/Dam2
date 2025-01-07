using WineshopPertsonala.Models;

namespace WineshopPertsonala.Services;

public interface IArdoaService
{
    Task<IList<ArdoaUpeltegi>> GetMota(int id);
    Task<List<Ardoa>> GetArdoak();
}
