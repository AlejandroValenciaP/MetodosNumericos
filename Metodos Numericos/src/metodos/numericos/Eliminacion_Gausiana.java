package metodos.numericos;
import java.io.IOException;
import java.util.Scanner;
/*
 Alejandro Valencia Perez
        18590257
 */
public class Eliminacion_Gausiana {

    public static void main(String args[]) throws IOException {
        Scanner leer = new Scanner(System.in);
        int i = 0, j = 0, n = 0, ik = 0, jk = 0, R = 0, C = 0;
        double num_pivote, acumula;
        System.out.print("\nELIMINACION GAUSSIANA\n");

        System.out.print("\nInserte el numero de ecuaciones = "
                + "");
        n = leer.nextInt();

        double A[][] = new double[n][n];
        double B[] = new double[n];

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print("Inserte el valor de [X" + (j + 1) + "] [R" + (i + 1) + "] = ");
                A[i][j] = leer.nextDouble();
            }
            System.out.print("Inserte el valor de c" + (i + 1) + " = ");
            B[i] = leer.nextDouble();
            System.out.println(" ");
        }

        j = 0;
        for (i = 0; i < n; i++) {
            for (ik = (i + 1); ik < n; ik++) {
                num_pivote = (-1 * A[ik][i]) / A[i][j];
                for (jk = i; jk < n; jk++) {
                    A[ik][jk] = num_pivote * A[i][jk] + A[ik][jk];

                }
                B[ik] = num_pivote * B[i] + B[ik];
            }
            j++;
        }

        for (R = n - 1; R >= 0; R--) {
            acumula = 0;
            for (C = R + 1; C < n; C++) {
                acumula = acumula + A[R][C] * B[C];

            }
            B[R] = (B[R] - acumula) / A[R][R];
        }

        System.out.println("Los valores de x son: ");
        for (R = 0; R < n; R++) {
            System.out.println("X" + (R + 1) + " = " + B[R]);
        }
    }
}
