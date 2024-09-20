
package metodos.numericos;

import java.io.IOException;
import java.util.Scanner;

/*
 Alejandro Valencia Perez
        18590257
 */
public class Metodo_eliminacion_gaussiana {

    public static void main(String args[]) {
        int i, n, ik, jk, C, j, R;
        double num_pivote, acumula;

        Scanner leer = new Scanner(System.in);
        System.out.println("ingresa la cantidad de ecuaciones.");
        n = leer.nextInt();
        double[][] A = new double[n + 1][n + 1];
        double[] B = new double[n + 1];

        i = 1;
        while (i <= n) {
            j = 1;
            while (j <= n) {
                System.out.println("Ingresa el valor de la matriz " + (i) + ", " + (j));
                A[i][j] = leer.nextFloat();
                j = j + 1;
            }
            System.out.println("Ingresa el valor del vector " + (i));
            B[i] = leer.nextFloat();
            i++;
        }

        i = 1;
        while (i <= n) {
            ik = i + 1;
            while (ik <= n) {
                jk = i;
                num_pivote = -A[i][jk] / A[ik][jk];
                while (jk <= n) {
                    A[ik][jk] = num_pivote * A[i][jk] + A[ik][jk];
                    jk++;
                }
                B[ik] = num_pivote * B[i] + B[ik];
                ik++;
            }
            i++;
        }

        R = n;
        while (R >= 1) {
            C = R + 1;
            acumula = 0;
            while (C <= n) {
                acumula = acumula + A[R][C] * B[C];
                C++;
            }
            B[R] = (B[R] - acumula) / A[R][R];
            R = R - 1;
        }

        R = 1;
        System.out.println("Los valores de x son: ");
        while (R <= n) {
            System.out.println("x" + R + "=" + B[R]);
            R++;
        }

    }

}
