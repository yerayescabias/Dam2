namespace Esaldiak
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            esaldi1 = new Button();
            esaldi2 = new Button();
            esaldi3 = new Button();
            button4 = new Button();
            esaldi5 = new Button();
            lotu = new Button();
            textBox1 = new TextBox();
            garbitu = new Button();
            itxi = new Button();
            SuspendLayout();
            // 
            // esaldi1
            // 
            esaldi1.Location = new Point(138, 200);
            esaldi1.Name = "esaldi1";
            esaldi1.Size = new Size(126, 41);
            esaldi1.TabIndex = 0;
            esaldi1.Text = "Esaldi 1";
            esaldi1.UseVisualStyleBackColor = true;
            esaldi1.Click += esaldi1_Click;
            // 
            // esaldi2
            // 
            esaldi2.Location = new Point(327, 200);
            esaldi2.Name = "esaldi2";
            esaldi2.Size = new Size(131, 41);
            esaldi2.TabIndex = 1;
            esaldi2.Text = "Esaldi 2";
            esaldi2.UseVisualStyleBackColor = true;
            esaldi2.Click += esaldi2_Click;
            // 
            // esaldi3
            // 
            esaldi3.Location = new Point(527, 200);
            esaldi3.Name = "esaldi3";
            esaldi3.Size = new Size(122, 41);
            esaldi3.TabIndex = 2;
            esaldi3.Text = "Esaldi 3";
            esaldi3.UseVisualStyleBackColor = true;
            esaldi3.Click += esaldi3_Click;
            // 
            // button4
            // 
            button4.Location = new Point(138, 268);
            button4.Name = "button4";
            button4.Size = new Size(126, 43);
            button4.TabIndex = 3;
            button4.Text = "Esaldi 4";
            button4.UseVisualStyleBackColor = true;
            button4.Click += button4_Click;
            // 
            // esaldi5
            // 
            esaldi5.Location = new Point(327, 268);
            esaldi5.Name = "esaldi5";
            esaldi5.Size = new Size(131, 43);
            esaldi5.TabIndex = 4;
            esaldi5.Text = "Esaldi 5";
            esaldi5.UseVisualStyleBackColor = true;
            esaldi5.Click += esaldi5_Click;
            // 
            // lotu
            // 
            lotu.Location = new Point(527, 268);
            lotu.Name = "lotu";
            lotu.Size = new Size(122, 43);
            lotu.TabIndex = 5;
            lotu.Text = "Lotu";
            lotu.UseVisualStyleBackColor = true;
            lotu.Click += lotu_Click;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(177, 145);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(432, 27);
            textBox1.TabIndex = 6;
            // 
            // garbitu
            // 
            garbitu.Location = new Point(238, 334);
            garbitu.Name = "garbitu";
            garbitu.Size = new Size(126, 43);
            garbitu.TabIndex = 7;
            garbitu.Text = "Garbitu";
            garbitu.UseVisualStyleBackColor = true;
            garbitu.Click += garbitu_Click;
            // 
            // itxi
            // 
            itxi.Location = new Point(434, 334);
            itxi.Name = "itxi";
            itxi.Size = new Size(126, 43);
            itxi.TabIndex = 8;
            itxi.Text = "Itxi";
            itxi.UseVisualStyleBackColor = true;
            itxi.Click += itxi_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(itxi);
            Controls.Add(garbitu);
            Controls.Add(textBox1);
            Controls.Add(lotu);
            Controls.Add(esaldi5);
            Controls.Add(button4);
            Controls.Add(esaldi3);
            Controls.Add(esaldi2);
            Controls.Add(esaldi1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button esaldi1;
        private Button esaldi2;
        private Button esaldi3;
        private Button button4;
        private Button esaldi5;
        private Button lotu;
        private TextBox textBox1;
        private Button garbitu;
        private Button itxi;
    }
}