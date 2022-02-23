package Odev2;

/**
 *
 * @author ALPARSLAN
 */
public class Odev2 {

    private int[] Heap;
    private int boyut;
    private int maxBoyut;

    private static final int FRONT = 1;

    public Odev2(int maxBoyut) {
        this.maxBoyut = maxBoyut;
        this.boyut = 0;
        Heap = new int[this.maxBoyut + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    //O(nlogn) birlestirme
    //ilk alt dizi -> dizi[left...orta]
    //ikinci alt dizi -> dizi[orta+1...sag]
    public static int[] birlestirmeSiralama(int[] a, int[] b) {

        int[] yeni_dizi = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            yeni_dizi[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }

        while (i < a.length) {
            yeni_dizi[k++] = a[i++];
        }

        while (j < b.length) {
            yeni_dizi[k++] = b[j++];
        }

        return yeni_dizi;
    }

    //Parent dugumu geri donduren metod
    private int parent(int konum) {
        return konum / 2;
    }

    //Mevcut konumdaki dugumun sol dugumunu geri donduruyor
    private int solDugum(int konum) {
        return (2 * konum);
    }

    //Mevcut konumdaki dugumun sag dugumunu geri donduruyor
    private int sagDugum(int pos) {
        return (2 * pos) + 1;
    }

    //O konumdaki dugumun yaprak olup olmadigini boolean geri
    //donduruyor
    private boolean yaprakMı(int konum) {
        if (konum > (boyut / 2) && konum <= boyut) {
            return true;
        }
        return false;
    }

    //Dugumler arasinda yer degistirme yapan metod
    private void yerdegistir(int ilkKonum, int sonKonum) {
        int tmp;
        tmp = Heap[ilkKonum];

        Heap[ilkKonum] = Heap[sonKonum];
        Heap[sonKonum] = tmp;
    }

    //girilen verileri min heap yapisini olusturma
    private void minHeapify(int konum) {

        //bir yaprak olmayan bir dugum
        //herhangi bir alt dugumden buyuk ise
        if (!yaprakMı(konum)) {
            if (Heap[konum] > Heap[solDugum(konum)]
                    || Heap[konum] > Heap[sagDugum(konum)]) {
                if (Heap[solDugum(konum)] < Heap[sagDugum(konum)]) {
                    yerdegistir(konum, solDugum(konum));
                    minHeapify(solDugum(konum));
                } else {
                    yerdegistir(konum, sagDugum(konum));
                    minHeapify(sagDugum(konum));

                }
            }
        }
    }

    //Min Heap ekle islemi
    public void ekle(int eleman) {
        if (boyut >= maxBoyut) {
            return;
        }

        Heap[++boyut] = eleman;
        int mevcut = boyut;

        while (Heap[mevcut] < Heap[parent(mevcut)]) {
            yerdegistir(mevcut, parent(mevcut));
            mevcut = parent(mevcut);
        }
    }

    //Min Heap i ekrana yazdirma
    public void yazdir() {
        for (int i = 1; i < boyut / 2; i++) {
            //Hem Parent dugumleri hemde alt dugumlerini yazdiriyoruz
            System.out.println("PARENT:" + Heap[i]
                    + ", SOL DUGUM:" + Heap[2 * i]
                    + ", SAG DUGUM:" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    //Min Heap 'ten en kucuk degeri silme islemi
    public int sil() {
        int silinen = Heap[FRONT];
        Heap[FRONT] = Heap[boyut--];
        minHeapify(FRONT);

        return silinen;
    }

    //Min Heap'ten Max-Heap'e donustur
    static void MaxHeapify(int dizi[], int i, int n) {
        int altsol = 2 * i + 1;
        int altsag = 2 * i + 2;
        int boyut = i;
        if (altsol < n && dizi[altsol] > dizi[i]) {
            boyut = altsol;
        }
        if (altsag < n && dizi[altsag] > dizi[boyut]) {
            boyut = altsag;
        }
        if (boyut != i) {
            //dizi[i} ile dizi[boyut] yer degistir
            int temp = dizi[i];
            dizi[i] = dizi[boyut];
            dizi[boyut] = temp;
            MaxHeapify(dizi, boyut, n);
        }
    }

    //max -heap olusturma
    static void convertMaxHeap(int dizi[], int n) {
        for (int i = (n - 2) / 2; i >= 0; --i) {
            MaxHeapify(dizi, i, n);
        }
    }

    //O(nlogn) birlestirme
    //ilk alt dizi -> dizi[left...orta]
    //ikinci alt dizi -> dizi[orta+1...sag]
    void merge(int dizi[], int sol, int orta, int sag) {

        //birlestirilecek iki alt dizinin boyutlarini bul
        int n1 = orta - 1 + 1;
        int n2 = sag - orta;
        //gecici dizileri olustur
        int soldizi[] = new int[n1];
        int sagdizi[] = new int[n2];

        //gecici dizilere veriyi kopyalama
        for (int i = 0; i < n1; ++i) {
            soldizi[i] = dizi[sol + i];
        }
        for (int j = 0; j < n2; ++j) {
            sagdizi[j] = dizi[orta + 1 + j];
        }

        //gecici dizileri birlstirme
        //ilk ve ikinci dizilerin indislerini tanimladik
        int i = 0, j = 0;

        //birlestirildiginde kullanilacak indis
        int k = sol;

        while (i < n1 && j < n2) {
            if (soldizi[i] <= sagdizi[j]) {
                dizi[k] = soldizi[i];
                i++;
            } else {
                dizi[k] = sagdizi[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            dizi[k] = soldizi[i];
            i++;
            k++;
        }

        while (j < n2) {
            dizi[k] = sagdizi[j];
            j++;
            k++;
        }
    }

    //bu alt dizileri siralmak icin
    void sort(int dizi[], int sol, int sag) {
        if (sol < sag) {
            //orta degeri bul
            int orta = (sol + sag) / 2;

            //alt dizileri sirala
            sort(dizi, sol, orta);
            sort(dizi, orta + 1, sag);

            //siralanmis alt dizileri birlestir
            merge(dizi, sol, orta, sag);
        }
    }

    //n boyutundaki dizileri ekrana yazdirma
    static void diziYazidir(int dizi[]) {
        int n = dizi.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(dizi[i] + ", ");
        }
        System.out.println();
    }

    //max heap print
    static void printArray(int dizi[], int boyut) {
        for (int i = 0; i < boyut; ++i) {
            System.out.print(dizi[i] + ", ");
        }
    }

    static void maxheapYazdir(int dizi[], int boyut) {
        for (int i = 1; i < boyut / 2; i++) {
            //Hem Parent dugumleri hemde alt dugumlerini yazdiriyoruz
            System.out.println("PARENT:" + dizi[(i - 1) / 2]
                    + ", SOL DUGUM:" + dizi[(2 * i) + 1]
                    + ", SAG DUGUM:" + dizi[(2 * i) + 2]);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //System.out.println("Min Heap Yapisi :");
        Odev2 minHeap = new Odev2(15);

        int dizi[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int dizi1[] = {5, 6, 7, 8, 4, 3, 9, 0, 1, 2, 3, 5};
        int boyut = dizi.length;

        //"ekle" metodu ile Min Heap 'e eleman ekleme
        minHeap.ekle(5);
        minHeap.ekle(3);
        minHeap.ekle(17);
        minHeap.ekle(10);
        minHeap.ekle(84);
        minHeap.ekle(19);
        minHeap.ekle(6);
        minHeap.ekle(22);
        minHeap.ekle(9);

        //Min Heap teki tum elemanlari yazdirma
        minHeap.yazdir();
        //Min Heap 'teki en kucuk elemani gosterme islemi
        System.out.println("The Min Value is :" + minHeap.sil());

        //Odev 2 : C seçeneği
        convertMaxHeap(dizi, boyut);
        //minHeap.maxheapYazdir(dizi, boyut);

        //Odev 2 : B seçeneği
        int mergeDizi[] = new int[dizi.length + dizi1.length];
        mergeDizi = birlestirmeSiralama(dizi, dizi1);
        for (int i = 0; i < mergeDizi.length; i++) {
            System.out.print(mergeDizi[i] + ", ");
        }
    }

}
