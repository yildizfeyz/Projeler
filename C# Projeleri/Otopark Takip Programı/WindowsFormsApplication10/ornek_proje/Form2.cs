using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication10
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form3 yeni = new Form3();
            yeni.ShowDialog();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form4 yeni = new Form4();
            yeni.ShowDialog();
        }

        private void button5_Click(object sender, EventArgs e)
        {
            Form5 yeni = new Form5();
            yeni.ShowDialog();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form6 yeni = new Form6();
            yeni.ShowDialog();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Form7 yeni = new Form7();
            yeni.ShowDialog();
        }

        private void button6_Click(object sender, EventArgs e)
        {
            Form8 yeni = new Form8();
            yeni.ShowDialog();
        }

        private void Form2_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }
    }
}
