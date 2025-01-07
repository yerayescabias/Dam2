using System;

namespace Ariketa2
{
    internal class Class1
    {
        private float[] zenbakiak = new float[4]; // Zenbakiak array bihurtu

        public float[] Zenbakiak
        {
            get { return zenbakiak; }
            set { zenbakiak = value; }
        }

        public Class1()
        {

        }

        public double Eragiketa()
        {
            // Array-a erabiliz formula aplikatu
            float a = zenbakiak[0];
            float b = zenbakiak[1];
            float c = zenbakiak[2];
            float d = zenbakiak[3];

            return (a + 2 * b + 3 * c + 4 * d) / 4;
        }

        public string Emaitza()
        {
            // Array-a erabiliz emaitza sortu
            float a = zenbakiak[0];
            float b = zenbakiak[1];
            float c = zenbakiak[2];
            float d = zenbakiak[3];

            return "(" + a + " + 2 * " + b + " + 3 * " + c + " + 4 * " + d + ") / 4 = " + Eragiketa();
        }
    }
}
