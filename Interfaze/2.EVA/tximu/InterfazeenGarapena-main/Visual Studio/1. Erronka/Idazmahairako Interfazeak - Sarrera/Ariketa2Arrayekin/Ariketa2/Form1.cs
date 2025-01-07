using System;
using System.Windows.Forms;

namespace Ariketa2
{
    public partial class zenbakia : Form
    {
        int x = 1;
        float[] zenbakiak = new float[4]; // Zenbakiak array bihurtu

        public zenbakia()
        {
            InitializeComponent();
            label1.Text = x + ". Zenbakia";
        }

        private void hurrengoa_Click(object sender, EventArgs e)
        {
            string zenbakiaStr = textBox1.Text;

            if (float.TryParse(zenbakiaStr, out float zenbakia)) // Zenbakia sartu da
            {
                zenbakiak[x - 1] = zenbakia; // Zenbakia array-an gorde
                x++;
                textBox1.ResetText();
                label1.Text = x + ". Zenbakia";
                if (x == 5)
                {
                    Class1 klasea = new Class1();
                    klasea.Zenbakiak = zenbakiak; // Array-a Klasean ezarri
                    double emaitza = klasea.Eragiketa();
                    label1.Text = "Emaitza: " + emaitza.ToString();
                    textBox1.Text = klasea.Emaitza();
                }
            }
            else
            {
                MessageBox.Show("Zenbakia sartu mesedez.", "Errorea", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void garbitu_Click(object sender, EventArgs e)
        {
            Application.Restart();
        }

        private void irten_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
