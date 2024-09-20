package metodos.numericos;
/*
 Alejandro Valencia Perez
        18590257
 */
public class Segunda_Derivada_Richardson {

    public static void main(String[] args) {
        int x, m, i, j;
        double xmash, xmenosh, k, h;
        x=5;
        h=0.5;
        m=4;
        double N[][]= new double [m+1][m+1];
        i=1;
        j=1;
        do{
            k=h/(Math.pow(2, (i-1)));
            xmash = x+k;
            xmenosh= x-k;
            N[i][j] = 2;
            i++;
        }while(i<=m);
        
        j++;
        do{
            i = j;
            k = (1/(Math.pow(4,(j-1))-1));
            do{
                N[i][j] = N[i][j-1] + k*(N[i][(j-1)]-N[(i-1)][(j-1)]);
                i++;
            }while(i<=m); 
            j++;
        }while(j<=m);
        
        System.out.println("El valor de la derivada es: ");
        System.out.println("f("+x+")= "+N[m][m]);
        System.out.println("Error = "+Math.abs(N[m][m]-N[m][m-1]));
    }
}
