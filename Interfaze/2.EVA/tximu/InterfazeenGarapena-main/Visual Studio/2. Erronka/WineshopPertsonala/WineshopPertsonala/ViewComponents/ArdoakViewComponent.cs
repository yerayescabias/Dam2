using Microsoft.AspNetCore.Mvc;
using WineshopPertsonala.Services;

namespace WineshopPertsonala.ViewComponents
{
    public class ArdoakViewComponent : ViewComponent
    {
        private readonly IArdoaService _ardoaService;
        public ArdoakViewComponent(IArdoaService ardoaService)
        {
            _ardoaService = ardoaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _ardoaService.GetMota(id));
        }
    }
}
