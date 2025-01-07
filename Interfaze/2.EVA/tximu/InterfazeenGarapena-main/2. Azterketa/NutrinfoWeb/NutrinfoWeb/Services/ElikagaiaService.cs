using Newtonsoft.Json;
using NutrinfoWeb.Models;

namespace NutrinfoWeb.Services
{
    public class ElikagaiaService : IElikagaiaService
    {
        private Uri rutaTodos = new Uri("https://localhost:7098/api/Elikagaia/");
        public async Task<List<Elikagaia>> GetElikagaiak()
        {
            List<Elikagaia> elikagaiaList = new List<Elikagaia>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    elikagaiaList = JsonConvert.DeserializeObject<List<Elikagaia>>(apiResponse);
                }
            }
            return elikagaiaList;
        }
    }
}
