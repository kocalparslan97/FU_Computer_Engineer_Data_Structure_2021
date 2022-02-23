package Lecture10;

import java.util.Scanner;

/**
 *
 * @author ALPARSLAN
 */
public class Lecture10 {

    public static void main(String[] args) {
        int graf[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        disktra d = new disktra();
        d.disktraAlg(graf, 0);

    }
}

class disktra {

    int dugum_say = 9;

    //tek bir dugumden diger dugumlere olan en kisa uzakligi veren algoritma
    int minMesafe(int[] mes, boolean[] ziyaret) {
        int min = Integer.MAX_VALUE, min_indis = -1;

        for (int v = 0; v < dugum_say; v++) {
            if (ziyaret[v] == false && mes[v] <= min) {
                min = mes[v];
                min_indis = v;
            }
        }
        return min_indis; // en dusuk agirlikli dugum u geri donduruyor
    }

    void cozumGoster(int[] mes) {
        System.out.println("Çözüm :");
        for (int i = 0; i < dugum_say; i++) {
            System.out.println(i + ". dugum : " + "\t\t -> " + mes[i]);
        }
    }

    void disktraAlg(int[][] graf, int bas) {
        boolean[] ziyaret = new boolean[dugum_say];
        int[] mes = new int[dugum_say];

        for (int i = 0; i < dugum_say; i++) {
            mes[i] = Integer.MAX_VALUE;
            ziyaret[i] = false;
        }
        mes[bas] = 0; //0. dugumun kendisine olan mesafesi

        for (int count = 0; count < dugum_say - 1; count++) {
            //ilk once min mesafe hesapliyoruz
            int u = minMesafe(mes, ziyaret);
            ziyaret[u] = true;
            for (int v = 0; v < dugum_say; v++) {
                //eger ziayret edilmemis ise ve diger yola gore daha az mesafe
                //ise mesafeyi guncelle
                if (!ziyaret[v] && graf[u][v] != 0 && mes[u] != Integer.MAX_VALUE && mes[u] + graf[u][v] < mes[v]) {
                    mes[v] = mes[u] + graf[u][v];
                }
            }
        }
        cozumGoster(mes);
    }
}
