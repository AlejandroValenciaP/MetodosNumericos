package metodos.numericos;

import java.math.*;
import java.util.Scanner;


public class newton_Rapson {
    public double fx(double x){
        return (3*(Math.pow(x, 3))+16*(Math.pow(x, 2))-12*(Math.log(x))-16);
    }
    public double f1(double x) {
        return (9*(Math.pow(x, 2))+(32*x)-(12/x));
    }    

    public double f2(double x){
        return((18*x)+(12/Math.pow(x,2))+325);
    }
        public static void main(String[] args){
            double fx, f1x, f2x, converge, x,xo=0,xa,error;
            String sn;
            Scanner entrada=new Scanner(System.in);
            newton_Rapson obj=new newton_Rapson();
            //validar convergencia
            converge = 2;
            sn = "S";
            while(converge >= 1 && sn.equalsIgnoreCase("S")){
                System.out.println("Dame el valor inicial");
                xo=entrada.nextDouble();
                converge = (obj.fx(xo)*obj.f2(xo))/Math.pow(obj.f1(xo), 2);
                if(converge >=1){
                    sn = "N";
                    System.out.println("No converge");
                    System.out.println("Â¿Otro? xo"+sn);
                }
            }
           //Proceso de iteraciones
           if(sn.equalsIgnoreCase("S")){
               error=2;
               while(error > 1*Math.pow(10, -12)){
                   xa = xo;
                   xo = xo-(obj.fx(xo)/obj.f1(xo));
                   error=Math.abs(xa-xo);
               }
               System.out.println("La raiz es "+xo);
           }
        }  

}
