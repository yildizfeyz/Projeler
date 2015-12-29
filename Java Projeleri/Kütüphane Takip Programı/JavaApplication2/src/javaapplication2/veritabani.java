/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/**
 *
 * @author feyzullah
 */
public class veritabani {
    
        
        public static Connection con = null;
        public static PreparedStatement pst = null;
        public static ResultSet sonuc = null;
        public static String SQL;        
        
        
        
        veritabani() 
        {
            
              
                
                try {
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:test.db");
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
                    System.out.println("Opened database successfully");
                    String sql = "";
                    
                    
                   
                    try
                    {
                    
                    sql = "CREATE TABLE kitaplar " +
                   "(ID INTEGER PRIMARY KEY  AUTOINCREMENT," +
                   " kitapadi           TEXT," + 
                   " tur            TEXT, " + 
                   " ISBN        TEXT, " + 
                   " dili        TEXT, " + 
                   " yayinevi        TEXT, " +
                   " eklemetarihi        TEXT, " + 
                   " nerede        TEXT, " +
                   " silmetarihi        TEXT, " + 
                   " silmenedeni        TEXT, " +
                   " ozellikler        TEXT, " + 
                   " yazar        TEXT, " + 
                   " fiyat         TEXT)"; 
                        
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    
                    
                    }
                    catch(Exception ex) {ex.printStackTrace(); }
                    finally
                    {
                        try { pst.close(); } catch (Exception ex) { }
                    }
                    
                    try
                    {
                        
                    
                    sql = "CREATE TABLE giris " +
                   "(ID INTEGER PRIMARY KEY   AUTOINCREMENT," +
                   " isim           TEXT," + 
                   " parola         TEXT)"; 
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    
                    
                    }
                    catch(Exception ex) {ex.printStackTrace(); }
                    finally
                    {
                        try { pst.close(); } catch (Exception ex) { }
                    }
                    
                    
                    try{
                        
                       
                    sql = "CREATE TABLE uyeler " +
                   "(ID INTEGER PRIMARY KEY   AUTOINCREMENT," +
                   " TC           TEXT," + 
                   " uyeadi            TEXT, " + 
                   " telefon        TEXT, " + 
                   " adres        TEXT, " + 
                   " eposta        TEXT, " +
                   " dogumtarihi        TEXT, " + 
                   " kayittarihi        TEXT, " +
                   " aktif        TEXT, " + 
                   " silmetarihi        TEXT, " +
                   " cezali        TEXT, " + 
                   " cezabaslangic        TEXT, " + 
                   " cezabitis        TEXT, " +
                   " cezanedeni        TEXT, " + 
                   " borclu        TEXT, " + 
                   " borc         TEXT)"; 
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    
                    
                    }
                    catch(Exception ex) {ex.printStackTrace(); }
                    finally
                    {
                        try { pst.close(); } catch (Exception ex) { }
                    }
                    
                    try {
                        
                       
                    sql = "CREATE TABLE kasa " +
                   "(ID INTEGER PRIMARY KEY   AUTOINCREMENT," +
                   " harcamanedeni           TEXT," + 
                   " fiyat            TEXT, " + 
                   " tarih        TEXT, " + 
                   " yon         TEXT)"; 
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    
                    
                    }
                    catch(Exception ex) {ex.printStackTrace(); }
                    finally
                    {
                        try { pst.close(); } catch (Exception ex) { }
                    }
                    
                    try {
                        
                       
                    sql = "CREATE TABLE emanet " +
                   "(ID INTEGER PRIMARY KEY   AUTOINCREMENT," +
                   " kitapID           TEXT," + 
                   " uyeID            TEXT, " + 
                   " vermetarihi        TEXT, " + 
                   " almatarihi        TEXT, " + 
                   " gun        TEXT, " +
                   " aktif         TEXT)"; 
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    
                    
                    }
                    catch(Exception ex) {ex.printStackTrace(); }
                    finally
                    {
                        try { pst.close(); } catch (Exception ex) { }
                    }
                    
                    try {
                        
                        
                    sql = "CREATE TABLE ayarlar " +
                   "(ID INTEGER PRIMARY KEY   AUTOINCREMENT," +
                   " gecikmebedeli           TEXT," + 
                   " maxemanet            TEXT, " + 
                   " emanetgun         TEXT)"; 
                    pst = con.prepareStatement(sql);
                    pst.executeUpdate();
                    
                    
                    }
                    catch(Exception ex) {ex.printStackTrace(); }
                    finally
                    {
                        try { pst.close(); } catch (Exception ex) { }
                    }
                    
                    
                       try {
                           
                           String SQL = "Select * from giris";
                           
                          
                           pst = con.prepareStatement(SQL);
                           sonuc = pst.executeQuery();
                         
                        if(!(sonuc.next()))
                        {
                            
                            try { sonuc.close(); pst.close();  } catch(Exception ex) { }
                            
                            sql = "INSERT INTO giris (isim,parola) " +
                            "VALUES ('feyz', '123456');"; 
                            pst = con.prepareStatement(sql);
                            pst.executeUpdate();
                             try { pst.close();  } catch(Exception ex) { }
                            
                        }
                       }
                       catch (Exception ex)
                       {
                           ex.printStackTrace();
                       }
                       
    System.out.println("Table created successfully");
            
           
        }
       
            
            
        private static int uygula()
        {
            int r = 1;
            try
            {
            
            
            pst = con.prepareStatement(SQL);
            pst.executeUpdate();
            
            
            }
            catch(Exception hata)
            {
                hata.printStackTrace();
                r = 0;
            }
            finally
            {
                try { pst.close(); } catch (Exception ex) { }
                return r;
            }
            
        }   
        
        public static int ekle(String tablo, String[] kolon, String[] veri)
        {
            try
            {
           
            String kolonlar = "(";
            String icerik = "(";
            for(int i=0 ; i < veri.length ; i++)
            {
                if(i == veri.length - 1)
                    kolonlar = kolonlar + kolon[i] + ")";
                else
                 kolonlar = kolonlar + kolon[i] + ", ";
                 
                
            }
            for(int i=0 ; i < veri.length ; i++)
            {
                if(i == veri.length - 1)
                    icerik = icerik + "'" + veri[i] + "')";
                else
                    icerik = icerik + "'" + veri[i] + "', ";
                 
                
            }
            SQL = "INSERT INTO " + tablo + " " + kolonlar + " VALUES " + icerik;
            int x = uygula();
            
            
            return x;
            
            }
            catch(Exception hata)
            {
                
                hata.printStackTrace();
                StringWriter errors = new StringWriter();
                hata.printStackTrace(new PrintWriter(errors));
                //JOptionPane.showMessageDialog(null,"HATA: " + errors.toString());
                return 0;
            }
           
        } 
        
        public static ResultSet sqlkomut(String sql)
        {
            SQL = sql;
            try
            {
            pst = con.prepareStatement(SQL);
            sonuc = pst.executeQuery();
            }
            catch(Exception hata)
            {
                hata.printStackTrace();
                StringWriter errors = new StringWriter();
                hata.printStackTrace(new PrintWriter(errors));
                //JOptionPane.showMessageDialog(null,"HATA: " + errors.toString());
            }
            finally
            {
                
            }
            return sonuc;
        }
        
         public static boolean sqlkomut2(String sql)
        {
            SQL = sql;
            
            try
            {
            
           
            pst = con.prepareStatement(SQL);
            
            pst.executeUpdate();
            
            
                       
            return true;
            }
            catch(Exception hata)
            {
                
                hata.printStackTrace();
                StringWriter errors = new StringWriter();
                hata.printStackTrace(new PrintWriter(errors));
                //JOptionPane.showMessageDialog(null,"HATA: " + errors.toString());
                 return false; //JOptionPane.showMessageDialog(null, hata.getMessage());
            }
            finally
            {
                try { pst.close(); } catch (Exception ex) { }
            }
            
        }
        
        
        public static int update(String tablo, String[] kolon, String[] veri, String where)
        {
            try
            {
            
           
            String kolonlar = "";
            for(int i=0 ; i < veri.length ; i++)
            {
                if(i == veri.length - 1)
                    kolonlar = kolonlar + kolon[i] + " ='" + veri[i]+"'";
                else
                 kolonlar = kolonlar + kolon[i] + " ='" + veri[i] + "', ";
                 
                
            }
            
            
            SQL = "UPDATE " + tablo + " SET " + kolonlar + " " + where;
            int x = uygula();
            
           
            
            return x;
            
             }
            catch(Exception hata)
            {
                hata.printStackTrace();
                StringWriter errors = new StringWriter();
                hata.printStackTrace(new PrintWriter(errors));
                //JOptionPane.showMessageDialog(null,"HATA: " + errors.toString());
                return 0;
            }
        }
        
        public static int delete(String tablo, String where)
        {
            try
            {
               
            SQL = "DELETE " + tablo + " " + where;
            int x = uygula();
          
            
                      
            
            return x;
            }
            catch(Exception hata)
            {
                hata.printStackTrace();
                StringWriter errors = new StringWriter();
                hata.printStackTrace(new PrintWriter(errors));
                //JOptionPane.showMessageDialog(null,"HATA: " + errors.toString());
                return 0;
            }
        }
           
         public static ResultSet select(String tablo, String where)
         {
            SQL = "Select * from " + tablo + " " + where;
            try
            {
            
           
            
            pst = con.prepareStatement(SQL);
            sonuc = pst.executeQuery();
            
            }
            catch(Exception hata)
            {
                hata.printStackTrace();
                StringWriter errors = new StringWriter();
                hata.printStackTrace(new PrintWriter(errors));
                //JOptionPane.showMessageDialog(null,"HATA: " + errors.toString());
            }
            finally
            {
                
            }
            
            
            return sonuc;
         }
         
    
}
