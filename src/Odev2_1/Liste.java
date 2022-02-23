package Odev2_1;

/**
 *
 * @author ALPARSLAN
 */
public class Liste {

    lst_dgm[] L;
    int tmp;
    int indis, e_uzun;

    public Liste(int M) {
        L = new lst_dgm[M];
        indis = 0;
        e_uzun = 0;
        tmp = 0;
    }

    public void ekle(lst_dgm eleman) {
        L[indis] = eleman;
        ++indis;
        en_uzun(eleman.l.length);
    }

    public int goster(int i, int j) {
        return L[i - 1].deger(j);
    }

    public int uzunluk() {
        int top = 0;
        for (int i = 0; i < indis; i++) {
            top += L[i].l.length;
        }
        return top;
    }

    public void en_uzun(int uzunluk) {
        if (uzunluk >= e_uzun) {
            e_uzun = uzunluk;
        }
    }

    static void program(Liste Lst) {
        minHeapp dene = new minHeapp(Lst.uzunluk());

        for (int i = 0; i < Lst.e_uzun; i++) { // En uzun elemanın eleman sayısı kadar dön

            for (int j = 0; j < Lst.indis; j++) { // Her elemanın ilk elemanını kontrol et

                if ((i + 1) <= Lst.L[j].l.length) {
                    dene.ekle(Lst.L[j].l[i]);
                }
            }
        }
        System.out.println("------MinHeap Ağaç------");
        dene.minHeap();
        dene.yazdir();
        System.out.println("------MaxHeap Ağaç------");
        dene.maxHeap();
        dene.yazdir();
    }

    public static void main(String[] args) {

        System.out.println("**********************Odev-2 B Secenegi *************************");
        //  b) Bu min Heap yapısını kullanarak farklı uzunlukta M tane sıralı
        //     listeyi sıralı olarak O(nlgn) karmaşıklığında birleştiren programı yazınız?
        Liste L = new Liste(5);

        int[] d1 = {3, 5, 6};
        int[] d2 = {1, 10};
        int[] d3 = {2, 7, 8, 46};
        int[] d4 = {4, 9};
        int[] d5 = {11, 13, 23, 44};

        L.ekle(new lst_dgm(d1));
        L.ekle(new lst_dgm(d2));
        L.ekle(new lst_dgm(d3));
        L.ekle(new lst_dgm(d4));
        L.ekle(new lst_dgm(d5));

        //System.out.println(L.goster(3, 4));
        //System.out.println("Toplam Uznuluk: " + L.uzunluk());
        //System.out.println("En Uzun Olan: " + L.e_uzun);
        //System.out.println("Eleman Sayisi: " + L.indis);
        program(L);
        System.out.println("**************************************************");
    }
}

class lst_dgm {

    int[] l;

    public lst_dgm(int[] l) {
        this.l = l;
    }

    public int deger(int j) {
        return l[j - 1];
    }
}
