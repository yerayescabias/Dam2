namespace Ariketa2
{
    partial class zenbakia
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
            hurrengoa = new Button();
            garbitu = new Button();
            irten = new Button();
            label1 = new Label();
            textBox1 = new TextBox();
            SuspendLayout();
            // 
            // hurrengoa
            // 
            hurrengoa.Location = new Point(153, 268);
            hurrengoa.Name = "hurrengoa";
            hurrengoa.Size = new Size(117, 37);
            hurrengoa.TabIndex = 0;
            hurrengoa.Text = "Hurrengoa";
            hurrengoa.UseVisualStyleBackColor = true;
            hurrengoa.Click += hurrengoa_Click;
            // 
            // garbitu
            // 
            garbitu.Location = new Point(328, 268);
            garbitu.Name = "garbitu";
            garbitu.Size = new Size(117, 37);
            garbitu.TabIndex = 1;
            garbitu.Text = "Garbitu";
            garbitu.UseVisualStyleBackColor = true;
            garbitu.Click += garbitu_Click;
            // 
            // irten
            // 
            irten.Location = new Point(507, 268);
            irten.Name = "irten";
            irten.Size = new Size(117, 37);
            irten.TabIndex = 2;
            irten.Text = "button3";
            irten.UseVisualStyleBackColor = true;
            irten.Click += irten_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(232, 129);
            label1.Name = "label1";
            label1.Size = new Size(0, 15);
            label1.TabIndex = 3;
            label1.Click += label1_Click;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(328, 126);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(296, 23);
            textBox1.TabIndex = 4;
            textBox1.TextChanged += textBox1_TextChanged;
            // 
            // zenbakia
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 439);
            Controls.Add(textBox1);
            Controls.Add(label1);
            Controls.Add(irten);
            Controls.Add(garbitu);
            Controls.Add(hurrengoa);
            Name = "zenbakia";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button hurrengoa;
        private Button garbitu;
        private Button irten;
        private Label label1;
        private TextBox textBox1;
    }
}