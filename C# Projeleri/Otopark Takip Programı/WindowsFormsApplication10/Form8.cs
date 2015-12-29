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
    public partial class Form8 : Form
    {
        public Form8()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox2.Text == textBox3.Text)
            {
                Form1.baglanti.Open();
                OleDbCommand secim = new OleDbCommand("select * from parola" ,Form1.baglanti);
                OleDbDataReader kontrol;
                kontrol = secim.ExecuteReader();
                kontrol.Read();
                if (textBox1.Text == kontrol["parola"].ToString())
                {
                    OleDbCommand degistir = new OleDbCommand("update parola set parola='" + textBox2.Text + "'" ,Form1.baglanti);
                    degistir.ExecuteNonQuery();
                    MessageBox.Show("Şifre başarıyla güncellendi!");

                }
                else
                    MessageBox.Show("Şu anki şifreyi yanlış girdiniz!");
            }
            else
                MessageBox.Show("Yeni şifreler eşit değil!");
            Form1.baglanti.Close();
        }
    }
}
