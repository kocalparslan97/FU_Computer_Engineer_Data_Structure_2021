package Exercise;

import java.util.Scanner;

/**
 *
 * @author ALPARSLAN
 */
public class TekYonlu_LinkedList {

    Ogrenci ilk, son = null;

    public static void main(String[] args) {
        Scanner klavye = new Scanner(System.in);
        TekYonlu_LinkedList ogrenciler = new TekYonlu_LinkedList();
        int secim;

        do {
            System.out.println("*****************************************");
            System.out.println("1 - Ogrenciyi başa ekle");
            System.out.println("2 - Ogrenciyi sona ekle");
            System.out.println("3 - Ogrenciyi araya ekle");
            System.out.println("4 - Ogrencileri listele");
            System.out.println("5 - Baştaki Öğrenciyi Sil");
            System.out.println("6 - Sondaki Öğrenciyi Sil");
            System.out.println("7 - Numarası Girilen Öğrenciyi Sil");
            System.out.println("8 - Numarası Girilen Öğrencilerin bilgilerini getir");
            System.out.println("9 - Listedeki Öğrenci sayısını getir");
            System.out.println("10 - Tek ve Çift numaralı öğrencileri Listele");
            System.out.println("11 - Öğrencilerin sınav ortalamalarını Bul");
            System.out.println("12 - Genel sınav notu en düşük olan öğrenciyi getir");
            System.out.println("0 - Çıkış");
            System.out.println("*****************************************");

            secim = klavye.nextInt();
            System.out.println("*****************************************");

            switch (secim) {
                case 1:
                    System.out.println("Öğrencinin numarsını giriniz :");
                    int bno = klavye.nextInt();
                    System.out.println("Öğrencinin Adını giriniz :");
                    String bad = klavye.next();
                    System.out.println("Öğrencinin Soyadını giriniz :");
                    String bsoyad = klavye.next();
                    System.out.println("Öğrencinin vize sınav notunu giriniz :");
                    int bvize = klavye.nextInt();
                    System.out.println("Öğrencinin Genel sınav notunu giriniz :");
                    int bgenel = klavye.nextInt();
                    ogrenciler.BasaEkle(bno, bad, bsoyad, bvize, bgenel);
                    break;
                case 2:
                    System.out.println("Öğrencinin numarsını giriniz :");
                    int sno = klavye.nextInt();
                    System.out.println("Öğrencinin Adını giriniz :");
                    String sad = klavye.next();
                    System.out.println("Öğrencinin Soyadını giriniz :");
                    String ssoyad = klavye.next();
                    System.out.println("Öğrencinin vize sınav notunu giriniz :");
                    int svize = klavye.nextInt();
                    System.out.println("Öğrencinin Genel sınav notunu giriniz :");
                    int sgenel = klavye.nextInt();
                    ogrenciler.SonaEkle(sno, sad, ssoyad, svize, sgenel);
                    break;
                case 3:
                    System.out.println("Öğrencinin numarsını giriniz :");
                    int ano = klavye.nextInt();
                    System.out.println("Öğrencinin Adını giriniz :");
                    String aad = klavye.next();
                    System.out.println("Öğrencinin Soyadını giriniz :");
                    String asoyad = klavye.next();
                    System.out.println("Öğrencinin vize sınav notunu giriniz :");
                    int avize = klavye.nextInt();
                    System.out.println("Öğrencinin Genel sınav notunu giriniz :");
                    int agenel = klavye.nextInt();
                    System.out.println("Öğrenciyi Eklemek istediğiniz sırayı seçiniz :");
                    int sira = klavye.nextInt();
                    ogrenciler.ArayaEkle(ano, aad, asoyad, avize, agenel, sira);
                    break;
                case 4:
                    ogrenciler.Listele();
                    break;
                case 5:
                    ogrenciler.BastanSil();
                    break;
                case 6:
                    ogrenciler.SondanSil();
                    break;
                case 7:
                    System.out.println("Silmek istenen öürenci no yu giriniz :");
                    int sil_no = klavye.nextInt();
                    ogrenciler.NumaradanSil(sil_no);
                    break;
                case 8:
                    System.out.println("Bilgilerini istediğiniz öğrencinin numarasını giriniz :");
                    int no = klavye.nextInt();
                    ogrenciler.OgrenciBilgileri(no);
                    break;
                case 9:
                    int sayi = ogrenciler.OgrenciSayisi();
                    System.out.println("Listedeki Öğrenci Sayısı : " + sayi);
                    break;
                case 10:
                    ogrenciler.TekCift();
                    break;
                case 11:
                    ogrenciler.OrtalamaBul();
                    break;
                case 12:
                    ogrenciler.DusukGenel();
                    break;
            }
        } while (secim != 0);

    }

    public void BasaEkle(int no, String ad, String soyad, int vize, int genel) {
        Ogrenci ogr = new Ogrenci(no, ad, soyad, vize, genel);
        if (son == null) {
            ilk = ogr;
            son = ogr;
        } else {
            ogr.sonraki = ilk;
            ilk = ogr;
        }
    }

    public void SonaEkle(int no, String ad, String soyad, int vize, int genel) {
        Ogrenci ogr = new Ogrenci(no, ad, soyad, vize, genel);

        if (ilk == null) {
            ilk = ogr;
            son = ogr;
        } else {
            son.sonraki = ogr;
            son = ogr;
        }
    }

    public void ArayaEkle(int no, String ad, String soyad, int vize, int genel, int sira) {
        Ogrenci ogr = new Ogrenci(no, ad, soyad, vize, genel);
        int ogr_Sayisi = OgrenciSayisi();
        int j = 1;
        Ogrenci gecici = ilk;

        if (sira <= ogr_Sayisi) {
            while (gecici != null) {
                if (j == sira) {
                    ogr.sonraki = gecici.sonraki;
                    gecici.sonraki = ogr;
                }
                gecici = gecici.sonraki;
                j++;
            }
        } else {//girilen sayi ogrenci sayısından buyuk ise
            System.out.println("Araya Ekleme yapılamıyor..");
        }
    }

    public void Listele() {
        Ogrenci gecici = ilk;
        while (gecici != null) {
            System.out.println("[ Ogrenci No : " + gecici.no + ", Adı : " + gecici.ad
                    + ", Soyadı : " + gecici.soyad + ", Vize : " + gecici.vize + ", Genel : "
                    + gecici.genel + "]");
            gecici = gecici.sonraki;
        }
    }

    public void BastanSil() {
        ilk = ilk.sonraki;
        if (ilk == null) {
            son = null;
        }
    }

    public void SondanSil() {
        Ogrenci gecici, once;
        gecici = ilk;
        once = null;
        while (gecici != son) {
            once = gecici;
            gecici = gecici.sonraki;
        }
        if (once == null) {
            ilk = null;
            son = null;
        } else {
            once.sonraki = null;
            son = once;
        }
    }

    public void NumaradanSil(int no) {
        Ogrenci gecici, once;
        gecici = ilk;
        once = null;
        while (gecici.no != no) {
            once = gecici;
            gecici = gecici.sonraki;
        }
        once.sonraki = gecici.sonraki;
    }

    public void OgrenciBilgileri(int no) {
        Ogrenci gecici = ilk;
        while (gecici != null) {
            if (gecici.no == no) {
                System.out.println("[ Ogrenci No : " + gecici.no + ", Adı : " + gecici.ad
                        + ", Soyadı : " + gecici.soyad + ", Vize : " + gecici.vize + ", Genel : "
                        + gecici.genel + "]");
                break;
            } else {
                gecici = gecici.sonraki;
            }
        }
    }

    public void TekCift() {
        TekYonlu_LinkedList Tek = new TekYonlu_LinkedList();
        TekYonlu_LinkedList Cift = new TekYonlu_LinkedList();

        Ogrenci gecici = ilk;
        while (gecici != null) {
            if (gecici.no % 2 != 0) {
                Tek.SonaEkle(gecici.no, gecici.ad, gecici.soyad, gecici.vize, gecici.genel);
            } else {
                Cift.SonaEkle(gecici.no, gecici.ad, gecici.soyad, gecici.vize, gecici.genel);
            }
            gecici = gecici.sonraki;
        }
        System.out.println("Tek Numaralı Öğrencilerin Listesi :");
        Tek.Listele();
        System.out.println("Cift Numaralı Öğrencilerin Listesi :");
        Cift.Listele();
    }

    public void OrtalamaBul() {
        double ort = 0;
        Ogrenci gecici = ilk;
        while (gecici != null) {
            ort = gecici.vize * 0.4 + gecici.genel * 0.6;
            System.out.println("Öğrenci No : " + gecici.no + ", Ortalaması : " + ort);
            gecici = gecici.sonraki;
        }
    }

    public void DusukGenel() {
        int not = ilk.genel;
        Ogrenci gecici = ilk;
        Ogrenci tmp = null;
        while (gecici != null) {
            if (gecici.genel < not) {
                not = gecici.genel;
                tmp = gecici;
            }
            gecici = gecici.sonraki;
        }
        System.out.println("En düşük genel sınav notuna sahip öğrenci :");
        System.out.println("[ Öğrenci No : " + tmp.no + ", Adı : " + tmp.ad
                + ", Soyadı : " + tmp.soyad + ", Genel : " + tmp.genel);
    }

    public int OgrenciSayisi() {
        int ogrenci_sayisi = 0;
        Ogrenci gecici = ilk;
        while (gecici != null) {
            ogrenci_sayisi++;
            gecici = gecici.sonraki;
        }
        return ogrenci_sayisi;
    }
}

class Ogrenci {

    int no;
    String ad;
    String soyad;
    int vize;
    int genel;
    Ogrenci sonraki;

    public Ogrenci(int no, String ad, String soyad, int vize, int genel) {
        this.no = no;
        this.ad = ad;
        this.soyad = soyad;
        this.vize = vize;
        this.genel = genel;
        sonraki = null;
    }

}
