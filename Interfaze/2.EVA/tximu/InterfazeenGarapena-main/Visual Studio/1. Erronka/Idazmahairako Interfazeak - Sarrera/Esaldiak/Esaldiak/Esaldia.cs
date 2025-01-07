using System;

namespace Esaldiak
{
    public class Esaldia
    {
        private string esaldia = "";

        public void GehituEsaldia(string esaldiaBerria)
        {
            esaldia += esaldiaBerria + " ";
        }

        public string EsaldiOsoa()
        {
            return esaldia;
        }
    }
}
