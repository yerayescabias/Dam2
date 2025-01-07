using Newtonsoft.Json;
using NutrinfoWeb.Models;
using System.Text;

namespace NutrinfoWeb.Services
{
    public class BerriaService : IBerriaService
    {
        public async Task BerriaSortu(Berria berria)
        {
            Uri rutaBezeroEskaera = new Uri("https://localhost:7098/api/Berria");
            using (var httpClient = new HttpClient())
            {
                StringContent content = new StringContent(JsonConvert.SerializeObject(berria),
                Encoding.UTF8,
                "application/json");
                var response = await httpClient.PostAsync(rutaBezeroEskaera, content);
                response.EnsureSuccessStatusCode();
            }
        }
    }
}
