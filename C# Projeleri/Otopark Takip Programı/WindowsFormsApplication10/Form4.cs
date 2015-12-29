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
    public partial class Form4 : Form
    {
        public Form4()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form1.baglanti.Open();
           
            

            OleDbCommand komut2 = new OleDbCommand("delete from arac where plaka='" + textBox1.Text + "'" , Form1.baglanti);
            komut2.ExecuteNonQuery();

            
            OleDbCommand komut = new OleDbCommand("insert into gelirler (plaka,teslim_eden,musteri,ucret) values('" + textBox1.Text + "','" + textBox7.Text + "',' " + textBox2.Text + " ',' " + textBox6.Text + "')", Form1.baglanti);
            OleDbDataReader oku = komut.ExecuteReader();

            MessageBox.Show("Gelir başarıyla kaydedildi");
            Form1.baglanti.Close();
            this.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form1.baglanti.Open();
            OleDbCommand komut = new OleDbCommand("select * from arac where plaka='" + textBox1.Text + "'", Form1.baglanti);
            OleDbDataReader oku = komut.ExecuteReader();

            if (oku.Read())
            {
                textBox2.Text = oku["musteri"].ToString();
                textBox3.Text = oku["teslim_alan"].ToString();
                textBox4.Text = oku["alinan_tarih"].ToString();

                TimeSpan gecenzaman = DateTime.Now - Convert.ToDateTime(textBox4.Text);

                textBox5.Text = gecenzaman.TotalHours.ToString("#.#") + " Saat";

                double saat = Convert.ToDouble(gecenzaman.TotalHours.ToString());
                int kontrol = 0;
                
                OleDbCommand _komut = new OleDbCommand("select * from tarife", Form1.baglanti);
                OleDbDataReader ucret_oku = _komut.ExecuteReader();
                string ucret = "";

                do
                {

                    if (!(ucret_oku.Read()))
                    {
                        break;
                    }
                    ucret = ucret_oku["ucret"].ToString();
                    kontrol = Convert.ToInt32(ucret_oku["tarife"].ToString().Substring(0, 2));
                } while (kontrol < saat);

                textBox6.Text = ucret;
                button1.Enabled = true;
                panel1.Visible = true;
            }
            else
                MessageBox.Show("Bu plaka kayılı değil!");
            Form1.baglanti.Close();
           
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            panel1.Hide();
            button1.Enabled = false;
        }
    }
}
