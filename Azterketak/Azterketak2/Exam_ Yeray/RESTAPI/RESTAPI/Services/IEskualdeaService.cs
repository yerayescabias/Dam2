using RESTAPI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace RESTAPI.Services
{
    public interface IEskualdeaService
    {
        Task<List<Eskualdea>> GetEskualdeak();
    }
}
