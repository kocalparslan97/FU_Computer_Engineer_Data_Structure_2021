package Lecture11;

/**
 *
 * @author ALPARSLAN
 */
//AVL Tree ile ilgili ornek
public class Lecture11 {

}

class Dugum {

    int anahtar, yukselik;
    Dugum sol, sag;

    public Dugum(int anahtar) {
        this.anahtar = anahtar;
        yukselik = 1;
        sol = null;
        sag = null;
    }
}

class AVLTree {

    Dugum kok;

    int yukseklik(Dugum N) {
        if (N == null) {
            return 0;
        } else {
            return N.yukselik;
        }
    }

    int maximum(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    Dugum sagaDondur(Dugum y) {
        Dugum x = y.sol;
        Dugum t2 = x.sag;

        x.sag = y;
        y.sol = t2;

        y.yukselik = maximum(yukseklik(y.sol), yukseklik(y.sag)) + 1;
        x.yukselik = maximum(yukseklik(x.sol), yukseklik(x.sag)) + 1;

        return x;
    }

    Dugum solaDondur(Dugum x) {
        Dugum y = x.sag;
        Dugum t2 = y.sol;

        y.sol = x;
        x.sag = t2;

        x.yukselik = maximum(yukseklik(x.sol), yukseklik(x.sag)) + 1;
        y.yukselik = maximum(yukseklik(y.sol), yukseklik(y.sag)) + 1;

        return y;
    }

    int dengeFaktor(Dugum N) {
        if (N == null) {
            return 0;
        } else {
            return yukseklik(N.sol) - yukseklik(N.sag);
        }
    }

    Dugum ekle(Dugum d, int anahtar) {
        if (d == null) {
            return (new Dugum(anahtar));
        }
        if (anahtar < d.anahtar) {
            d.sol = ekle(d.sol, anahtar);
        } else if (anahtar > d.anahtar) {
            d.sag = ekle(d.sag, anahtar);
        } else { //ayni anahtarin eklenmemesi icin
            return d;
        }
        //Dugum yuksekligini ayarla
        d.yukselik = 1 + maximum(yukseklik(d.sol), yukseklik(d.sag));
        int denge = dengeFaktor(d);

        //Sol alt agacin soluna
        if (denge > 1 && anahtar < d.sol.anahtar) {
            return sagaDondur(d);
        }
        //Sag alt agacin sagina
        if (denge < -1 && anahtar > d.sag.anahtar) {
            return solaDondur(d);
        }
        //Sagin soluna
        if (denge < -1 && anahtar < d.sag.anahtar) {
            d.sag = sagaDondur(d.sag);
            return solaDondur(d);
        }
        //Solun sagina
        if (denge > 1 && anahtar > d.sol.anahtar) {
            d.sol = solaDondur(d.sol);
            return sagaDondur(d);
        }
        return d;
    }

    void preOrder(Dugum d) {
        if (d != null) {
            System.out.print(d.anahtar + " | ");
            preOrder(d.sol);
            preOrder(d.sag);
        }
    }

    void inOrder(Dugum d) {
        if (d != null) {
            inOrder(d.sol);
            System.out.print(d.anahtar + " | ");
            inOrder(d.sag);
        }
    }

    void postOrder(Dugum d) {
        if (d != null) {
            inOrder(d.sol);
            inOrder(d.sag);
            System.out.print(d.anahtar + " | ");
        }
    }

    public static void main(String[] args) {

        AVLTree a = new AVLTree();

        a.kok = a.ekle(a.kok, 10);
        a.kok = a.ekle(a.kok, 20);
        a.kok = a.ekle(a.kok, 30);
        a.kok = a.ekle(a.kok, 40);
        a.kok = a.ekle(a.kok, 50);
        a.kok = a.ekle(a.kok, 25);

        System.out.println("Agacin PreOrder Gezinmesi :");
        a.preOrder(a.kok);
        System.out.println("\nAgacin inOrder Gezinmesi :");
        a.inOrder(a.kok);
        System.out.println("\nAgacin postOrder Gezinmesi :");
        a.postOrder(a.kok);
    }
}
