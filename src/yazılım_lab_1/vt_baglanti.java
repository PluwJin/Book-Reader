
package yazılım_lab_1;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;


public class vt_baglanti {
    ArrayList<Object> set1 =new ArrayList<Object>(); //TABLOYA YAZILACAK VERİLER ARRAYLİSTTE TUTULUR 
    Hatalar hata=new Hatalar();
    // --------------------VERİTABANI BAĞLANTISI İÇİN GEREKLİ DEĞİŞKENLER--------------------------------
    String driver="com.mysql.jdbc.Driver";
    String h_name="localhost:3306";
    String k_ad="root";
    String sifre="";
    //-------------------------------------------------------------------------------------------------
    ResultSet sonuc;
    Connection baglanti=null;
    PreparedStatement sorgu=null;
    
   
    // REGİSTER İÇİN KULLANILAN METOD REGİSTER BUTONUNA TIKLANDIĞINDA PARAMETRE OLARAK OLUŞTURULAN SORGUYU ALIR  VERİTABANI BAĞLANTIWSINI KURAR VE 
    //HATA MESAJI YAZAR EĞER HATA İLE KARŞILAŞILIRSA CATCH BLOĞUNDA YAKALANIR VE İLGİLİ MESAJ YAYINLANIR
    public void sorgu(String sorgu1){
        try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(sorgu1);
            sorgu.executeUpdate();
            hata.hata_yazi_yaz("Registration Successful !!!");
            
        } catch (Exception e) {
            hata.hata_yazi_yaz("User ID is taken");
            e.printStackTrace();
        }
        finally{
            hata.hata_goster();
        }
    }
    
  //USER LOGİN İÇİN KULLANILAN METOD FİELD ' A GİRİLEN KULLANICI ADI VE ŞİFRE İLE OLUŞTURULAN SORGU PARAMETRE OLARAK ALINIR 
 // SORGU ÇALIŞTIRILIR VT DEN ÇEKİLEN USER İD VE ŞİFRE İLE KULLANICININ GİRDİĞİ BİLGİLER KARŞILAŞTIRILIR EŞİTSE USERPANEL AÇILIR VE İD OLARAK K. ADI GÖNDERİLR
//EĞER ŞİFREDE HATA VARSA ELSE BLOĞUNA GEÇİLİR HATA MESAJI YAYINLANIR EĞER USERNAME BULUNMUYORSA CATCH BLOĞUNDA EXCEPTİON OLARAK YAKALANIR VE HATA MESAJI YAZILIR
  
    public int login(String sorgu1,String id,char[]pass){
        
           try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(sorgu1);
            ResultSet rs=sorgu.executeQuery();
            rs.next();
               
               String us_id=rs.getString("user_id");
               char[] us_pass=rs.getString("pass").toCharArray();
              
               if( us_id.equals(id) && Arrays.equals(pass,us_pass) ){
                   System.out.println("Onlinee!!!!");
                   new Userpanel(id).setVisible(true); // USERPANEL HANGİ KULLANICI İÇİN AÇILACAĞI USER PANELE PARAMETRE OLARAK GÖNDERİLİR
                   return 1;
                   
               }
               else{   
                   hata.hata_yazi_yaz("Invalid Password");
                   hata.hata_goster();
                   
               }
           } catch (Exception e) {
            e.printStackTrace();
            hata.hata_yazi_yaz("Invalid Username");
            hata.hata_goster();
        }
           return 0;
        
    }
    
    //ADMİN PANELDE BULUNAN USER TABLOSUNA KULLANCII BİLGİLERİNİN ÇEKİLDİĞİ METOD  ÇEKİLEN USER ID ,LOCATİON VE AGE BİLGİLERİ ARRAYLİSTTE TUTULUR
    // TABLO EKELEME KISMINDA BU ARRAYLİSTTEN NESNE YARDIMI İLE ÇEKİLİR
    
    public void user_listele(String sorgu1){
        
        
        int i=0;
        try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(sorgu1);
            ResultSet rs=sorgu.executeQuery();
               
                 while(rs.next()){
                set1.add(rs.getObject(1));
                set1.add(rs.getObject(2));
                set1.add(rs.getObject(3));          
            }
              
           } catch (Exception e) {
               e.getCause();
            e.printStackTrace();
            hata.hata_yazi_yaz(e.getMessage());
            hata.hata_goster();
        }
        
    }
    
    
    //GENEL SORGULAR İÇİN KULLANILAN METOD
    
        public void user_sil(String sorgu1){
        
        
        try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(sorgu1);
            sorgu.executeUpdate();
              
           } catch (Exception e) {
               e.getCause();
            e.printStackTrace();
            hata.hata_yazi_yaz(e.getMessage());
            hata.hata_goster();
        }
        
    }
        
        // VERİ TABANINDAN TEK BİR İNTEGER DEĞER ALINMAK İSTEDİĞİNDE KULLANILAN METOD
        
      public int avg_rate(String Sorgu1){
        int avg=0;
        int i=0;
        
        try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(Sorgu1);
            ResultSet rs=sorgu.executeQuery();
            rs.next();
            avg=rs.getInt(1);
            System.out.println(avg);

           } catch (Exception e) {
               e.getCause();
            e.printStackTrace();
            hata.hata_yazi_yaz(e.getMessage());
            hata.hata_goster();
        }
       return avg;
    }
       // KİTAP BİLGİLERİNİN ALINDIĞI VE ARRAYLİSTE ATILDIĞI METOD KİTAP RESİMLERİ İÇİN URL LER DE BU ARRAYLİSTTEN ÇEKİLİR        
           
       public void kitap_listele(String sorgu1){
        
        
        int i=0;
        try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(sorgu1);
            ResultSet rs=sorgu.executeQuery();
               
                 while(rs.next()){
                set1.add(rs.getObject(1));
                set1.add(rs.getObject(2));
                set1.add(rs.getObject(3));
                set1.add(rs.getObject(4));
                set1.add(rs.getObject(5));
                set1.add(rs.getObject(6));
                set1.add(rs.getObject(7));
                set1.add(rs.getObject(8));     
            }
              
           } catch (Exception e) {
               e.getCause();
            e.printStackTrace();
            hata.hata_yazi_yaz(e.getMessage());
            hata.hata_goster();
        }
        
    }
       
       //------------------------------------------------------------- PEARSON ----------------------------------------------------------------------------
       
       // PEARSON ALGORİTMASI İÇİN EN AZ 3 KİTAP EŞLEŞEN KULLANICILARIN İDLERİNİN ÇEKİLDİĞİ METOD
       //KENDİNE PARAMETRE OLARAK VERİLEN Bİ ARRAY LİSTE KULLANICILAR YAZILIR
       
       void vt_kullanici_cek(ArrayList<Integer> e,String sorgu1){
           try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(sorgu1);
            ResultSet rs=sorgu.executeQuery();
               
                 while(rs.next()){
                e.add(rs.getInt(1));
     
            }
              
           } catch (Exception er) {
               er.getCause();
            er.printStackTrace();
            hata.hata_yazi_yaz(er.getMessage());
            hata.hata_goster();
        }
       }
       
       // HERBİR KULLANICI İÇİN ÇALIŞTIRILAN VE ANA KULLANICI İLE KİTAP ÖNERECEK KULLANICININ ORTAK KİTAPLARA VERDİKLERİ PUANLAR BİR TABLO HALİNDE ÇEKİLİR
       
       
       void vt_rate_cek(ArrayList<Integer> e,String sorgu1){
                  try {
            Class.forName(driver);
            baglanti=DriverManager.getConnection("jdbc:mysql://"+h_name+"/"+"yazilim"+"?useSSL=false", k_ad, sifre);
            sorgu=baglanti.prepareStatement(sorgu1);
            ResultSet rs=sorgu.executeQuery();
               
                 while(rs.next()){
                e.add(rs.getInt(1));
                e.add(rs.getInt(2));
            }
              
           } catch (Exception er) {
               er.getCause();
            er.printStackTrace();
            hata.hata_yazi_yaz(er.getMessage());
            hata.hata_goster();
         } 
       }
       
  //----------------------------------------------------------------------------------------------------------------------------------------------------
 //----------------------------------------------------------------------------------------------------------------------------------------------------    
//----------------------------------------------------------------------------------------------------------------------------------------------------   
       

    
}
