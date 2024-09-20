package metodos.numericos;
/*
 Alejandro Valencia Perez
        18590257
 */
public class método_Romberg {
    public static void main(String[] args) {
        int k, n, j, m;
        double Segsuma, ha, h, a, b;
        m = 5;
        double O[][] = new double[10][10];
        a = 0;
        b = 5;
        n = 1;
        k = 1;
        Segsuma = 0;
        ha = 0;
        h = 0;
        while (k <= m) {
            h = (b - a) / n;
            j = 1;
            Segsuma = 0;
            while (j <= (n - 1)) {

                Segsuma = Segsuma + (2 * (Math.pow(a + j * h, 2) + (2 * (a + j * h)) + (1)));;
                j = j + 1;
            }
            O[k][1] = (Segsuma + ((Math.pow(a, 2) + (2 * a) + (1)) + (Math.pow(b, 2) + (2 * b) + (1)))) * (h / 2);
            k = k + 1;
            n = 2 * n;
        }
        j = 2;
        while (j <= m) {
            k = j;
            ha = 1 / ((Math.pow(4, (j + 1) - 1)));
            while (k <= m) {
                O[k][j] = O[k][j - 1] + (ha * (O[k][j - 1] - O[k - 1][j - 1]));
                k = k + 1;
            }
            j = j + 1;
        }
        System.out.println("El valor del área entre [" + a + " - " + b + "] = " + O[m][m]);
        System.out.println("Error absoluto " + Math.abs(O[m][m] - O[m][m - 1]));
        System.out.println("Error relativo " + (Math.abs(O[m][m] - O[m][m - 1])) / O[m][m]);
    }
}

