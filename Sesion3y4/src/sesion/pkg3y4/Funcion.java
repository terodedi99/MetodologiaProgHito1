/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion.pkg3y4;

/**
 *
 * @author bullroso
 */
public class Funcion {
    
    public static double calc_funcion(int funcion_elegida,double val){
        switch(funcion_elegida){
            case 1:
                return f1(val);
            case 2:
                return f2(val);
            case 3:
                return f3(val);                 
        }
        return 0.0;
    }
    
    public static double f1(double x){
        double num = x*x;
        num -= 2*x;
        num -= 3;
        return num;
    }
    public static double f2(double x){
        double num = Math.pow(2, x);
        num -= x*x;
        num -= 10;
        return num;
    }
    public static double f3(double x){
        double num = Math.sin(x);
        num -= 1/x;
        return num;
    }
}
