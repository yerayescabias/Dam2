using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ariketa2
{
    internal class Class1
    {
        public float a { get; set; }
        public float b { get; set; }
        public float c { get; set; }
        public float d { get; set; }

        public Class1(float a, float b, float c, float d)
        {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public Class1()
        {

        }

        float[] zenbakiak = new float[4];
        public float[] Zenbakiak
        {
            get
            {
                return zenbakiak;
            }
            set
            {
                zenbakiak = value;
            }
        }
        public float Eragiketa()
        {
            return (a + 2 * b + 3 * c + 4 * d) / 4;
        }

        public String Emaitza()
        {
            return "(" + a + " + 2 * " + b + " + 3 * " + c + " + 4 * " + d + ") / 4 = " + Eragiketa();
        }
    }
}
