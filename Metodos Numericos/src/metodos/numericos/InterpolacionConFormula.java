import java.util.Scanner;
import java.io.*;

public class InterpolacionConFormula {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
       int N=2,i,I,J;
       double X,num,acum;
       double x[] = new double [5];
       double y[] = new double [5];
       System.out.println("\t\t\t\"INTERPOLACION MEDIANTE EL METODO DE LARANGE\"");
       System.out.println("Ingrese el número de observaciones");
       N=leer.nextInt();
       N=N-1;
       for(i=0;i<4;i++){
            System.out.println("Ingresa el valor x["+i+"]");
            x[i]=leer.nextDouble();
            System.out.println("Ingresa el valor y{"+i+"]");
            y[i]=leer.nextDouble();
        }
       System.out.println("Ingrese el valor de P(x) deseado ");
        X=leer.nextDouble();
        I=0;
        acum=0;
        do{
            J=0;
            num=1;
            do{
                if(I!=J){
                    num=num*((X-x[J])/(x[I]-x[J]));
                }
                J++;
            }while(J<=N);
            acum=acum+(num*y[I]);
            I++;
        }while(I<=N);
        System.out.println("La interpolación de P("+X+")= "+acum);
    }
    
}