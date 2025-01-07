using Errepasoa.Models;
using Errepasoa.Service;
using Microsoft.AspNetCore.Mvc;

namespace Errepasoa.Controllers
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
