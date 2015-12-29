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
    
    public partial class Form1 : Form
    {
        public static OleDbConnection baglanti;
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            baglanti = new OleDbConnection("Provider=Microsoft.ACE.OLEDB.12.0; Data Source=otopark.accdb");
            baglanti.Open();
            OleDbCommand giris = new OleDbCommand("SELECT * FROM parola WHERE parola='" + textBox1.Text + "'", baglanti);
            OleDbDataReader oku = giris.ExecuteReader();
            
            if (oku.Read())
            {
                baglanti.Close();
                Form2 yeni = new Form2();
                yeni.Show();
                this.Hide();
            }
            else
            {
                MessageBox.Show("Girdiğiniz şifre yanlış!");
            }
            baglanti.Close();

        }

      
    }
}
