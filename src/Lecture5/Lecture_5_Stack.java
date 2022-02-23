package Lecture5;

/**
 *
 * @author ALPARSLAN
 */
//Bagli Liste ile Stack olusturma
public class Lecture_5_Stack {

    dugum ust;
    int say;
    String ygt;

    public Lecture_5_Stack() {
        say = 0;
        ust = null;
        ygt = "";
    }

    // stack bos mu diye kontrol ediliyor
    boolean bosmu() {
        return ust == null;
    }

    //en üstteki degeri verir
    dugum ustgonder() {
        return ust;
    }

    void ekle(dugum yeni) {
        yeni.ileri = ust;
        ust = yeni;
        ygt = yeni.icerik + ygt;
        say++;
    }

    //stack ten cıkartma islemi yapılıyor
    dugum cikar() {
        dugum e = ust;
        if (!bosmu()) {
            ust = ust.ileri;
            say--;
            ygt = ygt.substring(1, ygt.length());
        }
        return e;
    }

    public static void main(String[] args) {

    }
}

class dugum {

    int icerik;
    dugum ileri;

    public dugum(int icerik) {
        this.icerik = icerik;
        ileri = null;
    }

}
