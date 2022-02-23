package Lecture_4_1;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture_4_1 {

    dugum bas, son;

    public Lecture_4_1() {
        bas = null;
        son = null;
    }

    void ekleme(dugum yeni) {
        if (bas == null) {
            bas = yeni;
        } else {
            son.ileri = yeni;
        }
        son = yeni;
        son.ileri = bas;
    }

    void Listele() {
        dugum tmp = bas;
        while (tmp != null) {
            System.out.print(tmp.icerik + "->");
            tmp = tmp.ileri;
            //bu kısmı ben yazdım
            if (tmp.ileri != bas) {
                break;
            }
        }
    }

    void Listele1() {
        dugum tmp = bas;
        if (bas == null) {
            System.out.println("Liste Boş !!");
        } else {
            System.out.println(tmp.icerik + "->");
            tmp = tmp.ileri;
            while (tmp != bas) {
                tmp = tmp.ileri;
                System.out.println(tmp.icerik + "->");
            }
        }
    }

    public static void main(String[] args) {

        Lecture_4_1 bl = new Lecture_4_1();
        dugum d = new dugum(5);
        dugum d1 = new dugum(6);
        bl.ekleme(d);
        bl.ekleme(d1);
        bl.Listele();

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
