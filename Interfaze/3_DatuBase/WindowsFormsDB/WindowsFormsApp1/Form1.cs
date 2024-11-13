using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void grafikoa1_Load(object sender, EventArgs e)
        {
            using (var db = new SalmentaDbContext())
            {
                //bigarren grafikoa
                var salmentaData = db.Salmenta
               .Include("Bezeroa")
                .GroupBy(b => b.Bezeroa.Izena)
                .ToDictionary(g => g.Key, g => g.Sum(b => b.Zenbatekoa));
                if (salmentaData != null)
                {
                    if (salmentaData.Count > 0)
                    {
                        var kontrolak = grafikoa1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
                        foreach (var kontrola in kontrolak)
                        {
                            kontrola.Titles[0].Text = "SALMENTA GEHIENGO BEZEROAK";
                            kontrola.DataSource = salmentaData;
                            kontrola.Series[0].YValueMembers = "Value";
                            kontrola.Series[0].XValueMember = "Key";
                            kontrola.DataBind();
                        }
                    }
                }

            }

            /*List<Datuak> datuak = new List<Datuak>();
            datuak.Add(new Datuak() { gakoa = 1, balioa = 24 });
            datuak.Add(new Datuak() { gakoa = 2, balioa = 31 });
            datuak.Add(new Datuak() { gakoa = 3, balioa = 63 });
            var kontrolak = grafikoa1.Controls.OfType<System.Windows.Forms.DataVisualization.Charting.Chart>();
            foreach (var kontrola in kontrolak)
            {
                kontrola.Titles[0].Text = "HELMUGA TURISTIKO NAGUSIAK";
                kontrola.DataSource = datuak;
                kontrola.Series[0].YValueMembers = "balioa";
                kontrola.Series[0].XValueMember = "gakoa";
                kontrola.DataBind();
            }*/
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            using (var db = new SalmentaDbContext())
            {
                var bezeroaData = db.Bezeroa
                .Include("Saltzailea")
                .GroupBy(b => b.Saltzailea.Izena)
                .ToDictionary(g => g.Key, g => g.Count());
                if (bezeroaData != null)
                {
                    if (bezeroaData.Count > 0)
                    {
                        chart1.DataSource = bezeroaData;
                        chart1.Series[0].YValueMembers = "Value";
                        chart1.Series[0].XValueMember = "Key";
                        chart1.DataBind();
                    }
                }
            }
            
        }
    }
    
}
