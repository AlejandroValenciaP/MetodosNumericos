package metodos.numericos;
/**
 Alejandro Valencia Perez
        18590257
 */
public class metodo_Simpson {
    public static void main(String[] args) {
        double a, b, c, m, n, i, j, d, h, XH, y, x, k1, k2, k3, Q, L, j1, j2, j3, integral;
        System.out.print("\nINTEGRAL DOBLE SIMPSON");
        System.out.print("\n   Funcion f(x,y) = x^2 + 2xy + 1 \n");
        y = 0;
        a = 0;      //Limite inf x
        b = 5;      //Limite sup x
        c = 0;      //Limite inf y
        d = 5;    //Limite sup y
        m = 4; 	    //# intervalos para y
        n = 4;	    //# intervalos para x
        i = 0;
        j1 = 0;
        j2 = 0;
        j3 = 0;
        h = (b - a) / n;
        XH = (d - c) / m;
        while (i <= n) {
            x = a + (i * h);
            k1 = (Math.pow(x,2) + (2 * (x*c)) + 1)+(Math.pow(x,2) + (2 * (x*d)) + 1);
            k2 = 0;
            k3 = 0;
            j = 1;
            while (j <= m - 1) {
                y = c + j * XH;
                Q = Math.pow(x,2) + ( 2 * (x * y)) + 1;
                if (j % 2 == 0) {
                    k2 = k2 + Q;
                } else {
                    k3 = k3 + Q;
                }
                j++;
            }
            L = (k1 + 2 * k2 + 4 * k3) * XH / 3;
            if (i == 0 || i == m) {
                j1 = j1 + L;
            } else {
                if (i % 2 == 0) {
                    j2 = j2 + L;
                } else {
                    j3 = j3 + L;
                }
            }
            i++;
        }
        integral = h * (j1 + (2 * j2) + (4 * j3)) / 3;
        System.out.print("\nValor de la Integral =  " + integral);
    }
}
