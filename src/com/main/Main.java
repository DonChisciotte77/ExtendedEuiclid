package com.main;

import org.jetbrains.annotations.NotNull;
import utils.Read;
import euclid.Euclid;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    private BigInteger a;
    private BigInteger b;
    private BigInteger GCD;
    private BigInteger[] coefficients;
    private Read read;

    public static void main(String[] args) {
        System.out.println("::::::::: EXTENDED EUCLID :::::::::");
        System.out.println("\nax + by = GCD(a, b)\n");

        Main main = new Main();
        main.calculateGCD();
        main.calculateBezoutCoefficients();
        main.checkCalculates();
    }

    private void checkCalculates() {
        System.out.println("Checking...");
        System.out.println("a: " + this.a + "\n" +
                "b: " + this.b + "\n" +
                "GDC: " + this.GCD + "\n" +
                "Bézout coefficients: " + Arrays.toString(this.coefficients));

        if ((a.multiply(coefficients[0]).add(b.multiply(coefficients[1]))).compareTo(this.GCD) == 0)
            System.out.println("Calculates are correct.");
    }

    private void calculateBezoutCoefficients() {
        System.out.println("Calculating Bézout coefficients...");

        if (b.compareTo(a) > 0)
            this.b = K(this.a, this.a = this.b);

        this.coefficients = new Euclid().extended(this.a, this.b, this.GCD);

        if (this.coefficients != null) {
            System.out.println("Bézout coefficients: " + Arrays.toString(coefficients));
            System.out.println();
        } else {
            System.out.println("GCD != 1");
        }
    }

    private BigInteger K(BigInteger a, BigInteger b) {
        return a;
    }

    private void calculateGCD() {
        System.out.println("Calculating GCD...");
        this.GCD = new Euclid().GCD(this.a, this.b);
        System.out.println("Done.");
        System.out.println("GCD: " + this.GCD);
        System.out.println();
    }

    public Main() {
        this.read = new Read();
        this.a = getNumber('a');
        this.b = getNumber('b');
        System.out.println();
    }

    @NotNull
    private BigInteger getNumber(char nameOfNumber) {
        System.out.print("Number " + nameOfNumber + ": ");
        return BigInteger.valueOf(Long.parseLong(read.readString()));
    }
}
