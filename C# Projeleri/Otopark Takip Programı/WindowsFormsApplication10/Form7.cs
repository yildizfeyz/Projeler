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
    public partial class Form7 : Form
    {
        public Form7()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Form7_Load(object sender, EventArgs e)
        {
            Form1.baglanti.Open();
            OleDbCommand veri = new OleDbCommand("SELECT * FROM giderler", Form1.baglanti);
            OleDbDataReader oku;
            oku = veri.ExecuteReader();
            ListViewItem yeni;// = new ListViewItem();

            while (oku.Read())
            {
                //string[] list = { oku["harcama_nedeni"].ToString(), oku["harcama_bedeli"].ToString() };
                yeni = new ListViewItem();
                yeni.Text = oku["harcama_nedeni"].ToString();
                yeni.SubItems.Add(oku["harcama_bedeli"].ToString());
                listView1.Items.Add(yeni);
                //yeni2 = new ListViewItem();


            }
            

            OleDbCommand veri2 = new OleDbCommand("SELECT * FROM gelirler", Form1.baglanti);
            OleDbDataReader oku2;
            oku2 = veri2.ExecuteReader();
            ListViewItem yeni2;// = new ListViewItem();

            while (oku2.Read())
            {
                //string[] list = { oku["harcama_nedeni"].ToString(), oku["harcama_bedeli"].ToString() };
                yeni2 = new ListViewItem();
                yeni2.Text = oku2["plaka"].ToString();
                yeni2.SubItems.Add(oku2["teslim_eden"].ToString());
                yeni2.SubItems.Add(oku2["musteri"].ToString());
                yeni2.SubItems.Add(oku2["ucret"].ToString());
                listView2.Items.Add(yeni2);
                //yeni2 = new ListViewItem();


            }
            Form1.baglanti.Close();

            int topla = 0;
            for (int i = 0 ; i < listView2.Items.Count; i++)
            {
                topla = topla + Convert.ToInt32(listView2.Items[i].SubItems[3].Text);
            }
            label3.Text = "TOPLAM GELİR = " + topla.ToString() + " TL";

            topla = 0;
            for (int i = 0; i < listView1.Items.Count; i++)
            {
                topla = topla + Convert.ToInt32(listView1.Items[i].SubItems[1].Text);
            }
            label4.Text = "TOPLAM GİDER = " + topla.ToString() + " TL";

        }
    }
}
