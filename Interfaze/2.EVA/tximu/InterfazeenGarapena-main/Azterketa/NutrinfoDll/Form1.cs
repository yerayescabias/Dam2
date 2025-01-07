using System;
using System.Linq;
using System.Windows.Forms;
using NutrinfoDll;
using NutrinfoForm.Models;

namespace NutrinfoForm
{
    public partial class Form1 : Form
    {
        private NutrinfoControl nutrinfoControl;
        private DataGridView dataGridView1;
        private Button btnMostrarGrafico;

        public Form1()
        {
            InitializeComponent();

            InicializarComponentes();
            nutrinfoControl = new NutrinfoControl
            {
                Location = new System.Drawing.Point(10, 300),
                Size = new System.Drawing.Size(450, 400)
            };
            this.Controls.Add(nutrinfoControl);
            CargarElikagaiak();
        }

        private void InicializarComponentes()
        {
            // Inicializar DataGridView
            dataGridView1 = new DataGridView
            {
                Location = new System.Drawing.Point(10, 10),
                Size = new System.Drawing.Size(500, 200),
                AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill,
                ReadOnly = true,
                SelectionMode = DataGridViewSelectionMode.FullRowSelect
            };
            this.Controls.Add(dataGridView1);

            // Inicializar botón para mostrar gráfico
            btnMostrarGrafico = new Button
            {
                Text = "Mostrar Información",
                Location = new System.Drawing.Point(10, 220),
                Size = new System.Drawing.Size(200, 30)
            };
            btnMostrarGrafico.Click += BtnMostrarGrafico_Click;
            this.Controls.Add(btnMostrarGrafico);
        }

        private void CargarElikagaiak()
        {
            using (var context = new NutrinfoContext())
            {
                var elikagaiak = context.Elikagaiak.ToList();
                dataGridView1.DataSource = elikagaiak;
            }
        }

        private void BtnMostrarGrafico_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count != 1)
            {
                MessageBox.Show("Selecciona un solo elikagai.");
                return;
            }

            int elikagaiaId = (int)dataGridView1.SelectedRows[0].Cells["Id"].Value;
            using (var context = new NutrinfoContext())
            {
                var datos = (from info in context.Informazioak
                             join osa in context.Osagaiak on info.OsagaiaId equals osa.Id
                             where info.ElikagaiaId == elikagaiaId
                             group info by osa.Izena into grupo
                             select new
                             {
                                 Nombre = grupo.Key,
                                 Cantidad = grupo.Sum(x => x.Kantitatea)
                             }).ToList();

                nutrinfoControl.CargarDatos(
                    datos.Select(d => d.Nombre).ToArray(),
                    datos.Select(d => d.Cantidad).ToArray());
            }
        }
    }
}
