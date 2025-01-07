namespace Ariketa2
{
    public partial class zenbakia : Form
    {
        int x = 1;
        int a, b, c, d;
        public zenbakia()
        {
            InitializeComponent();
            label1.Text = x + ".Zenbakia";

        }

        private void hurrengoa_Click(object sender, EventArgs e)
        {
            string zenbakiaStr = textBox1.Text;

            if (int.TryParse(zenbakiaStr, out int zenbakia)) // Zenbakia sartu da
            {
                if (x == 1) a = zenbakia;
                else if (x == 2) b = zenbakia;
                else if (x == 3) c = zenbakia;
                else if (x == 4) d = zenbakia;

                x++;
                textBox1.ResetText();
                label1.Text = x + ".Zenbakia";
                if (x == 5)
                {
                    Class1 klasea = new Class1(a, b, c, d);
                    double emaitza = klasea.Eragiketa();
                    label1.Text = "Emaitza ";
                    textBox1.Text = klasea.Emaitza();
                }
                else if (textBox1.Text == null)
                {
                    MessageBox.Show("Zenbakia sartu mesedez.", "Errorea", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
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