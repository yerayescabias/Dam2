using Microsoft.AspNetCore.Mvc;
using NutrinfoWeb.Models;
using NutrinfoWeb.Services;
using System.Diagnostics;

namespace NutrinfoWeb.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly IElikagaiaService _elikagaiaService;

        public HomeController(ILogger<HomeController> logger, IElikagaiaService elikagaiaService)
        {
            _logger = logger;
            _elikagaiaService = elikagaiaService;
        }

        public async Task<IActionResult> Index()
        {
            List<Elikagaia> elikagaiaList = new List<Elikagaia>();
            elikagaiaList = await _elikagaiaService.GetElikagaiak();
            return View(elikagaiaList);
        }

        //public IActionResult Index()
        //{
        //    return View();
        //}

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}