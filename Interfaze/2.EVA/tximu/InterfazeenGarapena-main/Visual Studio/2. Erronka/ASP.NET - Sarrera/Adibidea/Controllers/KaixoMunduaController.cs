using Microsoft.AspNetCore.Mvc;
using System.Web;

namespace Adibidea.Controllers
{
    public class KaixoMunduaController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        public ActionResult OngiEtorri(string izena, int
        zenbat = 1)
        {
            ViewBag.Mezua = "Hello " + izena;
            ViewBag.Zenbat = zenbat;
            return View();
        }
    }
}
