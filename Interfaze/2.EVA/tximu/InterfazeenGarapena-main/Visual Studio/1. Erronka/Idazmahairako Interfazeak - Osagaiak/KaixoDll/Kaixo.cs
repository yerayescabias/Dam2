using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace KaixoDll
{
    public partial class Kaixo: UserControl
    {
        public Kaixo()
        {
            InitializeComponent();
        }

        public string MezuaIkusi()
        {
            return "Kaixo Mundua";
        }

        private void UserControl1_Load(object sender, EventArgs e)
        {

        }
    }
}
