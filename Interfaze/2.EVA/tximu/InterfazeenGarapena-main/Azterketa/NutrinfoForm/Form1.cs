using NutrinfoDll;
using NutrinfoForm.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace NutrinfoForm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            using (var db = new NutrinfoDbContext())
            {
                var elikagaiData = db.Elikagaia.ToList();

                if (elikagaiData != null)
                {
                    if (elikagaiData.Count > 0)
                    {
                        try
                        {
                            dataGridView1.DataSource = elikagaiData;
                            dataGridView1.Columns["Key"].DataPropertyName = "Key";
                            dataGridView1.Columns["Value"].DataPropertyName = "Value";
                        }
                        catch
                        {
                            //Errore posiblea pasa
                        }            
                    }
                }
            }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 1) {
                DataGridViewRow lerroa = dataGridView1.SelectedRows[0];
                int aukeratuId = (int)lerroa.Cells["Id"].Value;

                using (var db = new NutrinfoDbContext())
                {
                    var informazioData = db.Informazioa
                    .Include("Osagaia")
                    .Where(i => i.ElikagaiaId == aukeratuId)
                    .GroupBy(b => b.osagaia.Izena)
                    .ToDictionary(g => g.Key, g => g.Sum(i => i.Kantitatea));

                    if (informazioData != null)
                    {
                        if (informazioData.Count > 0)
                        {
                            var kontrolak = userControl1.Controls.OfType<Chart>();
                            foreach (var kontrola in kontrolak)
                            {
                                kontrola.DataSource = informazioData;
                                kontrola.Series[0].YValueMembers = "Value";
                                kontrola.Series[0].XValueMember = "Key";
                                kontrola.DataBind();
                            }
                        }
                    }
                }
            } else
            {
                MessageBox.Show("Mesedez, elikagai bat aukeratu behar duzu, eta ez gehiago.");
            }
        }
    }
}
