using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace Ariketa2
{
    public partial class zenbakia : Form
    {
        int x = 1;
        List<Ariketa2> zenbakiak = new List<Ariketa2>(); // List to store Ariketa2 objects

        public zenbakia()
        {
            InitializeComponent();
            label1.Text = x + ". Zenbakia";
        }

        private void hurrengoa_Click(object sender, EventArgs e)
        {
            string zenbakiaStr = textBox1.Text;

            if (double.TryParse(zenbakiaStr, out double zenbakia)) // Zenbakia sartu da
            {
                zenbakiak.Add(new Ariketa2 { Label = x + ". Zenbakia", Zenbakia = zenbakia }); // Add Ariketa2 object to the list
                x++;
                textBox1.ResetText();
                label1.Text = x + ". Zenbakia";
                if (x == 5)
                {
                    double emaitza = Ariketa2.eragiketa(zenbakiak); // Calculate the result using the method in Class1
                    textBox1.Text = Ariketa2.Emaitza(zenbakiak); // Display the entire operation in TextBox
                    label1.Text = "Emaitza";
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
