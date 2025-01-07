namespace Kalkulagailua
{
    public partial class Form1 : Form
    {
        Kalkulagailua kalkulagailua = new Kalkulagailua();

        public Form1()
        {
            InitializeComponent();
        }

        private void btnGehiketa_Click(object sender, EventArgs e)
        {
            try
            {
                balidazioa();
                MessageBox.Show(kalkulagailua.Gehiketa().ToString());
            } catch (Exception)
            {
                MessageBox.Show("Zenbakiak sartu");
            }
        }

        private void btnKenketa_Click(object sender, EventArgs e)
        {
            try
            {
                balidazioa();
                MessageBox.Show(kalkulagailua.Kenketa().ToString());
            }
            catch (Exception)
            {
                MessageBox.Show("Zenbakiak sartu");
            }
        }

        private void btnZatiketa_Click(object sender, EventArgs e)
        {
            try
            {
                balidazioa();
                MessageBox.Show(kalkulagailua.Zatiketa().ToString());
            }
            catch (Exception)
            {
                MessageBox.Show("Zenbakiak sartu");
            }
        }

        private void btnBiderketa_Click(object sender, EventArgs e)
        {
            try
            {
                balidazioa();
                MessageBox.Show(kalkulagailua.Biderketa().ToString());
            }
            catch (Exception)
            {
                MessageBox.Show("Zenbakiak sartu");
            }
        }

        private void balidazioa()
        {
            kalkulagailua.Zenbaki1 = float.Parse(textBox1.Text);
            kalkulagailua.Zenbaki2 = float.Parse(textBox2.Text);
        }

    }
}