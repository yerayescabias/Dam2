﻿using Newtonsoft.Json;
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
            //Saskia existitzen den begiratu
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
            SaskiaAlea cartitem = new SaskiaAlea();
            cartitem = null;
            if (saskiaAleaList != null)
            {
                cartitem = saskiaAleaList.FirstOrDefault(s => s.ArdoaId == ardoaId);
            }
            if (saskiaAleaList == null || cartitem == null)
            {
                using (var httpClient = new HttpClient())
                {
                    StringContent content = new StringContent(JsonConvert.SerializeObject(new SaskiaAlea
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
                    StringContent content = new StringContent(JsonConvert.SerializeObject(cartitem), Encoding.UTF8,
                    "application/json");
                    var response = await httpClient.PutAsync(rutasaskia, content);
                    response.EnsureSuccessStatusCode();
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
