// Otomata ödevi için 259275 FEYZULLAH YILDIZ tarafından yapılmıştır. Öğr. Gör. Ömer ÇAKIR  - 2014
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Input;
using System.IO;

namespace WindowsFormsApplication6
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        string duzenle(string s1, string s2, string s3 = "", string s4 = "", string s5 = "", string s6 = "")
        {
            

            string topla;
            
            if (s1 == "ε") if(s2 != "+") s1 = "";
            if (s2 == "ε") if((s1 != "+") || (s3 != "+")) s2 = "";
            if (s3 == "ε") if ((s2 != "+") || (s4 != "+")) s3 = "";
            if (s4 == "ε") if ((s3 != "+") || (s5 != "+")) s4 = "";
            if (s5 == "ε") if ((s4 != "+") || (s6 != "+")) s5 = "";
            if (s6 == "ε") if (s5 != "+") s6 = "";

            
            if (s1.IndexOf("+") > 0)  s1 = "(" + s1 + ")";
            if (s2.IndexOf("+") > 0)  s2 = "(" + s2 + ")";
            if (s3.IndexOf("+") > 0)  s3 = "(" + s3 + ")";
            if (s4.IndexOf("+") > 0)  s4 = "(" + s4 + ")";
            if (s5.IndexOf("+") > 0)  s5 = "(" + s5 + ")";
            if (s6.IndexOf("+") > 0)  s6 = "(" + s6 + ")";
            

            topla = s1 + s2 + s3 + s4 + s5 + s6;
            if (topla.IndexOf("+") == 0)
                topla = s3 + s4 + s5 + s6;

            return topla;
        }
        int sayi(string f)
        {
            try
            {
                return Convert.ToInt32(f);
            }
            catch (Exception)
            {
                return 0;
            }
        }
        private void button1_Click(object sender, EventArgs e)
        {
            string sonuc = "";
            string filename = "";
            bool t = false;
            if ((radioButton3.Checked == true) || (radioButton4.Checked ==  true)) //Yazılacak dosya seçilmediyse işlem yapmasın
                {
                    t = false;
                    if (radioButton1.Checked == true)
                    {
                        t = true;
                        OpenFileDialog openFileDialog1 = new OpenFileDialog();
                        openFileDialog1.Filter = "Metin Dosyaları |*.txt";
                        openFileDialog1.Title = "Açılacak Dosya";
                        DialogResult sec = openFileDialog1.ShowDialog();
                        while (true)
                            if (sec == DialogResult.OK)
                            {
                                filename = openFileDialog1.FileName;
                                break;
                            }

                    }
                    else if (radioButton2.Checked == true) { filename = "a.txt"; t = true; }
                    else MessageBox.Show("Okunacak Dosyayı Seçiniz!");
                }
            else
             MessageBox.Show("Yazılacak Dosyayı Seçiniz!");
            StreamReader oku = new StreamReader(filename);
            if (t == true) // Eğer seçeneklerden biri seçildiyse işleme başla
            {
                
              //  try
              //  {
                    
                    string s = oku.ReadLine();
                    string[] degerler;



                    int a = sayi(s) + 1; //durum sayısı + 1 -- başlandıç ve bitiş durumu(s,a) için +1

                    string[,] dizi = new string[a, a]; //durum dizisini tanımladık

                    for (int i = 0; i < a; i++)   //durum dizisini sıfırlama
                    {
                        for (int h = 0; h < a; h++)
                        {
                            dizi[i, h] = "";
                        }
                    }

                    int durum; //txt dosyasındaki mevcut durumu ifade edecek
                    int p; 


                    for (int c = 1; c < a; c++)
                    {
                        p = 0;
                        s = oku.ReadLine();
                        degerler = s.Split(' ');
                        if (degerler[p] == "-")   //başlangıç durumu mu?
                        {
                            if (degerler[p + 1] == "+") //hem başlangıç hem bitiş durumu mu?
                            {
                                p += 2;
                                durum = sayi(degerler[p]);
                                dizi[durum, sayi(degerler[++p])] = "a";
                                dizi[durum, sayi(degerler[++p])] = "b";
                                dizi[0, durum] = "ε";
                                dizi[durum, 0] = "ε";
                                continue;
                            }
                            else  //sadece başlangıç durumu mu?
                            {
                                p++;
                                durum = sayi(degerler[p]);
                                dizi[durum, sayi(degerler[++p])] = "a";
                                dizi[durum, sayi(degerler[++p])] = "b";
                                dizi[0, durum] = "ε";
                                continue;
                            }
                        }
                        else if (degerler[p] == "+") //sadece bitiş durumu mu
                        {
                            p++;
                            durum = sayi(degerler[p]);
                            dizi[durum, sayi(degerler[++p])] = "a";
                            dizi[durum, sayi(degerler[++p])] = "b";
                            dizi[durum, 0] = "ε";
                            continue;
                        }
                        else if (degerler[p].IndexOf('-') > -1)
                        {
                            degerler[p] = degerler[p].Remove(0, 1);
                            if (degerler[p].IndexOf('+') > -1)
                            {
                                degerler[p] = degerler[p].Remove(0, 1);
                                durum = sayi(degerler[p]);
                                dizi[durum, sayi(degerler[++p])] = "a";
                                dizi[durum, sayi(degerler[++p])] = "b";
                                dizi[0, durum] = "ε";
                                dizi[durum, 0] = "ε";
                                continue;
                            }
                            else
                            {
                                
                                durum = sayi(degerler[p]);
                                dizi[durum, sayi(degerler[++p])] = "a";
                                dizi[durum, sayi(degerler[++p])] = "b";
                                dizi[0, durum] = "ε";
                                continue;
                            }
                        }
                        else if (degerler[p].IndexOf('+') > -1)
                        {
                            degerler[p] = degerler[p].Remove(0, 1);
                            durum = sayi(degerler[p]);
                            dizi[durum, sayi(degerler[++p])] = "a";
                            dizi[durum, sayi(degerler[++p])] = "b";
                            dizi[durum, 0] = "ε";
                            continue;
                        }
                        else // başlangıç veya bitiş durumu değilse
                        {
                            durum = sayi(degerler[p]);
                            dizi[durum, sayi(degerler[++p])] = "a";
                            dizi[durum, sayi(degerler[++p])] = "b";

                        }


                    }
                    s = oku.ReadLine();
                    degerler = s.Split(' ');
                    int[] sira = new int[degerler.Length];
                    for (int y = 0; y < degerler.Length; y++)
                    {
                        sira[y] = sayi(degerler[y]);
                    }


                    for (int r = 0; r < a - 1; r++)
                    {
                        string dongu = "";
                        for (int i = a - 1; i > -1; i--)   //durum sayısı kadar dön. i durumu silinecek durum üzerinden gidiyormu kontrolü
                        {
                            if (i != sira[r])
                                if (dizi[i, sira[r]] != "") //mevcut durum silinecek duruma e gidiyor mu
                                {
                                    if (dizi[sira[r], sira[r]] != "") //silinecek durum kendine dönüyor mu
                                    {
                                        if (dizi[sira[r], sira[r]].Length > 1) dongu = "(" + dizi[sira[r], sira[r]] + ")*";
                                        else dongu = dizi[sira[r], sira[r]] + "*";
                                    }

                                    for (int h = a - 1; h > -1; h--) //durum sayısı kadar dön. bu durum silinecek durum üzerinden hangi durumlara gidiyor
                                    {
                                        if (h != sira[r])
                                            if (dizi[sira[r], h] != "") // silinecek durumdan ten h'a gidiş var mı
                                            {
                                                if (dizi[sira[r], h] == "ε") // silinecek durumdandan h'a gidiş epsilon mu
                                                {

                                                    dizi[i, h] = duzenle(dizi[i, h], "+", dizi[i, sira[r]], dongu);


                                                }
                                                else
                                                {

                                                    dizi[i, h] = duzenle(dizi[i, h], "+", dizi[i, sira[r]], dongu, dizi[sira[r], h]);
                                                }
                                            }
                                    }
                                }

                        }

                        for (int h = 0; h < a; h++) //silinen durumun bütün bağlantılarını sil
                        {
                            dizi[sira[r], h] = "";
                            dizi[h, sira[r]] = "";

                        }
                        if(r == sira.Length-1)
                            if (dizi[0, 0].Substring(dizi[0, 0].Length - 1, 1) == ")") //İfadenin en dışında gereksiz parantez varsa sil
                            {
                                dizi[0, 0] = dizi[0, 0].Remove(0, 1);
                                dizi[0, 0] = dizi[0, 0].Remove(dizi[0, 0].Length - 1, 1);
                            }
                        sonuc = sonuc + "\n\n" +  sira[r].ToString() + " silindiğinde:\n\n";
                        for (int h = 0; h < a; h++)
                        {
                            for (int j = 0; j < a; j++)
                            {
                                if (dizi[h, j] != "")
                                {
                                    
                                    if (h == 0 && j == 0) sonuc = sonuc + "s'den a'ya = " + dizi[h, j] + "\n";
                                    else   if (h == 0) sonuc = sonuc + "s'den " + j.ToString() + "'e = " + dizi[h, j] + "\n";
                                    else if (j == 0) sonuc = sonuc = sonuc + h.ToString() + "'den a'ya = " + dizi[h, j] + "\n";
                                    else
                                    sonuc = sonuc + h.ToString() + "'den " + j.ToString() + "'e = " + dizi[h, j] + "\n";
                                }
                            }
                        }
                    }


                    oku.Close();
                    
                    sonuc = sonuc + "\n SONUÇ DOSYAYA YAZDIRILDI...";
                    MessageBox.Show(sonuc);

                    if (radioButton3.Checked == true)
                    {
                        OpenFileDialog openFileDialog1 = new OpenFileDialog();
                        openFileDialog1.Filter = "Metin Dosyaları |*.txt";
                        openFileDialog1.Title = "Yazılacak Dosya";
                        DialogResult sec = openFileDialog1.ShowDialog();
                        while (true)
                            if (sec == DialogResult.OK)
                            {
                                filename = openFileDialog1.FileName;
                                break;
                            }
                    }
                    else
                        filename = "sonuc.txt";
                    StreamWriter SW = new StreamWriter(filename);
                    SW.WriteLine(dizi[0, 0]);
                    SW.Close();
                    
              //  }
              //  catch (Exception)
              //  {
              //      oku.Close();
              //      MessageBox.Show(filename + " dosyasını lütfen kontrol edin...\nGiriş dizisi doğru değil");
              //  }
            }
            oku.Close();
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            
      
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            MessageBox.Show("259275 FEYZULLAH YILDIZ\nII. Öğretim - Bilgisayar Müh.\nsince 2011 :)");
        }
    }
}
