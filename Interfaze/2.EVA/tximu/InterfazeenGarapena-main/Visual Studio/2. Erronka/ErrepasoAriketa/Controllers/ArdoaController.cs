using ErrepasoAriketa.Models;
using ErrepasoAriketa.Services;
using Microsoft.AspNetCore.Mvc;

namespace ErrepasoAriketa.Controllers
{
    public class ArdoaController : Controller
    {
        private readonly IArdoaService _ardoaService;

        public ArdoaController(IArdoaService ardoaService)
        {
            _ardoaService = ardoaService;
        }

        public async Task<IActionResult> Index()
        {
            List<Ardoa> ardoaList = new List<Ardoa>();
            ardoaList = await _ardoaService.GetArdoak();
            return View(ardoaList);
        }
    }
}
