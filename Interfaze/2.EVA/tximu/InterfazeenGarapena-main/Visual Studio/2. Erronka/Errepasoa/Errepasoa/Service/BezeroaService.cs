using Errepasoa.Models;
using Newtonsoft.Json;
using System.Net.Http;
using System.Text;

namespace Errepasoa.Service
{
    public class BezeroaService : IBezeroaService
    {
        public async Task BezeroaSortu(Bezeroa bezeroa)
        {
            // aqui ponemos la ruta de la restapi que hace post del modelo que estamos usando.
            Uri rutaBezeroa = new Uri("https://localhost:44371/api/BezeroaEskaera");
            using(var httpClient = new HttpClient())
            {
                StringContent content = new StringContent(JsonConvert.SerializeObject(bezeroa), Encoding.UTF8,
                "application/json");
                var response = await httpClient.PostAsync(rutaBezeroa, content);
                response.EnsureSuccessStatusCode();
            }
        }
    }
}
