using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using RESTAPI.Services;
using RESTAPI.Models;

namespace RESTAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ErosketaController : ControllerBase
    {
        private readonly ISaskiaAleaService _saskiaAleaService;

        public ErosketaController(ISaskiaAleaService saskiaAleaService)
        {
            _saskiaAleaService = saskiaAleaService;
        }

        // POST: api/SaskiaAlea
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Erosketa>> PostErosketa(Erosketa erosketa)
        {
            await _saskiaAleaService.PostErosketa(erosketa);
            return NoContent();
        }
    }
}
