package Lecture8;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture8 {

    public static void main(String[] args) {

        graf g = new graf();
        g.dugumEkle('A'); //0. dugum
        g.dugumEkle('B'); //1. dugum
        g.dugumEkle('C'); //2. dugum
        g.dugumEkle('D'); //3. dugum
        g.dugumEkle('E'); //4. dugum
        g.dugumEkle('F'); //5. dugum

        g.kenarEkle(0, 1); //grafin 0. ve 1. dugumleri arasinda bir kenar yani ayrit ekleniyor
        g.kenarEkle(1, 3);
        g.kenarEkle(1, 5);
        g.kenarEkle(3, 5);
        g.kenarEkle(2, 3);
        g.kenarEkle(0, 2);
        g.kenarEkle(2, 4);

        System.out.println("Komsuluk Matrisi :");
        g.kmatrisGoster();
        //g.kmatrisgoster();

        System.out.println("1. Dugumun Derecesi :" + g.dereceHesapla(1));
        System.out.println("5. Dugumun Derecesi :" + g.derece(5));

        System.out.println("Graf'larda DFS Algoritmasi :");
        //bu algoritma ile gezdigi dugumleri gosteriyor
        g.dfs();
    }
}

class graf {

    final int max_dug = 20; // max dugum sayisi
    Dugum dList[]; //dugum listesi
    int kmatris[][]; // komsuluk matrisi
    int gdugum; //gecerli dugum sayisi

    public graf() {
        dList = new Dugum[max_dug];
        kmatris = new int[max_dug][max_dug];
        gdugum = 0;

        for (int i = 0; i < max_dug; i++) {
            for (int j = 0; j < dList.length; j++) {
                kmatris[i][j] = 0;
            }
        }
    }

    //graf a dugum ekleme islemi
    void dugumEkle(char etiket) {
        dList[gdugum] = new Dugum(etiket);
        gdugum++;
    }

    //graf a ayrit ekleme islemi
    void kenarEkle(int bas, int bitis) {
        kmatris[bas][bitis] = 1;
        kmatris[bitis][bas] = 1;
    }

    // graf , dugumunu gosteren metod
    void dugumGoster(int v) {
        System.out.println(dList[v].etiket + ", ");
    }

    //komsuluk matrisini gosteren metod
    void kmatrisGoster() {
        for (int i = 0; i < gdugum; i++) {
            for (int j = 0; j < gdugum; j++) {
                System.out.print(kmatris[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //hocanin yazdigi kmatris goster metodu
    void kmatrisgoster() {
        for (int i = 0; i < gdugum; i++) {
            for (int j = 0; j < gdugum; j++) {
                System.out.print(kmatris[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Girilen dugumun derecesini gosteren metod
    int dereceHesapla(int d) {
        int derece = 0;

        for (int i = 0; i < gdugum; i++) {
            if (kmatris[d][i] == 1) {
                derece++;
            }
        }
        return derece;
    }

    //hocanin yazdigi derece hesaplama metodu
    String derece(int v) {
        int d = 0;
        for (int i = 0; i < gdugum; i++) {
            if (kmatris[v][i] == 1) {
                d++;
            }
        }
        return dList[v].etiket + " . dugum derecesi :" + d;
    }

    //en dusuk dereceli dugum u gosteren metod
    //benim yazdigim
    void enkucukDerece() {
        int derece = 0;
        int enk = dereceHesapla(derece);

        for (int i = 0; i < gdugum; i++) {
            int temp = dereceHesapla(i);
            if (temp < enk) {
                enk = temp;
            }
            System.out.println(temp);
        }
    }

    //dugum un ziyaret edilem durumunu kontrol eden metod
    int getZiyaretEdilmemis(int v) {
        for (int i = 0; i < gdugum; i++) {
            if (kmatris[v][i] == 1 && dList[i].visited == false) {
                return i; //v girilen dugumun i 'ninci komsusu
            }
        }
        return -1;
    }

    //DFS Algoritmasi graflarda
    void dfs() {
        dList[0].visited = true;
        dugumGoster(0);
        stack y = new stack(max_dug); //yani 20
        y.push(0);

        while (!y.bosMu()) {
            int v = getZiyaretEdilmemis(y.peek());

            //eger ziyaret edilmis ise yigittan cikart
            if (v == -1) {
                int cikan = y.pop();
                System.out.println("Stack'ten Cikan :" + dList[cikan].etiket + " -> " + cikan);
            } else {
                //eger ziyaret edilmis ise yigit a ekle
                dList[v].visited = true;
                dugumGoster(v);
                y.push(v);
            }
        }

        //class ın bir elemani oldugu icin sirayla
        //visited ozelligini false yaptik gazinme
        //yapabilmek icin
        for (int i = 0; i < gdugum; i++) {
            dList[i].visited = false;
        }
    }
}

class Dugum {

    char etiket;
    boolean visited;

    public Dugum(char etiket) {
        this.etiket = etiket;
        visited = false;
    }

}
