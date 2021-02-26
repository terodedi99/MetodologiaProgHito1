/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion.pkg3y4;

import java.util.Scanner;

/**
 *
 * @author bullroso
 */
public class Sesion3y4 {

    /**
     * @param args the command line arguments
     */
    public static Scanner teclado;
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.print(EvaluateString.evaluate("0-2"));
        teclado = new Scanner(System.in);
        UI();
        //System.out.println(EvaluateString.evaluate("4+2.5"));
    }
    
    public static void biseccion(int f, double a, double b, double n){
        //valores para la proxima iteracion
        double valor = (a+b)/2;
        double funcion_calc = Funcion.calc_funcion(f, valor);
        if(Funcion.calc_funcion(f, a) > 0)
            biseccion(f,b,a,n);
        else if(Funcion.calc_funcion(f, a) == 0)
            System.out.println("Valor encontrado en x = "+a);
        else if(Funcion.calc_funcion(f, b) == 0)
            System.out.println("Valor encontrado en x = "+b);
        else if((Funcion.calc_funcion(f, a)*Funcion.calc_funcion(f, b)) >= 0)
            System.out.println("No cumple con en Teorema de Bolzano.");
        else if(Math.abs(Math.abs(a)-Math.abs(b)) < n){
            System.out.println("Valor aproximado en x = "+valor);
        }
        else{   
            if(funcion_calc > 0)
                biseccion(f,a,valor,n);
            else
                biseccion(f,valor,b,n);
        }
    }
    public static void UI(){
        int aux;
        int f = -1;
        String aa;
        double a;
        String bb;
        double b;
        double n;
        try{
        while(f == -1){
            System.out.println("Introduce la funcion que desea.(1, 2 o 3)");
            aux = teclado.nextInt();
            if(aux >= 1 && aux <= 3)
                f = aux;
        }
            System.out.println("Lectura de los limites, para valores expresados en radianes introducir de la siguiente forma");
            System.out.println("5pi/2 --> 5*pi/2");
            System.out.println("Introduce el valor de a ([a,b])");
            aa = teclado.next();
            System.out.println("Introduce el valor de b ([a,b])");
            bb = teclado.next();
            System.out.println("Introduce la precision que desea.(>0)(diferencia entre los dos intervalos)");
            n = teclado.nextDouble();
        a = EvaluateString.evaluate(aa);
        b = EvaluateString.evaluate(bb);
        biseccion(f,a,b,n);
        }
        catch(Exception e){
            System.out.println("Error en la introduccion de valores.");
            e.fillInStackTrace();
        }
    }
}
