using ErrepasoAriketa.Models;
using Newtonsoft.Json;

namespace ErrepasoAriketa.Services
{
    public class ArdoaService : IArdoaService
    {
        private Uri rutaTodos = new Uri("https://localhost:44371/api/Ardoa/");
        public async Task<List<Ardoa>> GetArdoak()
        {
            List<Ardoa> ardoaList = new List<Ardoa>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    ardoaList = JsonConvert.DeserializeObject<List<Ardoa>>(apiResponse);
                }
            }
            return ardoaList;
        }
    }
}
