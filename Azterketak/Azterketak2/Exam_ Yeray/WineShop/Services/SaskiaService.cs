using Newtonsoft.Json;
using System.Net.Http;
using System.Text;
using WineShop.Models;

namespace WineShop.Services
{
    public class SaskiaService : ISaskiaService
    {
        private Uri rutaTodos = new Uri("https://localhost:44371/api/SaskiaAlea/"); //Portua restapi-ko berdina izan behar da. 
        private readonly IArdoaService _ardoaService;
        public SaskiaService(IArdoaService ardoaService)
        {
            _ardoaService = ardoaService;
        }
        public async Task SaskiaGehitu(int ardoaId, string saskiaId)
        {
            // Define the cart URI
            Uri rutasaskia = new Uri(rutaTodos, saskiaId);
            List<SaskiaAlea> saskiaAleaList = new List<SaskiaAlea>();

            // Fetch existing cart items
            using (var httpClient = new HttpClient())
            {
                var response = await httpClient.GetAsync(rutasaskia);
                response.EnsureSuccessStatusCode();

                string apiResponse = await response.Content.ReadAsStringAsync();
                saskiaAleaList = JsonConvert.DeserializeObject<List<SaskiaAlea>>(apiResponse);
            }

            // Check if the item already exists in the cart
            var cartItem = saskiaAleaList?.FirstOrDefault(s => s.ArdoaId == ardoaId);

            if (cartItem == null)
            {
                // Item does not exist in the cart, add a new one
                var newCartItem = new SaskiaAlea
                {
                    ArdoaId = ardoaId,
                    SaskiaId = saskiaId,
                    Kantitatea = 1,
                    Data = DateTime.Now
                };

                using (var httpClient = new HttpClient())
                {
                    var content = new StringContent(JsonConvert.SerializeObject(newCartItem), Encoding.UTF8, "application/json");
                    var response = await httpClient.PostAsync(rutaTodos, content);
                    response.EnsureSuccessStatusCode();
                }
            }
            else
            {
                // Item exists, increase quantity
                cartItem.Kantitatea++;

                using (var httpClient = new HttpClient())
                {
                    var content = new StringContent(JsonConvert.SerializeObject(cartItem), Encoding.UTF8, "application/json");
                    var response = await httpClient.PutAsync(rutasaskia, content);
                    response.EnsureSuccessStatusCode();
                }
            }
        }

        public async Task SaskiaKendu(int ardoaId, string saskiaId)
        {
            // Retrieve the basket items
            Uri rutasaskia = new Uri(rutaTodos, saskiaId);
            List<SaskiaAlea> saskiaAleaList = new List<SaskiaAlea>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutasaskia))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    saskiaAleaList = JsonConvert.DeserializeObject<List<SaskiaAlea>>(apiResponse);
                }
            }

            var cartItem = saskiaAleaList?.FirstOrDefault(s => s.ArdoaId == ardoaId);

            if (cartItem != null)
            {
                if (cartItem.Kantitatea >= 1)
                {
                    // Decrease the quantity
                    cartItem.Kantitatea--;
                    using (var httpClient = new HttpClient())
                    {
                        StringContent content = new StringContent(JsonConvert.SerializeObject(cartItem), Encoding.UTF8, "application/json");
                        var response = await httpClient.PutAsync(rutasaskia, content);
                        response.EnsureSuccessStatusCode();
                    }
                }
                else
                {
                    // Remove the item if the quantity is 1
                    Uri deleteUri = new Uri($"{rutaTodos}{saskiaId}/{ardoaId}");
                    using (var httpClient = new HttpClient())
                    {
                        var response = await httpClient.DeleteAsync(deleteUri);
                        response.EnsureSuccessStatusCode();
                    }
                }
            }
        }


        public async Task<List<SaskiaAlea>> SaskiaLortuAleak(string saskiaId)
        {
            //Saskia lortu
            Uri rutasaskia = new Uri(rutaTodos, saskiaId);
            List<SaskiaAlea> saskiaAleaList = new List<SaskiaAlea>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutasaskia))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    saskiaAleaList = JsonConvert.DeserializeObject<List<SaskiaAlea>>(apiResponse);
                }
            }
            return saskiaAleaList;
        }

        public async Task EskaeraBezeroaGehitu(BezeroaEskaera bezeroaEskaera)
        {
            Uri rutaBezeroEskaera = new Uri("https://localhost:44371/api/BezeroaEskaera/");
            using (var httpClient = new HttpClient())
            {
                StringContent content = new StringContent(JsonConvert.SerializeObject(bezeroaEskaera), Encoding.UTF8,
                "application/json");
                var response = await httpClient.PostAsync(rutaBezeroEskaera, content);
                response.EnsureSuccessStatusCode();
            }
        }

        public async Task EskaeraSortu(BezeroaEskaera bezeroaEskaera, string saskiaId)
        {
            var cartItems = await SaskiaLortuAleak(saskiaId);
            foreach (var item in cartItems)
            {
                var erosketa = new Erosketa
                {
                    ArdoaId = item.ArdoaId,
                    BezeroaEskaeraId = bezeroaEskaera.Id,
                    Kantitatea = item.Kantitatea
                };
                Uri rutaErosketa = new Uri("https://localhost:44371/api/Erosketa/");
                using (var httpClient = new HttpClient())
                {
                    StringContent content = new StringContent(JsonConvert.SerializeObject(erosketa), Encoding.UTF8,
                    "application/json");
                    var response = await httpClient.PostAsync(rutaErosketa, content);
                    response.EnsureSuccessStatusCode();
                }
            }
        }
    }
}
