package metodos.numericos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


/*
 Alejandro Valencia Perez
        18590257
 */
public class Gauss_Jordan {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = 0, i = 0, j = 0, k = 0, dominante = 0;
        double denominador = 0, tolerancia, maximo = 0, acumulador = 0;
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("############# METODO DE GAUSS SEIDEL #############");
        System.out.println("Ingrese el tamaño de la matriz > ");
        n = Integer.parseInt(leer.readLine());

        double A[][] = new double[n][n];
        double X[] = new double[n];
        double XA[] = new double[n];
        double B[] = new double[n];

        for (i = 0; i < n; i++) {
            System.out.println();
            System.out.println("  Ecuacion " + (i + 1));
            for (j = 0; j < n; j++) {
                System.out.println("Ingrese el valor de [x" + (j + 1) + ", R" + (i + 1) + "] = ");
                A[i][j] = Double.parseDouble(leer.readLine());
            }
            System.out.println();
            System.out.println("Ingrese el valor de B" + (i + 1) + " = ");
            B[i] = Double.parseDouble(leer.readLine());
            System.out.println(" ");
        }

        i = 0;
        dominante = 1;
        do {
            for (j = 0; j < n; j++) {
                if (i != j) {
                    if ((A[i][i] <= A[i][j] || A[i][i] <= A[j][i]) && dominante == 1) {
                        dominante = 0;
                    }
                }
            }
            i++;
        } while (i < n && dominante == 1);

        if (dominante == 0) {
            System.out.println("El coeficiente" + A[i][j] + " de la ecuación " + i + " no es dominante");
            System.exit(1);
        }

        maximo = 1000;
        tolerancia = 10 * Math.pow(10, -12);
        do {
            i = 0;
            do {
                XA[i] = X[i];
                i++;
            } while (i < n);
            i = 0;
            do {
                acumulador = 0;
                j = 0;
                do {
                    if (i == j) {
                        denominador = A[i][i];
                    } else {
                        acumulador = acumulador - A[i][j] * X[j];
                    }
                    j++;
                } while (j < n);
                X[i] = (B[i] + acumulador) / denominador;
                i++;
            } while (i < n);

            maximo = 0;
            i = 0;
            do {
                if (maximo < (Math.abs(X[i] - XA[i]))) {
                    maximo = Math.abs(X[i] - XA[i]);
                }
                i++;
            } while (i < n);
        } while (maximo >= tolerancia);

        System.out.println("##########Valores de variables##########");
        for (i = 0; i < n; i++) {
            System.out.println("x" + (i + 1) + " = " + X[i]);
        }
        System.out.println();
        System.out.println("Error Maximo = " + maximo);
    }
}
