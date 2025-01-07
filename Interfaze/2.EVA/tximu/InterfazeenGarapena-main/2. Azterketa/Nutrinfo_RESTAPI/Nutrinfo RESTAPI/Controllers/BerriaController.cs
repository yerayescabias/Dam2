using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Nutrinfo_RESTAPI.Data;
using Nutrinfo_RESTAPI.Models;
using Nutrinfo_RESTAPI.Services;

namespace Nutrinfo_RESTAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BerriaController : ControllerBase
    {
        private readonly IBerriaService _berriaService;

        public BerriaController(IBerriaService berriaService)
        {
            _berriaService = berriaService;
        }
        // GET: api/Berria
        [HttpGet]
        public async Task<ActionResult<List<Berria>>> GetBerria()
        {
            return await _berriaService.Get();
        }
        // POST: api/Berria
        [HttpPost]
        public async Task PostBerria(Berria berria)
        {
            await _berriaService.PostBerria(berria);
        }

    }
}
