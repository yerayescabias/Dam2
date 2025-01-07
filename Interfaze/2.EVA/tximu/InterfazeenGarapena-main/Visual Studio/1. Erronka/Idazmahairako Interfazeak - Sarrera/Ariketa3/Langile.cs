using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace Ariketa3
{
    internal class Langile : Bezeroa
    {
        public string soldata {  get; set; }
        public string segurtasunSoziala { get; set; }

        public override string emaila 
        {
            get => base.emaila;
            set
            {
                try
                {
                    if (value.Substring(value.Length - 14, 14) != "@uni.eus")
                    {
                        base.emaila = value;
                    };
                } 
                catch 
                {
                    Exception ex = new Exception("Emaila ez duzu ondo jarri");
                    throw ex;
                }
            }
        }

        public override string Gorde()
        {
            return "Langilea ondo gorde da";
        }
    }
}
