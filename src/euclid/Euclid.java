package euclid;

public class Euclid {
    public int GCD (int a, int b) { return b==0 ? a : GCD(b, a % b); }

    public int[] extended(int a, int b, int GCD) {
        if (GCD == 1) {
            int qi = a / b;

            int s0 = 1, s1 = 0, s = 0;
            int t0 = 0, t1 = 1, t = 0;

            int ri = a - qi * b;
            while (ri != 0) {
                s = s0 - qi * s1;
                s0 = s1;
                s1 = s;

                t = t0 - qi * t1;
                t0 = t1;
                t1 = t;

                a = b;
                b = ri;
                qi = a / ri;
                ri = a - qi * ri;
            }

            return new int[]{ s, t };
        }

        return null;
    }
}
