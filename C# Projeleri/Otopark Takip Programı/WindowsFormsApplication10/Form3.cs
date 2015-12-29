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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Load(object sender, EventArgs e)
        {
           label3.Text = DateTime.Now.ToString();
   
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form1.baglanti.Open();
            OleDbCommand kaydet = new OleDbCommand("insert into arac (plaka,musteri,teslim_alan,alinan_tarih) values('" + textBox1.Text + "','" + textBox2.Text + "','"+ textBox3.Text + "','" + label3.Text + "')", Form1.baglanti);
            kaydet.ExecuteNonQuery();
            MessageBox.Show("Başarıyla kaydedildi!");
            Form1.baglanti.Close();
            this.Close();
        
        }

       
    }
}
