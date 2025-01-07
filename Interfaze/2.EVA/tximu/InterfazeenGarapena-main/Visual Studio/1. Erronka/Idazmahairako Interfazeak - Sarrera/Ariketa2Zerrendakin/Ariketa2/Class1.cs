using System;
using System.Collections.Generic;

namespace Ariketa2
{
    public class Ariketa2
    {
        public string Label { get; set; }
        public double Zenbakia { get; set; }
        public Ariketa2()
        {

        }

        public static double eragiketa(List<Ariketa2> objektuak)
        {
            double emaitza = 0;

            foreach (Ariketa2 objektua in objektuak)
            {
                emaitza += objektua.Zenbakia;
            }

            return emaitza / objektuak.Count;
        }

        public static string Emaitza(List<Ariketa2> objektuak)
        {
            string emaitza = "(";

            for (int i = 0; i < objektuak.Count; i++)
            {
                emaitza += objektuak[i].Zenbakia;

                if (i < objektuak.Count - 1)
                {
                    emaitza += " + ";
                }
            }

            emaitza += ") / " + objektuak.Count + " = " + eragiketa(objektuak);

            return emaitza;
        }
    }
}

