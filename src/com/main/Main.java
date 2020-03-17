package com.main;

import utils.Read;
import euclid.Euclid;

import java.util.Arrays;

public class Main {
    private int a;
    private int b;
    private int GCD;
    private int[] coefficients;
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

        if ((a*coefficients[0] + b*coefficients[1]) == this.GCD)
            System.out.println("Calculates are correct.");
        else
            System.out.println("This program does not work.");
    }

    private void calculateBezoutCoefficients() {
        System.out.println("Calculating Bézout coefficients...");

        if (this.b > this.a)
            this.b = K(this.a, this.a = this.b);

        this.coefficients = new Euclid().extended(this.a, this.b, this.GCD);

        if (this.coefficients != null) {
            System.out.println("Bézout coefficients: " + Arrays.toString(coefficients));
            System.out.println();
        }

        System.out.println("GCD != 1");
    }

    private int K(int a, int b) {
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

    private int getNumber(char nameOfNumber) {
        System.out.print("Number " + nameOfNumber + ": ");

        return read.readInt();
    }
}
