package Ogretim1_Lecture5;

/**
 *
 * @author ALPARSLAN
 */
//Kuyruk ile ilgili ornek
public class Lecture_5_Queue {

    eleman bas, son;
    String S;

    public Lecture_5_Queue() {
        bas = null;
        son = null;
        S = "";
    }

    boolean bosmu() {
        return bas == null;
    }

    //kuyruga eklem işlemi
    void ekle(eleman yeni) {
        if (!bosmu()) {
            son.ileri = yeni;
            son = yeni;
        } else {
            bas = yeni;
            son = yeni;
        }
        S = S + "<-" + yeni.icerik;
    }

    //kuyruktan cikartma islemi
    eleman cikar() {
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
}

class eleman {

    int icerik;
    eleman ileri;

    public eleman(int icerik) {
        this.icerik = icerik;
        ileri = null;
    }

}
