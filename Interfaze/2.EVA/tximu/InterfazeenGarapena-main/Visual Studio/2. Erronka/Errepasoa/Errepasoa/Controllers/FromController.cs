using Errepasoa.Models;
using Errepasoa.Service;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Errepasoa.Controllers
{
    //[Authorize]
    public class FromController : Controller
    {
     
        private readonly IBezeroaService _bezeroaService;
        public FromController(IBezeroaService bezeroaService)
        {
            _bezeroaService = bezeroaService;
        }

        // GET: FromController
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Index([Bind("Izena,Abizena,Helbidea,Hiria,Herrialdea,Postakodea,Telefonoa")] Bezeroa bezeroa)
        {
            // si aqui no estra en el if, podemos quitarlo
            if (ModelState.IsValid)
            {
                // si erabiltzailea es null, podemos poner un String.
                bezeroa.Erabiltzailea = "aabd";
                bezeroa.Data = DateTime.Now;
                await _bezeroaService.BezeroaSortu(bezeroa);
            }

            return RedirectToAction("Index", "Home");
        }

        // GET: FromController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: FromController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: FromController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: FromController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: FromController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: FromController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: FromController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
