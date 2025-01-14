using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RESTAPI.Services;
using RESTAPI.Models;

namespace RESTAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EskualdeaController : Controller
    {
        private readonly IEskualdeaService _eskualdeaService;
        public EskualdeaController(IEskualdeaService eskualdeaService)
        {
            _eskualdeaService = eskualdeaService;
        }

        // GET: api/Eskualdea
        [HttpGet]
        public async Task<ActionResult<List<Eskualdea>>> GetEskualdeak()
        {
            return await _eskualdeaService.GetEskualdeak();
        }
    }
}
