
package yazılım_lab_1;
import java.io.*;
import java.util.*;





public class Yazılım_Lab_1 {
    //vt_baglanti baglan= new vt_baglanti();
    //String[][] kitap_part=new String[23][7];
    //String [][] rates= new String[1200000][3];
    


    /* String[][] kitap_oku(int bos_sayi){
         int i=0;
        try {
            File dosya=new File("BX-Books.csv");
            BufferedReader oku=null;
            oku=new BufferedReader(new FileReader(dosya));
            
            String bos=oku.readLine();
            
            
            for(int j=0;j<bos_sayi;j++){
                bos=oku.readLine();
            }
            
            String satir=oku.readLine();
            while(i<23){
              kitap_part[i]=satir.split(";");
                
                for(int j=0;j<8;j++){
                 kitap_part[i][j]=kitap_part[i][j].replace('"',' ').trim();
                    
                }
                System.out.println(kitap_part[i][7]);
            satir=oku.readLine();
            i++;
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return kitap_part;
    }*/
    
     
     
    public static void main(String[] args) {
      
        Gui g=new Gui();

        g.setVisible(true);
        
       
       
    }
    
}
