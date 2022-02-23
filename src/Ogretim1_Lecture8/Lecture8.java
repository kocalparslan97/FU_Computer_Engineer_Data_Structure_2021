package Ogretim1_Lecture8;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture8 {

    final int dugum_sayisi = 20; //max dugum sayisi
    Dugum dugumList[]; //dugum listesi
    int kmatris[][]; //komsuluk matrisi , satir ve sutunlarda dugumler var
    int gdugum; //gecerli dugum

    public Lecture8() {
        dugumList = new Dugum[dugum_sayisi];
        kmatris = new int[dugum_sayisi][dugum_sayisi];
        gdugum = 0;

        for (int i = 0; i < dugum_sayisi; i++) {
            for (int j = 0; j < dugum_sayisi; j++) {
                kmatris[i][j] = 0;
            }

        }
    }

    //graf a dugum eklme islemi
    void dugumEkle(char etkt) {
        //etiket dedigimiz dugumun ismi
        //burada dugum olusturuyoruz
        dugumList[gdugum] = new Dugum(etkt);
        gdugum++;
    }

    //ayrit ekleme islemi
    void ayritEkle(int bas, int bitis) {
        //hem bas hemde bitis e 1 degerini atar
        kmatris[bas][bitis] = 1;
        kmatris[bitis][bas] = 1;
    }

    //istenilen dugumu gosteren metod
    void dugumGoster(int v) {
        System.out.println(dugumList[v].etiket);
    }

    //graf ın komsuluk matrisini gosteren metod
    void kmatrisGoster() {
        for (int i = 0; i < gdugum; i++) {
            for (int j = 0; j < gdugum; j++) {
                System.out.print(kmatris[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //herhangi bir dugumu alan ve o dugumun derecesini veren metod
    int dereceHesapla(int d) {
        int derece = 0;
        for (int i = 0; i < gdugum; i++) {
            if (kmatris[d][i] == 1) {
                derece++;
            }
        }
        return derece;
    }

    //Odev : En yuksek dereceye sahip dugumu bul
    //benim yazdigim 
    void enbDereceBul() {
        int derece = 0;
        int enb = derece;
        for (int i = 0; i < gdugum; i++) {
            int temp = dereceHesapla(i);
            if (temp > enb) {
                enb = temp;
                dugumGoster(enb);
                break;
            } else {
                System.out.println("hatali");
            }
        }

    }

    public static void main(String[] args) {
        Lecture8 g = new Lecture8();
        g.dugumEkle('a'); //0. dugum
        g.dugumEkle('b'); //1. dugum
        g.dugumEkle('c'); //2. dugum
        g.dugumEkle('d'); //3. dugum
        g.dugumEkle('e'); //4. dugum

        g.ayritEkle(0, 1); //0. ve 1. dugum arasina ayrit ekleniyor
        g.ayritEkle(1, 2); //1. ve 2. dugum arasina ayrit ekleniyor
        g.ayritEkle(0, 3); //0. ve 3. dugum arasina ayrit ekleniyor
        g.ayritEkle(3, 4); //3. ve 4. dugum arasina ayrit ekleniyor

        //kmatris goster
        g.kmatrisGoster();
        System.out.println("0. dugum derecesi : " + g.dereceHesapla(2));
        System.out.print("En Buyuk Dereceye Sahip Dugum : ");
        g.enbDereceBul();
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
