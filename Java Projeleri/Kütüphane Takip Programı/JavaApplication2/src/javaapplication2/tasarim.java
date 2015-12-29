/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author feyzullah
 */
public class tasarim {
   
   private JFrame form;
   tasarim(JFrame _form)
   {
       form = _form;
       
   }

    tasarim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   public static veritabani vt;
   
   public void ortala()
   {
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       
        // Determine the new location of the window
        int w = form.getSize().width;
        int h = form.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        form.setLocation(x, y);  
   }
    /*
   private int x = 0, y = 0, w, h;
   private JFrame form = new JFrame();
   tasarim(int genislik, int yukseklik, String baslik) 
            { 
                w = genislik; h = yukseklik; 
               
                form.setTitle(baslik);
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setLocationRelativeTo(null);
                form.setLayout(null);
                form.setBounds(x, y, w, h);
            }
   tasarim(int konumx, int konumy, int genislik, int yukseklik, String baslik) 
            { 
                x = konumx; y = konumy; w = genislik; h = yukseklik; 
                form.setTitle(baslik);
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setLocationRelativeTo(null);
                form.setLayout(null);
                form.setBounds(x, y, w, h);
            } 
    public void goster()
    {
        form.setVisible(true);
    }
    
    public JLabel labelyap(int konumx, int konumy, int _w, int _h, String metin)
    {
        
        JLabel yazi = new JLabel(metin);
        yazi.setBounds(konumx, konumy , _w, _h);
        form.add(yazi);
        return yazi;
    }
    
    public TextField textfieldyap(int konumx, int konumy, int _w, int _h)
    {
        TextField text = new TextField();
        text.setBounds(konumx, konumy, _w, _h);
        form.add(text);
        return text;
    }
    
    public JPasswordField parolagirisi(int konumx, int konumy, int _w, int _h)
    {
        JPasswordField sifre = new JPasswordField();
        sifre.setBounds(konumx, konumy, _w, _h);
        form.add(sifre);
        return sifre;
    }
    public int getx()
    {
        return form.getWidth();
    }
    public int gety()
    {
        return form.getHeight();
    }
    public JButton butonyap(int konumx, int konumy, int _w, int _h, String metin)
    {
        JButton buton = new JButton(metin);
        buton.setBounds(konumx, konumy , _w, _h);
        form.add(buton);
        return buton;
    } */
}
