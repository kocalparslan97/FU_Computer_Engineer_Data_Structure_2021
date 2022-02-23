package Lecture1;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture1 {

    public static void main(String[] args){
        
        ogrenci [] d= new ogrenci[3];
        d[0] = new ogrenci(5, "Ahmet", 50, 60, 'E');
        d[1] = new ogrenci(5, "Ayşe", 40, 60, 'K');
        d[2] = new ogrenci(5, "Mehmet", 60, 60, 'E');
        
        //Ogrencilerin bilgilerini yazdırıyoruz
        for(int i=0;i<3;i++){
            System.out.println(i + " 'ninci Öğrencinin Bilgileri : " + "\nNo : " + d[i].no + 
                    "\nİsim : " + d[i].isim + "\nVize : " + d[i].vize + "\nFinal : " + d[i].genel +
                    "\nOrtalaması : " + d[i].ortalama() + "\nGeçme Durumu : " + d[i].gecmedurumu());
            System.out.println("************");
        }
        
        
    }
}

class ogrenci{
    int no;
    String isim;
    int vize,genel;
    char cinsiyet;
    public ogrenci(int no, String isim, int vize, int genel, char cinsiyet){
        this.no=no;
        this.isim=isim;
        this.vize=vize;
        this.genel=genel;
        this.cinsiyet=cinsiyet;
    }
    
    double ortalama(){
        return vize*0.4+genel*0.6;
    }
    
    String gecmedurumu(){
        if(ortalama()>=50)
            return "Geçti..";
        else
            return "Kaldı..";
    }
}