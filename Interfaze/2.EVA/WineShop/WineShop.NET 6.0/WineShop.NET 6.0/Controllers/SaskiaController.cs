namespace WineShop.NET_6._0.Controllers
{

    using Microsoft.AspNetCore.Mvc;
    using WineShop.NET_6._0.Service;

    public class SaskiaController : Controller
    {
        private readonly ISaskiaService _saskiaService;
        public SaskiaController(ISaskiaService saskiaService)
        {
            _saskiaService = saskiaService;
        }
        public async Task<IActionResult> Index()
        {
            return View(); // momentuz bista hutsa sortuko dugu (empty txantiloia)
        }
        public async Task<IActionResult> SaskiaGehitu(int id)
        {
            var cart = Saskia.SaskiaLortu(this.HttpContext); //aurretik sortu dugun Saskia klasea erabilizawait _saskiaService.SaskiaGehitu(id, cart.SaskiaId); //zerbitzu berrian karritoan gehitzekoreturn RedirectToAction("Index", new { id = cart.SaskiaId });
        }
