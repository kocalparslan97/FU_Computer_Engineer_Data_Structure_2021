package Ogretim1_Lecture7;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture7 {

    Dugum kok;

    int derinlik(Dugum N) {
        if (N == null) {
            return 0;
        } else {
            return N.derinlik;
        }
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    //AVL agacinda denge icin dondurme islemi yapiliyor
    Dugum sagRotasyon(Dugum y) {
        Dugum x = y.sol;
        Dugum t2 = x.sag;

        x.sag = y; //y gelen dugum
        y.sol = t2;
        y.derinlik = max(derinlik(y.sol), derinlik(y.sag)) + 1;
        x.derinlik = max(derinlik(x.sol), derinlik(x.sag)) + 1;

        return x;
    }

    Dugum solRotasyon(Dugum x) {
        Dugum y = x.sag;
        Dugum t2 = y.sol;

        //yer degistirme yapiliyor
        y.sol = x;
        y.sag = t2;

        //derinlik hesabi yapiliyor
        y.derinlik = max(derinlik(y.sol), derinlik(y.sag)) + 1;
        x.derinlik = max(derinlik(x.sol), derinlik(x.sag)) + 1;

        return y;
    }

    int getBalance(Dugum N) {
        if (N == null) {
            return 0;
        } else {
            return derinlik(N.sol) - derinlik(N.sag);
        }
    }

    //AVL Tree ekleme islemi
    Dugum ekle(Dugum dugum, int icerik) {
        if (dugum == null) {
            return (new Dugum(icerik));
        }
        if (icerik < dugum.icerik) {
            dugum.sol = ekle(dugum.sol, icerik);
        } else if (icerik > dugum.icerik) {
            dugum.sag = ekle(dugum.sag, icerik);
        } else {
            return dugum;
        }
        //eklenen yerin atasini derinligini kontrol ettik
        dugum.derinlik = 1 + max(derinlik(dugum.sol), derinlik(dugum.sag));

        int denge = getBalance(dugum);
        //eger dengesizlik varsa bu islemleri yapar
        //sol sol esitsizligi
        //tek rotasyonla cozulebilecek islemler
        if (denge > 1 && icerik < dugum.sol.icerik) {
            return sagRotasyon(dugum);
        } else if (denge < -1 && icerik > dugum.sag.icerik) {
            return solRotasyon(dugum);
        }

        //iki rotasyonla cozulebilenler icin yani sag sol rotasyonu
        if (denge > 1 && icerik > dugum.sol.icerik) {
            dugum.sol = solRotasyon(dugum.sol);
            return sagRotasyon(dugum);
        } else if (denge < -1 && icerik < dugum.sag.icerik) {
            dugum.sag = sagRotasyon(dugum.sag);
            return solRotasyon(dugum);
        }
        return dugum;
    }

    //kok - sol - sag
    void preOrder(Dugum dugum) {
        if (dugum != null) {
            System.out.print(dugum.icerik + ", ");
            preOrder(dugum.sol);
            preOrder(dugum.sag);
        }
    }

    public static void main(String[] args) {
        Lecture7 a = new Lecture7();
        a.kok = a.ekle(a.kok, 9);
        a.kok = a.ekle(a.kok, 7);
        a.kok = a.ekle(a.kok, 11);
        a.kok = a.ekle(a.kok, 5);
        a.kok = a.ekle(a.kok, 13);

        // hata veriyor sonrasinda bak
        //a.kok = a.ekle(a.kok, 12);
        System.out.println("Agacin preOrder Gezintisi :");
        a.preOrder(a.kok);
    }

}

class Dugum {

    int icerik;
    int derinlik;
    Dugum sol, sag;

    public Dugum(int d) {
        icerik = d;
        derinlik = 1;
    }

}
