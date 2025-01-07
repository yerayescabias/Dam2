using Errepasoa.Models;
using Microsoft.CodeAnalysis.CSharp.Syntax;

namespace Errepasoa.Service
{
    public interface IBezeroaService
    {
        public Task BezeroaSortu(Bezeroa bezeroa);
    }
}
