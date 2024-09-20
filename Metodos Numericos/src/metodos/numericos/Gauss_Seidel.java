package metodos.numericos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Alejandro Valencia Perez 18590257
 */
public class Gauss_Seidel {

    public static void main(String[] args) {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        float xa, xb, xc, xd, errorx1, errorx2, errorx3, errorx4, errormax;
        float x1 = 0, x2 = 0, x3 = 0, x4 = 0;
        int it = 1;

        do {
            System.out.println("\n-------------------------------------");
            System.out.println("\nIteración: " + it);

            xa = (-5 - x2 - (0 * x3) + (2 * x4)) / 8;
            errorx1 = Math.abs(xa - x1);
            x1 = xa;
            errormax = errorx1;

            xb = (3 - x1 + x3 - (2 * x4)) / 7;
            errorx2 = Math.abs(xb - x2);
            x2 = xb;
            if (errormax < errorx2) {
                errormax = errorx2;
            }

            xc = (4 - x1 + x2 + x4) / 4;
            errorx3 = Math.abs(xc - x3);
            x3 = xc;
            if (errormax < errorx3) {
                errormax = errorx3;
            }

            xd = (-3 + (2 * x1) - (2 * x2) + x3) / 6;
            errorx4 = Math.abs(xd - x4);
            x4 = xd;
            if (errormax < errorx4) {
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
            System.out.println("\n-------------------------------------");

        } while (errormax > (1 * Math.pow(10, -16)));

        System.out.println("\nSe Realizaron " + it + " iteraciones");
    }
}
