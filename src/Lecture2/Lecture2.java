package Lecture2;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture2 {
 
    public static void main(String [] args){
        
        hasta[] hastalar = new hasta[4];
        hastalar[0] = new hasta(12, "Ahmet", 'E', 45);
        hastalar[1] = new hasta(14, "Ayşe", 'K', 75);
        hastalar[2] = new hasta(16, "Mehmet", 'E', 21);
        hastalar[3] = new hasta(17, "Veli", 'E', 35);
        
        for(int i=0;i<hastalar.length;i++){
            System.out.println("İsmi :" + hastalar[i].isim + ", Numarası : " + hastalar[i].no
                     + ", Cinsiyet : " + hastalar[i].cinsiyet + ", Yaşı : " + hastalar[i].yas + "\n");
        }
        
        int top=0;
        int sayac=0;
        int ort;
        if(sayac<hastalar.length){
            top+= hastalar[sayac].yas;
            sayac++;
        }
        
        ort= top/sayac;
        System.out.println("Yas Ort : " + ort);
        
    }
}
class hasta {
    int no;
    String isim;
    char cinsiyet;
    int yas;
    
    public hasta(int no, String isim, char cinsiyet, int yas){
        this.no=no;
        this.isim=isim;
        this.cinsiyet=cinsiyet;
        this.yas=yas;
    }
    
    String Risklimi(){
        if(yas>60) return "Riskli";
        else return "Risksiz";
    }
}