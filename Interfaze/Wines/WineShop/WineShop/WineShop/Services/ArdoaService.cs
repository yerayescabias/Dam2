using Newtonsoft.Json;
using WineShop.Models;

namespace WineShop.Services
{
    public class ArdoaService : IArdoaService
    {
        //esta es la URL de la restapi y es desde aqui desde donde coge la informacion
        private Uri rutaTodos = new Uri("https://localhost:7065/api/Ardoa/");
        public async Task<IList<ArdoaUpeltegi>> GetMota(int id)
        {
            List<ArdoaUpeltegi> ardoaUpeltegiList = new List<ArdoaUpeltegi>();
            //esto lo que hace es dentro de la restapi, concatenar el URL, donde ponemos
            // el id que queremos mostrar, es decir, si fuera id = 1 sería vino blanc, 2 seria tinto...
            // Lo que hace es darnos la ruta completa dentro de la API
            // para enseñar la lista de vinos que queremos.
            Uri rutaUpeltegiak = new Uri(rutaTodos, "Mota/" + id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaUpeltegiak))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    // hace la conversion del Json para que aparezca en la agina web
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

        public async Task<Ardoa> GetArdoa(int id)
        {
            Ardoa ardoa = new Ardoa();
            Uri rutaArdoBat = new Uri(rutaTodos, id.ToString());
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaArdoBat))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    ardoa = JsonConvert.DeserializeObject<Ardoa>(apiResponse);
                }
            }
            return ardoa;
        }
    }

}

