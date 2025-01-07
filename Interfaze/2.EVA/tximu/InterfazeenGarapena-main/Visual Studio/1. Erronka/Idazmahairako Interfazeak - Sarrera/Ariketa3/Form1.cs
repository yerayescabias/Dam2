namespace Ariketa3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnGorde_Click(object sender, EventArgs e)
        {
            if (radiobtnKontaktua.Checked)
            {
                KontaktuaSortu();
            }
            else if (radiobtnBezeroa.Checked)
            {
                BezeroaSortu();
            }
            else if (radiobtnLangilea.Checked)
            {
                LangileaSortu();
            }
            else
            {
                MessageBox.Show("Kontaktua, bezeroa edo langilea zaren aukeratu");
            }
        }

        private void KontaktuaSortu()
        {
            Kontaktua kontaktua = new Kontaktua();
            kontaktua.izena = txtboxIzena.Text;
            kontaktua.abizena = txtboxAbizena.Text;
            kontaktua.nan = txtboxNan.Text;
            kontaktua.emaila = txtboxEmail.Text;
            MessageBox.Show(kontaktua.Gorde());
        }

        private void BezeroaSortu()
        {
            Bezeroa bezeroa = new Bezeroa();
            bezeroa.izena = txtboxIzena.Text;
            bezeroa.abizena = txtboxAbizena.Text;
            bezeroa.nan = txtboxNan.Text;
            bezeroa.emaila = txtboxEmail.Text;
            bezeroa.kategoria = comboboxKategoria.Text;
            MessageBox.Show(bezeroa.Gorde());
        }

        private void LangileaSortu()
        {
            Langile langilea = new Langile();
            langilea.izena = txtboxIzena.Text;
            langilea.abizena = txtboxAbizena.Text;
            langilea.nan = txtboxNan.Text;
            langilea.emaila = txtboxEmail.Text;
            langilea.soldata = txtboxSoldata.Text;
            langilea.segurtasunSoziala = txtboxSegurtasunSoziala.Text;
            MessageBox.Show(langilea.Gorde());
        }

        private void btnIrten_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}