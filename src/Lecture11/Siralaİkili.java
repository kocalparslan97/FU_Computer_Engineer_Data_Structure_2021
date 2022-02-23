package Lecture11;

/**
 *
 * @author ALPARSLAN
 */
public class Siralaİkili {

    static int[] ikiliSirala(int[] dizi) {
        int j = -1;
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] < 1) {
                j++;
                int ara = dizi[i];
                dizi[i] = dizi[j];
                dizi[j] = ara;
            }
        }
        return dizi;
    }

    public static void main(String[] args) {

        Siralaİkili s = new Siralaİkili();

        int[] d = {1, 0, 1, 1, 0, 0, 1, 0, 1};
        d = s.ikiliSirala(d);

        for (int i = 0; i < d.length; i++) {
            System.out.print(d[i] + ", ");
        }
    }
}
