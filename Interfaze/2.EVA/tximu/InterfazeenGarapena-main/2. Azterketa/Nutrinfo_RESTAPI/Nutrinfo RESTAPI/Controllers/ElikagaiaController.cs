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
    public class ElikagaiaController : ControllerBase
    {
        private readonly IElikagaiaService _elikagaiaService;

        public ElikagaiaController(IElikagaiaService elikagaiaService)
        {
            _elikagaiaService = elikagaiaService;
        }

        // GET: api/Elikagaia
        [HttpGet]
        public async Task<ActionResult<List<Elikagaia>>> GetElikagaia()
        {
            return await _elikagaiaService.Get();
        }
        /*
        // GET: api/Elikagaia/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Elikagaia>> GetElikagaia(int id)
        {
          if (_context.Elikagaia == null)
          {
              return NotFound();
          }
            var elikagaia = await _context.Elikagaia.FindAsync(id);

            if (elikagaia == null)
            {
                return NotFound();
            }

            return elikagaia;
        }

        // PUT: api/Elikagaia/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutElikagaia(int id, Elikagaia elikagaia)
        {
            if (id != elikagaia.Id)
            {
                return BadRequest();
            }

            _context.Entry(elikagaia).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ElikagaiaExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Elikagaia
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Elikagaia>> PostElikagaia(Elikagaia elikagaia)
        {
          if (_context.Elikagaia == null)
          {
              return Problem("Entity set 'NutrinfoDbContext.Elikagaia'  is null.");
          }
            _context.Elikagaia.Add(elikagaia);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetElikagaia", new { id = elikagaia.Id }, elikagaia);
        }

        // DELETE: api/Elikagaia/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteElikagaia(int id)
        {
            if (_context.Elikagaia == null)
            {
                return NotFound();
            }
            var elikagaia = await _context.Elikagaia.FindAsync(id);
            if (elikagaia == null)
            {
                return NotFound();
            }

            _context.Elikagaia.Remove(elikagaia);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ElikagaiaExists(int id)
        {
            return (_context.Elikagaia?.Any(e => e.Id == id)).GetValueOrDefault();
        }
        */
    }
}
