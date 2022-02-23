package Lecture6;

/**
 *
 * @author ALPARSLAN
 */
//Kuyruk ile ilgili örnek
public class Lecture_6_Queue {

    eleman bas, son;
    String S;

    public Lecture_6_Queue() {
        bas = null;
        son = null;
        S = "";
    }

    boolean bosmu() {
        return bas == null;
    }

    //kuyruga ekleme metodu
    void ekle(eleman yeni) {
        if (!bosmu()) {
            son.ileri = yeni;
            son = yeni;
        } else {
            bas = yeni;
            son = yeni;
        }
        S = S + yeni.icerik;
    }

    //kuyruktan cikartma islemi
    eleman cikar() {
        //eleman olarak tanımlanması geri dönüs olarak veriyi return eder
        eleman sonuc = bas;
        if (!bosmu()) {
            bas = bas.ileri;
            S = S.substring(1, S.length());
            if (bas == null) {
                son = null;
            }
        }
        return sonuc;
    }

    public static void main(String[] args) {

    }
}

class eleman {

    int icerik;
    eleman ileri;

    public eleman(int icerik) {
        this.icerik = icerik;
        ileri = null;
    }

}
