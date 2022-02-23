package Lecture9;

/**
 *
 * @author ALPARSLAN
 */
//Bagli liste ile graf ornegi
public class Lecture9 {

    public static void main(String[] args) {
        graf g = new graf(5); //toplam dugum sayisi

        g.kenarEkle(0, 1);
        g.kenarEkle(0, 3);
        g.kenarEkle(0, 2);
        g.kenarEkle(0, 4);

        g.kenarEkle(1, 0);
        g.kenarEkle(1, 2);
        g.kenarEkle(1, 4);
        g.kenarEkle(1, 3);

        g.kenarEkle(2, 1);
        g.kenarEkle(2, 4);
        g.kenarEkle(2, 3);
        g.kenarEkle(2, 0);

        g.kenarEkle(3, 1);
        g.kenarEkle(3, 4);
        g.kenarEkle(3, 2);
        g.kenarEkle(3, 0);

        g.kenarEkle(4, 1);
        g.kenarEkle(4, 3);
        g.kenarEkle(4, 2);
        g.kenarEkle(4, 0);

        System.out.println("Graf Dugumlerinin Baglantilari :");
        g.kenarGoster();

        System.out.println("Graf'ta Max Dereceli Dugum :");
        g.maxDerece();

        System.out.println("Tam Graf Mı :" + g.TamGrafMı());

    }
}

class Liste {

    Eleman bas, son = null;

    public void listeyeEkle(int n) {
        Eleman e = new Eleman(n);
        if (bas == null) {
            bas = e;
            son = e;
        } else {
            son.ileri = e;
            son = e;
        }
    }

    void listeGoster() {
        Eleman e = bas;
        while (e != null) {
            System.out.print(e.icerik + " ");
            e = e.ileri;
        }
    }

    int elemanSayisi() {
        int e_sayisi = 0;
        Eleman e = bas;

        while (e != null) {
            e_sayisi++;
            e = e.ileri;
        }
        return e_sayisi;
    }
}

class graf {

    Liste[] kenar;
    int N;

    public graf(int N) {
        this.N = N;
        kenar = new Liste[N];

        for (int i = 0; i < N; i++) {
            kenar[i] = new Liste();
        }
    }

    void kenarEkle(int bas, int bitis) {
        kenar[bas].listeyeEkle(bitis);
    }

    void kenarGoster() {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            kenar[i].listeGoster();
            System.out.println("");
        }
    }

    void maxDerece() {
        int maxderece = 0;
        int maxdugum = 0;

        for (int i = 0; i < N; i++) {
            if (kenar[i].elemanSayisi() > maxderece) {
                maxderece = kenar[i].elemanSayisi();
                maxdugum = i;
            }
        }
        System.out.println("Max Dereceli Dugum :" + maxdugum + " -> " + maxderece);
    }

    boolean TamGrafMı() {
        for (int i = 0; i < N; i++) {
            if (kenar[i].elemanSayisi() != N - 1) {
                return false;
            }
        }
        return true;
    }
}

class Eleman {

    int icerik;
    Eleman ileri;

    public Eleman(int icerik) {
        this.icerik = icerik;
        ileri = null;
    }
}
