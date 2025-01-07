using Newtonsoft.Json;
using WineShop.NET_6._0.Models;

namespace WineShop.NET_6._0.Service
{
    public class ArdoaService : IArdoaService
    {
        //Rest api-aren Url-a jarri, portua ezberdina izan daiteke
        private Uri rutaTodos = new Uri("https://localhost:7049/api/Ardoa/");
        public async Task<IList<ArdoaUpeltegi>> GetMota(int id)
        {
            List<ArdoaUpeltegi> ardoaUpeltegiList = new List<ArdoaUpeltegi>();
            Uri rutaUpeltegiak = new Uri(rutaTodos, "Mota/" + id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaUpeltegiak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    ardoaUpeltegiList = JsonConvert.DeserializeObject<List<ArdoaUpeltegi>>(apiResponse);
                }
            }
            return ardoaUpeltegiList;
        }
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
