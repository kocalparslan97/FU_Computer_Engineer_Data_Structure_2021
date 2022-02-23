package Odev1_UE;

/**
 *
 * @author ALPARSLAN
 */
public class Odev_Stack {

    dugum ust;
    int say;
    String ygt;

    public Odev_Stack() {
        say = 0;
        ust = null;
        ygt = "";
    }

    boolean bosmu() {
        return ust == null;
    }

    dugum ustgonder() {
        return ust;
    }

    void ekle(dugum yeni) {
        yeni.ileri = ust;
        ust = yeni;
        ygt = yeni.icerik + ygt;
        say++;
    }

    dugum cikar() {
        dugum e = ust;
        if (!bosmu()) {
            ust = ust.ileri;
            say--;
            ygt = ygt.substring(1, ygt.length());
        }
        return e;
    }

    public void printStack() {
        if (bosmu()) {
            return;
        }

        Odev_Stack tmpStack = new Odev_Stack();
        while (!bosmu()) {
            tmpStack.ekle(cikar());
        }
        while (!tmpStack.bosmu()) {
            dugum x = tmpStack.cikar();
            System.out.print("(" + x.icerik + ")");
            ekle(x);
            if (tmpStack.bosmu()) {
                System.out.println("<-top");
            }
        }
    }

    public static void main(String[] args) {
        Odev_Stack s = new Odev_Stack();
        s.ekle(new dugum(5));
        s.ekle(new dugum(4));
        s.ekle(new dugum(6));
        s.ekle(new dugum(3));
        s.ekle(new dugum(2));
        boolean a = s.bosmu();
        System.out.println("Bos Mu ? :" + a);
        s.printStack();
    }
}

class dugum {

    int icerik;
    dugum ileri;

    public dugum(int icerik) {
        this.icerik = icerik;
        ileri = null;
    }

    dugum(String sayi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
