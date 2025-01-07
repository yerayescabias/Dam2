﻿using System.Text;
using Newtonsoft.Json;
using WineShop.NET_6._0.Models;

namespace WineShop.NET_6._0.Service
{
    public class SaskiaService
    {
        private Uri rutaTodos = new Uri("https://localhost:44367/api/SaskiaAlea/");
        private readonly IArdoaService _ardoaService;
        public SaskiaService(IArdoaService ardoaService)
        {
            _ardoaService = ardoaService;
        }
        public async Task SaskiaGehitu(int ardoaId, string saskiaId)
        {
            //Saskia existitzen den begiratu
            Uri rutasaskia = new Uri(rutaTodos, saskiaId);
            List<SaskiaAleak> saskiaAleaList = new List<SaskiaAleak>();
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutasaskia))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    saskiaAleaList = JsonConvert.DeserializeObject<List<SaskiaAleak>>(apiResponse);
                }
            }
            SaskiaAleak cartitem = new SaskiaAleak();
            cartitem = null;
            if (saskiaAleaList != null)
            {
                cartitem = saskiaAleaList.FirstOrDefault(s => s.ArdoaId == ardoaId);
            }

            if (saskiaAleaList == null || cartitem == null)
            {
                // Karrito berria sortu
                using (var httpClient = new HttpClient())
                {
                    StringContent content = new StringContent(JsonConvert.SerializeObject(new SaskiaAleak
                    {
                        ArdoaId = ardoaId,
                        SaskiaId = saskiaId,
                        Kantitatea = 1,
                        Data = DateTime.Now
                    }), Encoding.UTF8, "application/json");
                    var response = await httpClient.PostAsync(rutaTodos, content);
                    response.EnsureSuccessStatusCode();
                }
            }
            else
            {
                cartitem.Kantitatea++;
                using (var httpClient = new HttpClient())
                {
                    StringContent content = new StringContent(JsonConvert.SerializeObject(cartitem), Encoding.UTF8, "application/json");
                    var response = await httpClient.PutAsync(rutasaskia, content);
                    response.EnsureSuccessStatusCode();
                }
            }
        }
    }
}
