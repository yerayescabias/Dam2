using System;
using System.Windows.Forms;

namespace Esaldiak
{
    public partial class Form1 : Form
    {
        private Esaldia esaldiakKlasea = new Esaldia();

        public Form1()
        {
            InitializeComponent();
            esaldi1.Enabled = true;
            esaldi2.Enabled = false;
            esaldi3.Enabled = false;
            button4.Enabled = false;
            esaldi5.Enabled = false;
            lotu.Enabled = false;
            textBox1.Focus();
        }

        private void esaldi1_Click(object sender, EventArgs e)
        {
            textBox1.Focus();
            esaldi1.Enabled = true;
            String esaldia1 = textBox1.Text;
            esaldiakKlasea.GehituEsaldia(esaldia1);
            esaldi1.Enabled = false;
            esaldi2.Enabled = true;
            textBox1.Clear();

        }

        private void esaldi2_Click(object sender, EventArgs e)
        {
            textBox1.Focus();
            String esaldia2 = textBox1.Text;
            esaldiakKlasea.GehituEsaldia(esaldia2);
            esaldi2.Enabled = false;
            esaldi3.Enabled = true;
            textBox1.Clear();
        }

        private void esaldi3_Click(object sender, EventArgs e)
        {
            textBox1.Focus();
            String esaldia3 = textBox1.Text;
            esaldiakKlasea.GehituEsaldia(esaldia3);
            esaldi3.Enabled = false;
            button4.Enabled = true;
            textBox1.Clear();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            textBox1.Focus();
            String esaldia4 = textBox1.Text;
            esaldiakKlasea.GehituEsaldia(esaldia4);
            button4.Enabled = false;
            esaldi5.Enabled = true;
            textBox1.Clear();
        }

        private void esaldi5_Click(object sender, EventArgs e)
        {
            String esaldia5 = textBox1.Text;
            esaldiakKlasea.GehituEsaldia(esaldia5);
            esaldi5.Enabled = false;
            lotu.Enabled = true;
            textBox1.Clear();
        }

        private void lotu_Click(object sender, EventArgs e)
        {
            textBox1.Enabled = false;
            string esaldiak = esaldiakKlasea.EsaldiOsoa();
            MessageBox.Show(esaldiak);
            lotu.Enabled = false;
        }

        private void itxi_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void garbitu_Click(object sender, EventArgs e)
        {
            Application.Restart();
        }
    }
}
