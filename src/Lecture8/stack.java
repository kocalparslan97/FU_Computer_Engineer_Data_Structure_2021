package Lecture8;

/**
 *
 * @author ALPARSLAN
 */
public class stack {

    int[] y;
    int ust;
    int N;

    public stack(int N) {
        ust = -1;
        y = new int[N];
        this.N = N;
    }

    boolean bosMu() {
        return ust == -1;
    }

    boolean doluMu() {
        return ust == N - 1;
    }

    void push(int v) {
        if (!doluMu()) {
            ust++;
            y[ust] = v;
        }
    }

    int pop() {
        if (!bosMu()) {
            ust--;
            return y[ust + 1];
        } else {
            return -1;
        }
    }

    int peek() {
        return y[ust];
    }

}
