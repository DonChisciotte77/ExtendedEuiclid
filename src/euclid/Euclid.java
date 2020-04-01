package euclid;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class Euclid {
    public BigInteger GCD (BigInteger a, @NotNull BigInteger b) {
        return b.compareTo(BigInteger.valueOf(0)) == 0 ? a : GCD(b, a.mod(b));
    }

    public BigInteger[] extended(BigInteger a, BigInteger b, @NotNull BigInteger GCD) {
        if (GCD.compareTo(BigInteger.valueOf(1)) == 0) {
            BigInteger qi = a.divide(b);

            BigInteger s0 = BigInteger.valueOf(1), s1 = BigInteger.valueOf(0), s = BigInteger.valueOf(0);
            BigInteger t0 = BigInteger.valueOf(0), t1 = BigInteger.valueOf(1), t = BigInteger.valueOf(0);

            BigInteger ri = a.subtract(qi.multiply(b));
            while (ri.compareTo(BigInteger.valueOf(0)) != 0) {
                s = s0.subtract(qi.multiply(s1));
                s0 = s1;
                s1 = s;

                t = t0.subtract(qi.multiply(t1));
                t0 = t1;
                t1 = t;

                a = b;
                b = ri;
                qi = a.divide(ri);
                ri = a.subtract(qi.multiply(ri));
            }

            /*while (s < 0)
                s = b + s;

            while (t < 0)
                t = a + t;*/

            return new BigInteger[]{s, t};
        }

        return null;
    }
}
