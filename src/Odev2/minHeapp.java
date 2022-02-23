package Odev2;

/**
 *
 * @author ALPARSLAN
 */
public class minHeapp {

    private Dugum[] Dizi;
    int doluluk;
    private int boyut;
    private Dugum ilk;
    boolean takas;

    private static final int FRONT = 1;

    public minHeapp(int boyut) {
        ilk = new Dugum(Integer.MIN_VALUE);
        this.boyut = boyut;
        this.doluluk = 0;
        Dizi = new Dugum[this.boyut + 1];
        Dizi[0] = ilk;
        takas = false;

    }

    // Aktif düğümün ebeveyninin dizi üzerindeki indis bilgisi
    private int ebeveyn(int aktif) {
        return aktif / 2;
    }

    // Aktif düğümün sol çocuğunun dizi üzerindeki indis bilgisi
    private int sol_cocuk(int aktif) {
        return (2 * aktif);
    }

    // Aktif düğümün sag çocuğunun dizi üzerindeki indis bilgisi
    private int sag_cocuk(int aktif) {
        return (2 * aktif) + 1;
    }

    // Düğüm bir yaprak mı? Evet ise sonuç: True
    private boolean yaprak_mi(int aktif) {
        if (aktif > (doluluk / 2) && aktif <= doluluk) {
            return true;
        }
        return false;
    }

    // Düğümlerin yerini değiştirir.
    private void yer_degis(int bb, int ogl) {
        takas = true;
        Dugum tmp;
        tmp = Dizi[bb];
        Dizi[bb] = Dizi[ogl];
        Dizi[ogl] = tmp;
    }

    // postaki düğümü yığınlama işlemi
    private void yiginla(int aktif) {
        // Düğüm yaprak değilse ve çocuğundan büyükse
        if (!yaprak_mi(aktif)) {
            if (Dizi[aktif].icerik > Dizi[sol_cocuk(aktif)].icerik || Dizi[aktif].icerik > Dizi[sag_cocuk(aktif)].icerik) {

                // Sol çocuk sağdan küçükse
                // Sol çocukla yer değiştir ve soldaki çocuğu yığınla
                if (Dizi[sol_cocuk(aktif)].icerik < Dizi[sag_cocuk(aktif)].icerik) {
                    yer_degis(aktif, sol_cocuk(aktif));
                    yiginla(sol_cocuk(aktif));
                } // Sağ çocukla yer değiştir ve sağdaki çocuğu yığınla
                else {
                    yer_degis(aktif, sag_cocuk(aktif));
                    yiginla(sag_cocuk(aktif));
                }
            }
        }
    }

    private void yiginla2(int aktif) {
        // Düğüm yaprak değilse ve çocuğundan büyükse

        if (!yaprak_mi(aktif)) {
            if (Dizi[aktif].icerik < Dizi[sol_cocuk(aktif)].icerik || Dizi[aktif].icerik < Dizi[sag_cocuk(aktif)].icerik) {

                // Sol çocuk sağdan küçükse
                // Sol çocukla yer değiştir ve soldaki çocuğu yığınla
                if (Dizi[sol_cocuk(aktif)].icerik < Dizi[sag_cocuk(aktif)].icerik) {
                    yer_degis(aktif, sag_cocuk(aktif));
                    yiginla2(sag_cocuk(aktif));
                } // Sağ çocukla yer değiştir ve sağdaki çocuğu yığınla
                else {
                    yer_degis(aktif, sol_cocuk(aktif));
                    yiginla2(sol_cocuk(aktif));
                }
            }
        }
    }

    // Düğüm ekleme
    public void ekle(int deger) {
        if (doluluk >= boyut) {
            return;
        }
        Dugum yeni_dgm = new Dugum(deger);
        Dizi[++doluluk] = yeni_dgm;
        int yeni = doluluk;

        while (Dizi[yeni].icerik < Dizi[ebeveyn(yeni)].icerik) {
            yer_degis(yeni, ebeveyn(yeni));
            yeni = ebeveyn(yeni);
        }
    }

    // Ağaç içeriğini yazdırma
    public void yazdir() {
        for (int i = 1; i <= doluluk / 2; i++) {
            if (doluluk % 2 == 0 && i == doluluk / 2) {
                System.out.print("\t EBEVEYN : " + Dizi[i].icerik
                        + "\n Sol Çocuk :" + Dizi[2 * i].icerik + "\n");
                System.out.println();
            } else {
                System.out.print("\t EBEVEYN : " + Dizi[i].icerik
                        + "\n Sol Çocuk :" + Dizi[2 * i].icerik
                        + " - Sağ Çocuk :" + Dizi[2 * i + 1].icerik + "\n");
                System.out.println();
            }
        }
    }

    // Function to build the min heap using
    // the minHeapify
    // minhepify fonksiyonunu kullanarak yığınlama işlemi
    public void minHeap() {
        for (int pos = (doluluk / 2); pos >= 1; pos--) {
            yiginla(pos);
        }
    }

    public void maxHeap() {
        for (int pos = (doluluk / 2); pos >= 1; pos--) {
            yiginla2(pos);
        }
    }

    public boolean minHeap_mi(int[] Dz) {
        boolean durum = false;
        for (int i = Dz.length / 2; i >= 0; i--) {
            if (!(2 * i + 1 >= Dz.length)) {
                if (!(2 * i + 2 >= Dz.length)) { // Sol ve Sag çocuk varsa
                    if (Dz[i] < Dz[2 * i + 1] && Dz[i] < Dz[2 * i + 2]) {
                        durum = true;
                    } else {
                        durum = false;
                    }
                } else { // Sol çocuk varsa
                    if (Dz[i] < Dz[2 * i + 1]) {
                        durum = true;
                    } else {
                        durum = false;
                    }
                }
            }
        }
        return durum;
    }

    // Eleman silme (Kökteki eleman silinir..!)
    public int remove() {
        int popped = Dizi[FRONT].icerik;
        Dizi[FRONT] = Dizi[doluluk--];
        yiginla(FRONT);
        return popped;
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
        System.out.println("**********************Odev-2 A Secenegi *************************");
        //  a) Tam sayıları tutan bir min Heap yapısı tanımlayarak ekleme, silme
        //     işlemlerini gerçekleştiren kodu yazınız?
        System.out.println("Heap Ağacı :");
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
        //System.out.println("Ağaçtaki En Küçük Değer :" + minHeap.remove());
        System.out.println("**********************Odev-2 C Secenegi *************************");
        //     c)Oluşturduğunuz min-heap’i O(n) zamanda max-heap’e dönüştüren
        //       metodu yazınız?
        System.out.println("------MaxHeap Ağaç------");
        minHeap.maxHeap();
        minHeap.yazdir();
        System.out.println("**********************Odev-2 D Secenegi *************************");
        //      d) Parametre olarak bir dizi alan ve dizinin min-heap olup olmadığını
        //         true veya false olarak döndüren metodu yazınız?
        int[] dz = {1, 3, 2, 4, 6, 5, 10, 7, 9, 13, 11, 8, 23, 46, 44};
        System.out.println("Min-Heap Mi : " + minHeap.minHeap_mi(dz));
        System.out.println("**************************************************");
    }
}

class Dugum {

    int icerik;

    public Dugum(int icerik) {
        this.icerik = icerik;
    }
}
