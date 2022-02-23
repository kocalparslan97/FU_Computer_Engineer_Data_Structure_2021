package Vize_2013;

/**
 *
 * @author ALPARSLAN
 */
/*
Soru 1 : Öğrenci verisi olarak sadece not bilgisi tutulacaktır.
        a)[15] Düğüm ve bağlı yığıt yapısını push ve pop metotları ile beraber veriniz
        b)[20] Yığıtın bağları üzerinde gezinmeden push ve pop metotları kullanarak 
        girilen yığıt nesnesinin not ortalamasını bulan bir metot yazınız(Birden Fazla yığıt 
        nesnesi kullanılacaktır)
        c)[20] İki Bağlı yığıtı push ve pop metotlarını kullanmadan bağ yapılarını 
        değiştirerek birleştirip geri tek bir bağlı yığıt döndüren bir metot yazınız.
*/
public class Soru1 {
    Node top= null;
    
    class Node{
        int not;
        Node next;
    }
  
   // *****a) Seçeneği için*****
    public void push(int not){
        Node nN = new Node();
        nN.not = not;
        nN.next = top;
        top = nN;
    }
    
    public int pop(){
        int temp =-1;
        temp = top.not;
        top = top.next;
        return temp;
        
    }
    //*************************
    //*****b) Seçeneği için*****
    
    
}

