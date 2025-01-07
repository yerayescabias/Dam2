using Errepasoa.Models;
using Newtonsoft.Json;

namespace Errepasoa.Service
{
    public class ArdoaService : IArdoaService
    {
        
        private Uri rutaTodos = new Uri("https://localhost:44371/api/Ardoa/");

        public async Task<List<Ardoa>> GetArdoak()
        {
            List<Ardoa> ardoak = new List<Ardoa>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    ardoak = JsonConvert.DeserializeObject<List<Ardoa>>(apiResponse);
                }
            }
            return ardoak;
        }



    }
}
