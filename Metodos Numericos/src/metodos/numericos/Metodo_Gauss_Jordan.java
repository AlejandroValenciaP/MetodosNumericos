package metodos.numericos;
import java.util.Scanner;
/*
 Alejandro Valencia Perez
        18590257
 */
public class Metodo_Gauss_Jordan {
    public static void main(String []args){
        int J,N,JK,IK;
        double num_pivote, akk;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresa el tamaño de la matriz");
        N=leer.nextInt();
        double [][]A=new double [N+1][N+1];
        double []B=new double [N+1];
        JK = 1;
        IK = 1;
        while (JK <= N) {
            IK = 1;
            while (IK <= N) {
                System.out.println("Ingresa el valor de la matriz " + (JK) + ", " + (IK));
                A[JK][IK] = leer.nextFloat();
                IK++;
            }
            System.out.println("Ingresa el valor del vector " + (JK));
            B[JK] = leer.nextFloat();
            JK++;
        }
        J=1;
        while(J<=N){
            JK=1;
            akk=A[J][J];
            while(JK<=N){
                A[J][JK]= A[J][JK]/akk;
                JK++;
            }
            B[J]=B[J]/akk;
            
            IK=1;
            while(IK<=N){
                if(IK!=J){
                    JK=1;
                    num_pivote=-A[IK][J];
                    while(JK<=N){
                        A[IK][JK]=num_pivote*A[J][JK]+A[IK][JK];
                        JK++;
                    }
                    B[IK]=num_pivote*B[J]+B[IK];
                }
                IK++;
            }
            J++;
        }
        J=1;
        System.out.println("Los valores de x son: ");
        while (J <= N) {
            System.out.println("x" + J + "=" + B[J]);
            J++;
        } 
    }
}
