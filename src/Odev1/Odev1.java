package Odev1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ALPARSLAN
 */
public class Odev1 {

    public static void main(String[] args) {
        
        ogrenci [] ogr = new ogrenci[3];    
        ogr[0] = new ogrenci(25, "Ahmet", "Arslan", 393);
        ogr[1] = new ogrenci(25, "Ayşe", "Yıldırım", 145);
        ogr[2] = new ogrenci(25, "Mehmet", "Yılmaz", 345);
        
        for(int k=0;k<ogr.length;k++){
            System.out.println("");
        }
        
        try {
            //File f =new File("D:\\Netbeans Projelerim 2020\\Data_Structure_2021\\src\\Odev1\\lys.txt");
            FileWriter fr = new FileWriter("D:\\Netbeans Projelerim 2020\\Data_Structure_2021\\src\\Odev1\\lys.txt");

            for (int i = 0; i < ogr.length-1; i++) {
                int sayi = ogr[i].lys_puan;
                int temp =i;
                
                for(int j=i+1;j<ogr.length;j++){
                    if(ogr[j].lys_puan<sayi){
                        sayi = ogr[j].lys_puan;
                        temp = j;
                    }
                }                
            }
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Başarılı..");
        }
    }
    
}

class ogrenci {
    int tcNo;
    String ad,soyad;
    int lys_puan;
    
    public ogrenci(int tcNo, String ad, String soyad, int lys_puan){
        this.tcNo = tcNo;
        this.ad= ad;
        this.soyad = soyad;
        this.lys_puan = lys_puan;
    }
    
    
}