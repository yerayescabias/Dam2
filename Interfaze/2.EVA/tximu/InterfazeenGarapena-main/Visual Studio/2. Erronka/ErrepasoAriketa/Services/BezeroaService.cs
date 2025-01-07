using ErrepasoAriketa.Models;
using Newtonsoft.Json;
using System.Text;

namespace ErrepasoAriketa.Services
{
    public class BezeroaService : IBezeroaService
    {
        public async Task BezeroaSortu(Bezeroa bezeroa)
        {
            Uri rutaBezeroEskaera = new Uri("https://localhost:44371/api/BezeroaEskaera");
            using (var httpClient = new HttpClient())
            {
                StringContent content = new StringContent(JsonConvert.SerializeObject(bezeroa), Encoding.UTF8,
                "application/json");
                var response = await httpClient.PostAsync(rutaBezeroEskaera, content);
                response.EnsureSuccessStatusCode();
            }
        }
    }
}
