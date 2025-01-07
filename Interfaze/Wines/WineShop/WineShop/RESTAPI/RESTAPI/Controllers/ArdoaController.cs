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
    public class ArdoaController : ControllerBase
    {
        private readonly IArdoaService _ardoaService;

        public ArdoaController(IArdoaService ardoaService)
        {
            _ardoaService = ardoaService;
        }

        // GET: api/Ardoa
        [HttpGet]
        public async Task<ActionResult<List<Ardoa>>> GetArdoak()
        {
            return await _ardoaService.GetArdoak();
        }
        
        // GET: api/Ardoa/Mota/1
        [Route("Mota/{id}")]
        public async Task<ActionResult<List<ArdoaUpeltegiDto>>> GetMota(int id)
        {
            return await _ardoaService.GetMota(id);
        }
        
        // GET: api/Ardoa/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Ardoa>> GetArdoa(int id)
        {
            return await _ardoaService.GetArdoa(id);
        }
        /*
        // PUT: api/Ardoa/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutArdoa(int id, Ardoa ardoa)
        {
            if (id != ardoa.Id)
            {
                return BadRequest();
            }

            _context.Entry(ardoa).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ArdoaExists(id))
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

        // POST: api/Ardoa
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Ardoa>> PostArdoa(Ardoa ardoa)
        {
            _context.Ardoa.Add(ardoa);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetArdoa", new { id = ardoa.Id }, ardoa);
        }

        // DELETE: api/Ardoa/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteArdoa(int id)
        {
            var ardoa = await _context.Ardoa.FindAsync(id);
            if (ardoa == null)
            {
                return NotFound();
            }

            _context.Ardoa.Remove(ardoa);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ArdoaExists(int id)
        {
            return _context.Ardoa.Any(e => e.Id == id);
        }
        */
    }
}
