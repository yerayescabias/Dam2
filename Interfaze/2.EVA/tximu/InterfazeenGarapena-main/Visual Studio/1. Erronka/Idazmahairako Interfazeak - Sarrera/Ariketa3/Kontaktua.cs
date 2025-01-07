using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ariketa3
{
    internal class Kontaktua
    {
        public String nan {  get; set; }
        public String izena { get; set; }
        public String abizena { get; set; }

        public virtual String emaila { get; set; }

        public String izenosoa { get => izena + " " + abizena; }
            
        public virtual String Gorde()
        {
            return "Kontaktua ondo gorde da.";
        }

    }
}
