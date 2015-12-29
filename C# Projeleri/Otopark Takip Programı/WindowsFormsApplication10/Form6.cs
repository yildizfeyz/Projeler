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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form1.baglanti.Open();
            OleDbCommand kaydet = new OleDbCommand("insert into giderler (harcama_nedeni,harcama_bedeli) values('" + textBox1.Text + "','" + textBox2.Text + "')", Form1.baglanti);
            kaydet.ExecuteNonQuery();
            MessageBox.Show("Harcama başarıyla kaydedildi!");
            Form1.baglanti.Close();
            this.Close();
        }
    }
}
