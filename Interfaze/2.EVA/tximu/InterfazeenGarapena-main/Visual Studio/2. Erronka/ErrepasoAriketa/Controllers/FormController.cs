using ErrepasoAriketa.Models;
using ErrepasoAriketa.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using NuGet.ContentModel;

namespace ErrepasoAriketa.Controllers
{
    [Authorize]
    public class FormController : Controller
    {
        private readonly IBezeroaService _bezeroaService;
        public FormController(IBezeroaService bezeroaService)
        {
            _bezeroaService = bezeroaService;
        }

        // GET: FormController
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
                bezeroa.Erabiltzailea = "Asier";   // HttpContext.User.Identity.Name
                bezeroa.Data = DateTime.Now;
                await _bezeroaService.BezeroaSortu(bezeroa);
            }
            return RedirectToAction("Index", "Home");     // Go back to the homepage
        }


        // GET: FormController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: FormController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: FormController/Create
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

        // GET: FormController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: FormController/Edit/5
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

        // GET: FormController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: FormController/Delete/5
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
