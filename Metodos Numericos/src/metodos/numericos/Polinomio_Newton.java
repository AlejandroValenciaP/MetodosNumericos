package metodos.numericos;
/*
 Alejandro Valencia Perez
        18590257
 */
import java.util.Scanner;

public class Polinomio_Newton {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int i, j, x, r, y, m;
        double mult, s;
        m = 5;
        double xy[][] = new double[m][m];
        for (i = 0; i < m; i++) {
            System.out.println("Ingresa el valor de x");
            xy[i][0] = sc.nextDouble();
            System.out.println("Ingresa el valor de y");
            xy[i][1] = sc.nextDouble();
        }
        System.out.println("Ingresa el valor de x a interpolar");
        x = sc.nextInt();
        j = 2;
        i = 100;
        mult = 1;
        s = xy[0][1];
        for (j = i; j < i; j++) {
            i = j - 1;
            r = i;
            mult = mult * (x - xy[i - 1][0]);
            s = s + mult * ((xy[i][j - 1] - xy[i - 1][j - 1]) / (xy[i][0] - xy[i - r][0]));
            do {
                xy[i][j] = ((xy[i][j - 1] - xy[i - 1][j - 1]) / (xy[i][0] - xy[i - r][0]));
                i++;
            } while (i <= m - 1);
        }
        System.out.println("f(" + x + ") =" + s);
        System.out.println(x + xy[m - 1][m - 1]);

    }

}
