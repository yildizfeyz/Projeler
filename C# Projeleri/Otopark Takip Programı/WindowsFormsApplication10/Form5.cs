using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.OleDb;

namespace WindowsFormsApplication10
{
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

       
        private void button1_Click(object sender, EventArgs e)
        {
            Form1.baglanti.Open();
            OleDbCommand kaydet = new OleDbCommand("Update tarife set ucret='" + textBox1.Text + "' where tarife = '" + comboBox1.Text + "'",Form1.baglanti);
            kaydet.ExecuteNonQuery();
            Form1.baglanti.Close();
            MessageBox.Show("Tarife başarıyla güncellendi...");
            panel1.Hide();
            comboBox1.Text = "";
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            panel1.Visible = true;
            Form1.baglanti.Open();
            OleDbCommand secim = new OleDbCommand("SELECT * FROM tarife where tarife='" + comboBox1.Text + "'", Form1.baglanti);
            OleDbDataReader oku;
            oku = secim.ExecuteReader();
            while (oku.Read())
            {

                textBox1.Text = oku["ucret"].ToString();

            }
            Form1.baglanti.Close();
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            panel1.Hide();
        }
    }
}
