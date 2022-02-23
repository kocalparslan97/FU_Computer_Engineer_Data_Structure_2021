package Lecture4;

/**
 *
 * @author ALPARSLAN
 */
//cirf yonlu bagli liste ornegi
public class Lecture_4 {

    dugum bas, son;

    public Lecture_4() {
        bas = null;
        son = null;
    }

    void basaEkle(dugum yeni) {
        if (son == null) {
            son = yeni;
        } else {
            yeni.ileri = bas;
            bas.geri = yeni;
        }
        bas = yeni;
    }

    void sonaEkle(dugum yeni) {
        if (bas == null) {
            bas = yeni;
        } else {
            yeni.geri = son;
            son.ileri = yeni;
        }
        son = yeni;
    }

    void bastanSil() {
        bas = bas.ileri;
        if (bas == null) {
            son = null;
        }
    }

}

class dugum {

    int icerik;
    dugum ileri, geri;

    public dugum(int icerik) {
        this.icerik = icerik;
        ileri = null;
        geri = null;
    }

}
