/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos.numericos;

/**
 *
 * @author PRIDE ANACONDA
 */
public class cascsa {

    static double a[][];
    static double b[];
    static double x[];
    static int n;
    static int n2; // Registra el número de saltos de línea
    public static void Elimination() {// eliminación
        PrintA();
        for (int k = 0; k < n; k++) {
            Wrap(k);
            for (int i = k + 1; i < n; i++) {
                double l = a[i][k] / a[k][k];
                a[i][k] = 0.0;
                for (int j = k + 1; j < n; j++) {
                    a[i][j] = a[i][j] - l * a[k][j];
                }
                b[i] = b[i] - l * b[k];
            }
            System.out.println("No." + k + "después de la resta:");
            PrintA();
        }

    }

    public static void Back() // Back generation
    {
        x[n - 1] = b[n - 1] / a[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            x[i] = (b[i] - jisuan(i)) / a[i][i];
        }
    }

    public static double jisuan(int i) {
        double he = 0.0;
        for (int j = i; j <= n - 1; j++) {
            he = he + x[j] * a[i][j];
        }
        return he;
    }
    public static void Wrap(int k) {// Ajuste
        double max = Math.abs(a[k][k]);
        int n1 = k; // Recuerda la línea a intercambiar
        for (int i = k + 1; i < n; i++) // encuentra la línea a intercambiar
        {
            if (Math.abs(a[i][k]) > max) {
                n1 = i;
                max = Math.abs(a[i][k]);
            }
        }
        if (n1 != k) {
            n2++;
            System.out.println("Cuando k =" + k + ", las líneas a intercambiar son:" + k + "y" + n1);
            for (int j = k; j < n; j++) // intercambia la línea de un
            {
                double x1;
                x1 = a[k][j];
                a[k][j] = a[n1][j];
                a[n1][j] = x1;
            }
            double b1; // intercambia la línea de b
            b1 = b[k];
            b[k] = b[n1];
            b[n1] = b1;
            System.out.println("Después del intercambio:");
            PrintA();
        }
    }

    public static void Determinant() {// Buscando determinante
        double DM = 1.0;
        for (int i = 0; i < n; i++) {
            double a2 = a[i][i];
            DM = DM * a2;
        }
        double n3 = (double) n2;
        DM = DM * Math.pow(-1.0, n3);
        System.out.println("Coeficiente determinante del grupo de ecuaciones: det A =" + DM);
    }

    public static void PrintA() {// Matriz de aumento de salida
        System.out.println("La matriz de aumento es:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "    ");
            }
            System.out.print(b[i] + "    ");
            System.out.print("\n");
        }
    }

    public static void Print() {// La raíz de la ecuación de salida
        System.out.println("La raíz del sistema de ecuaciones es:");
        for (int i = 0; i < n; i++) {
            System.out.println("x" + i + " = " + x[i]);
        }
    }

    public static void main(String[] args) {
        //Scanner as=new Scanner(System.in);
        System.out.println("El número de ecuaciones de entrada:");
        //n=as.nextInt();
        n = 2;
        a = new double[n][n];
        b = new double[n];
        x = new double[n];

        double inputA[][] = {{1, 1}, {1, -1}};
        a = inputA;

        double inputB[] = {2, 0};
        b = inputB;

        double inputX[] = {1, 1};

        System.out.println("La matriz de coeficientes a del sistema de ecuaciones de entrada a:");
//        for(int i=1;i<=n;i++)
//        	for(int j=1;j<=n;j++)
//        		a[i][j]=as.nextDouble();
        System.out.println("Sistema de ecuaciones de entrada matriz b:");
//        for(int i=1;i<=n;i++)
//        	b[i]=as.nextDouble();
        Elimination();
        Back();
        Print();
        Determinant();
    }
}
