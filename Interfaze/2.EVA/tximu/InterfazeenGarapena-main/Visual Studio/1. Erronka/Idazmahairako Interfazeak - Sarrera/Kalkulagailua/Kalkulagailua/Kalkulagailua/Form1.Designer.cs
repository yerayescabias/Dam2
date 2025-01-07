namespace Kalkulagailua
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
            btnGehiketa = new Button();
            btnKenketa = new Button();
            btnBiderketa = new Button();
            btnZatiketa = new Button();
            textBox1 = new TextBox();
            textBox2 = new TextBox();
            label1 = new Label();
            label2 = new Label();
            SuspendLayout();
            // 
            // btnGehiketa
            // 
            btnGehiketa.Font = new Font("Segoe UI", 28.2F, FontStyle.Bold, GraphicsUnit.Point);
            btnGehiketa.Location = new Point(284, 197);
            btnGehiketa.Name = "btnGehiketa";
            btnGehiketa.Size = new Size(94, 77);
            btnGehiketa.TabIndex = 0;
            btnGehiketa.Text = "+";
            btnGehiketa.UseVisualStyleBackColor = true;
            btnGehiketa.Click += btnGehiketa_Click;
            // 
            // btnKenketa
            // 
            btnKenketa.Font = new Font("Segoe UI", 28.2F, FontStyle.Bold, GraphicsUnit.Point);
            btnKenketa.Location = new Point(424, 197);
            btnKenketa.Name = "btnKenketa";
            btnKenketa.Size = new Size(94, 77);
            btnKenketa.TabIndex = 1;
            btnKenketa.Text = "-";
            btnKenketa.UseVisualStyleBackColor = true;
            btnKenketa.Click += btnKenketa_Click;
            // 
            // btnBiderketa
            // 
            btnBiderketa.Font = new Font("Segoe UI", 28.2F, FontStyle.Bold, GraphicsUnit.Point);
            btnBiderketa.Location = new Point(284, 308);
            btnBiderketa.Name = "btnBiderketa";
            btnBiderketa.Size = new Size(94, 75);
            btnBiderketa.TabIndex = 2;
            btnBiderketa.Text = "x";
            btnBiderketa.UseVisualStyleBackColor = true;
            btnBiderketa.Click += btnBiderketa_Click;
            // 
            // btnZatiketa
            // 
            btnZatiketa.Font = new Font("Segoe UI", 28.2F, FontStyle.Bold, GraphicsUnit.Point);
            btnZatiketa.Location = new Point(424, 308);
            btnZatiketa.Name = "btnZatiketa";
            btnZatiketa.Size = new Size(94, 75);
            btnZatiketa.TabIndex = 3;
            btnZatiketa.Text = "/";
            btnZatiketa.UseVisualStyleBackColor = true;
            btnZatiketa.Click += btnZatiketa_Click;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(212, 113);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(166, 27);
            textBox1.TabIndex = 4;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(424, 113);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(179, 27);
            textBox2.TabIndex = 5;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 13.8F, FontStyle.Bold, GraphicsUnit.Point);
            label1.Location = new Point(212, 79);
            label1.Name = "label1";
            label1.Size = new Size(147, 31);
            label1.TabIndex = 6;
            label1.Text = "Zenbaki bat:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Segoe UI", 13.8F, FontStyle.Bold, GraphicsUnit.Point);
            label2.Location = new Point(424, 79);
            label2.Name = "label2";
            label2.Size = new Size(133, 31);
            label2.TabIndex = 7;
            label2.Text = "Zenbaki bi:";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(textBox2);
            Controls.Add(textBox1);
            Controls.Add(btnZatiketa);
            Controls.Add(btnBiderketa);
            Controls.Add(btnKenketa);
            Controls.Add(btnGehiketa);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button btnGehiketa;
        private Button btnKenketa;
        private Button btnBiderketa;
        private Button btnZatiketa;
        private TextBox textBox1;
        private TextBox textBox2;
        private Label label1;
        private Label label2;
    }
}