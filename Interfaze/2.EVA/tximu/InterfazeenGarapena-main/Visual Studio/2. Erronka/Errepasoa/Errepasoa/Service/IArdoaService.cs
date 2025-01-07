namespace Errepasoa.Service

{
using Errepasoa.Models;

public interface IArdoaService
    {
        Task<List<Ardoa>> GetArdoak();
    }
}
