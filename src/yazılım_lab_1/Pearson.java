
package yazılım_lab_1;
import java.math.*;
import java.util.ArrayList;


public class Pearson {
    ArrayList<Integer> benzer_kullancilar= new ArrayList<Integer>(); //BENZER KULLANICILARIN İD LERİNİN  TUTULDUĞU ARRAYLİST
    vt_baglanti baglanti=new vt_baglanti();
    ArrayList<Integer> oylar=new ArrayList<Integer>(); //BENZER KULLANICILARIN RATE LERİNİN  TUTULDUĞU ARRAYLİST
    String[][] pearsons = new String[150][2];
    int t=0;
    

//ANA KULLANICININ VE DİĞER KULLANICININ VERDİKLERİ OYLARI ALIP PEARSON KORELASYON KAT SAYISINI HESAPLAYAN METOD
    
double pearson_hesapla(int d1[],int d2[]){
    int i=0;
    double xy=0;
    double x=0,x2=0;
    double y=0,y2=0;
    double r=0;
    int n=oylar.size()/2;

    for(i=0;i<oylar.size()/2;i++){
        xy=xy+(d1[i]*d2[i]); //çarpımların toplamı
        
        x=x+d1[i]; // tek dizinin toplamı
        y=y+d2[i]; // tek dizinin toplamı
        x2=x2+d1[i]*d1[i]; //ilk diznin kareleri toplamı
        y2=y2+d2[i]*d2[i]; // ikinci dizinin kareleri toplamı
    }
    r=((double)(xy-(x*y/n)))/Math.sqrt((x2-(Math.pow(x,2))/n)*(y2-(Math.pow(y,2)/n))); // elde edilen veriler ile pearson korelasyon kat sayısı çıkarılır
    System.out.println("r= "+r);

return r;
}

// ANA KULLANICININ OKUDUĞU KİTAPLARDAN EN AZ 3 TANESİNİ OYLAYAN KULLANICI ID LERİ GETİRİLİR VE ARRAYLİSTE ATILIR

void kullanici_cek(int now_id){
    benzer_kullancilar.clear();
    System.out.println("********** BENZER KULLANİCİLAR ALINIYOR ***********");
    String sorgu="select  user_id from ratings  where isbn in (Select isbn from ratings where user_id="+"'"+now_id+"')"+"and user_id!="+"'"+now_id+"'"+"group by user_id having count(user_id)>=3  order by count(user_id) desc";
    System.out.println(sorgu);
    baglanti.vt_kullanici_cek(benzer_kullancilar,sorgu);
    for(int i=0;i<benzer_kullancilar.size();i++){
    System.out.println(benzer_kullancilar.get(i));
    }
    System.out.println("********** BENZER KULLANICILAR BAŞARI İLE ALINDI *************");
  
 
}
// HER KULLANICI İÇİN ANA KULLANICI VE DİĞER KULLAANICNIN ORTAK KİTAPLARA VEDİKLERİ OYLAR GETİRİLİR VE AYRI AYRI DİZİLERE ATILIR DAHA SONRA PEARSON HESAPLANMASI
//İÇİN METODA GÖNDERİLİR VE KAT SAYI İLE KULLANICI İD Sİ DİZİDE TUTULUR KATSAYISI HESAPLANAMAYANLAR VE SIFIRDAN KÜÇÜK OLANLA ATILIR

void kullanici_rate_cek(int now_id){
oylar.clear();
    int i=0,k=0;
    System.out.println("\n******* KULLANICI OYLARI ALINIYOR **********");
    
    for(i=0;i<benzer_kullancilar.size();i++){
        
        int d1[]=new int[150];
        int d2[]=new int[150];
    System.out.println("---Kullanici: "+benzer_kullancilar.get(i)+"-----\n");
    String sorgu="select r1.rate,r2.rate from ratings r1,ratings r2 where r1.user_id='"+benzer_kullancilar.get(i)+"' and r1.isbn  in(Select isbn from ratings where user_id="+"'"+now_id+"') and  r2.user_id='"+now_id+"' and r1.isbn=r2.isbn";
    System.out.println(sorgu+"\n");
    baglanti.vt_rate_cek(oylar,sorgu);
    
      for(int j=0;j<oylar.size();j+=2){
          d1[k]=oylar.get(j);
          d2[k]=oylar.get(j+1); 
          k++;
     System.out.println(oylar.get(j)+","+oylar.get(j+1));
    }
      
      k=0;
     double r=pearson_hesapla(d1, d2); // Pearson metoduna gönder pearson katsayısı hesapla
     if(Double.toString(r).equals("NaN")==false && r>=0.5 ){
      pearsons[t][0]=benzer_kullancilar.get(i).toString();   // kullanıcının id si diziye atıldı
      pearsons[t][1]= Double.toString(r); 
      t++;
     }
     oylar.clear();
      }
    System.out.println("******* KULLANICI OYLARI BAŞARIYLA ALINDI **********");

    

}



    public static void main(String[] args) {
       int d1[]={2,4,5,7,3,1,6};
       int[] d2={58,32,63,87,67,45,68};
       new Pearson().pearson_hesapla(d1, d2);
       //bazıları yanlış hesaplanıyor
    }
}

