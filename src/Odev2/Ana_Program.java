package Odev2;

/**
 *
 * @author ALPARSLAN
 */
public class Ana_Program {

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

    static void dizi_elm_tpl(int[] dz, int deger) {
        boolean durum = false;
        for (int i = 0, j = i + 1; (i < dz.length - 1) && (j < dz.length); j++) {

            if ((dz[i] + dz[j]) == deger) {
                System.out.println((i + 1) + ". eleman ile " + (j + 1) + ". eleman koşulu sağlar");
                durum = true;
            }

            if (j == dz.length - 1) {
                ++i;
                j = i;
            }
        }
        if (durum == false) {
            System.out.println("Koşulu sağlayan eleman çifti bulunamadı.");
        }
    }

    static void anagram_kontrol(String str1, String str2) {
        boolean durum = false;
        if (str1.length() == str2.length()) {

            for (int i = 0; i < str1.length(); i++) {
                System.out.println(str2.indexOf(str1.charAt(i)));
                if (str2.indexOf(str1.charAt(i)) < 0) {
                    durum = false;
                    i = str1.length();
                } else {
                    durum = true;
                }
            }
        }
        if (durum == true) {
            System.out.println("Bu dizgiler anagram");
        } else {
            System.out.println("Bu dizgiler anagram değil");
        }
    }

    static void alt_kume_kontrol(int[] dz1, int[] dz2) {
        boolean durum = false;
        for (int j = 0; j < dz1.length; j++) {

            if (dz1[j] == dz2[(dz1[j] % dz2.length)]) {
                durum = true;
            } else {

                for (int k = (dz1[j] % dz2.length) + 1; k < dz2.length && k != (dz1[j] % dz2.length); k++) {
                    if (dz1[j] == dz2[k]) {
                        durum = true;
                    }
                }
            }
        }
        if (durum) {
            System.out.println("Alt küme");
        } else {
            System.out.println("Alt küme değil");
        }
    }

    public static void main(String[] args) {
        // {+} 1. Soru
        // [+] 1.A Şıkkı
        System.out.println("Heap Ağacı");
        minHeapp minHeap = new minHeapp(15);
        minHeap.ekle(5);
        minHeap.ekle(3);
        minHeap.ekle(17);
        minHeap.ekle(10);
        minHeap.ekle(84);
        minHeap.ekle(19);
        minHeap.ekle(6);
        minHeap.ekle(22);
        minHeap.ekle(9);

        minHeap.yazdir();
        System.out.println("Ağaçtaki En Küçük Değer :" + minHeap.remove());
        System.out.println("Ağaçtaki En Küçük Değer :" + minHeap.remove());
        // [-] 1.A Şıkkı

        // --------------------------------
        // [+] 1.B Şıkkı
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
        // [-] 1.B Şıkkı

        // --------------------------------
        // [+] 1.C Şıkkı
        System.out.println("------MaxHeap Ağaç------");
        minHeap.maxHeap();
        minHeap.yazdir();
        // [-] 1.C Şıkkı

        // --------------------------------
        // [+] 1.D Şıkkı
        int[] dz = {1, 3, 2, 4, 6, 5, 10, 7, 9, 13, 11, 8, 23, 46, 44};
        System.out.println("Durum: " + minHeap.minHeap_mi(dz));
        // [-] 1.D Şıkkı
        // {-} 1. Soru

    }
}
