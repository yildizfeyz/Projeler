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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaapplication2.NewJFrame;
import javaapplication2.tasarim;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

/**
 *
 * @author feyzullah
 */



public class JavaApplication2  {

    /**
     * @param args the command line arguments
     */
    //public static JButton giris;
    public static void main(String[] args) {
//
//        int x=0, y=0, w=300, h=300;
//        
//        JFrame frame = new JFrame();
//        
//        frame.setTitle("Kütüphane Takip Programı");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
//        frame.setBounds(0, 0, 1024, 768);
//        
//        ImageIcon image = new ImageIcon("C:\\ktp.png");
//        JLabel imagelabel = new JLabel("", image, JLabel.CENTER);
//        imagelabel.setBounds(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
//        imagelabel.setVisible(true);
//        frame.setUndecorated(true);
//        frame.add(imagelabel);
//        
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//
//        // Determine the new location of the window
//        int _w = frame.getSize().width;
//        int _h = frame.getSize().height;
//        int _x = (dim.width-_w)/2;
//        int _y = (dim.height-_h)/2;
//
//        // Move the window
//        frame.setLocation(_x, _y);
//        
//        //a = this;
//        frame.setVisible(true);
//        try
//        {
//            float o;
//            o = (float)1.0;
//            Thread.sleep(1000);
//            while(true)
//            {
//                
//              
//              o = (float)(o - 0.01);
//              frame.setOpacity(o);
//              if(o <= (float)0.0)
//                  break;
//              Thread.sleep(10);
//            }
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }
        /*JLabel yazi = new JLabel("Üye Girişi");
        yazi.setBounds((int)((w/2)-(100/2)), 5 , 200, 30);
        yazi.setFont(new Font("Serif",Font.BOLD,20));
        frame.add(yazi);
        
        JLabel kullanicilabel = new JLabel("Kullanıcı Adı:");
        kullanicilabel.setBounds(10, 50 , 80, 20);
        frame.add(kullanicilabel);
        
        JLabel sifrelabel = new JLabel("Şifre:");
        sifrelabel.setBounds(10, 80 , 80, 20);
        frame.add(sifrelabel);
        
        
        
        TextField kullanici = new TextField();
        kullanici.setBounds(100, 50, 100, 20);
        frame.add(kullanici);
        
        JPasswordField sifre = new JPasswordField();
        sifre.setBounds(100, 80, 100, 20);
        frame.add(sifre);
       
        JButton admin = new JButton("Admin");
        admin.setBounds(w - 100, h - 65 , 80, 20);
        frame.add(admin);
        
        JButton giris = new JButton("Giriş");
        giris.setBounds(120, 120 , 80, 20);
        frame.add(giris);
        
        
        
        tasarim form1 = new tasarim(300, 300, "Kütüphane");
        //form1.labelyap(100, 10, 100, 25, "Üye Girişi").setFont(new Font("Serif",Font.BOLD,20));
        form1.labelyap((int)(form1.getx()/2 - 50), 10, 100, 25, "Üye Girişi").setFont(new Font("Serif",Font.BOLD,20));
        form1.labelyap(10, 50, 80, 20, "Kullanıcı Adı:");
        form1.labelyap(10, 80, 80, 20, "Şifre:");
        //TextField kullanici = form1.textfieldyap(90, 50, 120, 20);
        //JPasswordField sifre = form1.parolagirisi(90, 80, 120, 20);
        
        form1.butonyap(140, 110, 70, 20, "Giriş").addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        form1.butonyap(210, 240, 70, 20, "Admin");
        
        
        form1.goster();
        */
        NewJFrame yeni = new NewJFrame();
        yeni.main(args);
        
//        frame.setVisible(false);
        
        
    }

    
}
