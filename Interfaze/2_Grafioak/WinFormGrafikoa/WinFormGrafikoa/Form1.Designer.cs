namespace WinFormGrafikoa
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.grafikoa1 = new WindowsFormsControlLibrary1.Grafikoa();
            this.SuspendLayout();
            // 
            // grafikoa1
            // 
            this.grafikoa1.Location = new System.Drawing.Point(1, 1);
            this.grafikoa1.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.grafikoa1.Name = "grafikoa1";
            this.grafikoa1.Size = new System.Drawing.Size(787, 448);
            this.grafikoa1.TabIndex = 0;
            this.grafikoa1.Load += new System.EventHandler(this.grafikoa1_Load);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.grafikoa1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private WindowsFormsControlLibrary1.Grafikoa grafikoa1;
    }
}

