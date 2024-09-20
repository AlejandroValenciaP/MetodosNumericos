package metodos.numericos;

import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.util.Scanner;

public class Metodo_jacobi {

    public Metodo_jacobi() {
    }

    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        double xa, xb, xc, xd, errorx1, errorx2, errorx3, errorx4, errormax = 0;
        double x1 = 0, x2 = 0, x3 = 0, x4 = 0;
        int it = 1;

        System.out.println("\nIngrese el valor inicial de X1");
        xa = Double.parseDouble(entrada.readLine());

        System.out.println("\nIngrese el valor inicial de X2");
        xb = Double.parseDouble(entrada.readLine());

        System.out.println("\nIngrese el valor inicial de X3");
        xc = Double.parseDouble(entrada.readLine());

        System.out.println("\nIngrese el valor inicial de X4");
        xd = Double.parseDouble(entrada.readLine());

        do {
            System.out.println("\n-------------------------------------");
            System.out.println("\nIteración: " + it);

            x1 = (-18 - (3 * xb) + (3 * xd)) / 9;
            errorx1 = Math.abs(x1 - xa);
            errormax = errorx1;

            x2 = (14 - xa + xc - (2 * xd)) / 8;
            errorx2 = Math.abs(x2 - xb);
            if (errorx2 > errormax) {
                errormax = errorx2;
            }

            x3 = (-4 - (3 * xb) - (xd)) / 5;
            errorx3 = Math.abs(x3 - xc);
            if (errorx3 > errormax) {
                errormax = errorx3;
            }

            x4 = (-4 - (2 * xa) - (2 * xb)) / 6;
            errorx4 = Math.abs(x4 - xd);
            if (errorx4 > errormax) {
                errormax = errorx4;
            }

            System.out.println("\nX1 = " + x1);
            System.out.println("\nX2 = " + x2);
            System.out.println("\nX3 = " + x3);
            System.out.println("\nX4 = " + x4);
            System.out.println("\nError X1 = " + errorx1);
            System.out.println("\nError X2 = " + errorx2);
            System.out.println("\nError X3 = " + errorx3);
            System.out.println("\nError X4 = " + errorx4);
            System.out.println("\nError Máximo = " + errormax);
            ++it;
            xa = x1;
            xb = x2;
            xc = x3;
            xd = x4;
            System.out.println("\n-------------------------------------");

        } while (errormax > (1 * Math.pow(10, -16)));

        System.out.println("\nSe Realizaron " + (it - 1) + " iteraciones");
    }

}
