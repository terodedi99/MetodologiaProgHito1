package metod.prog.sesion1;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MetodProgSesion1{
    private static final Scanner teclado = new Scanner(System.in);
    private static FileOutputStream archivo;
    private static OutputStreamWriter escribir;
    private static BufferedWriter escritor;
    private static int opcion = -1;
    
public static void main(String[] args) throws IOException {
    archivo = new FileOutputStream("prueba.txt");
    escribir = new OutputStreamWriter(archivo);
    escritor = new BufferedWriter(escribir);
    cabecera();
    menu();
    pruebaEmpirica();
        escritor.flush();
        escritor.close();
        escribir.close();
        archivo.close();
    }

public static void menu() throws IOException{
    
    System.out.print("Elige una de las siguientes opciones:"
        + "\n 1. Mostrar tiempo en nanosegundos."
        + "\n 2. Mostrar tiempo en milisegundos.\n");
            
    int aux = teclado.nextInt();
            
    switch (aux) {
        case 1:
            opcion = aux;
            break;
                    
        case 2:
            opcion = aux;
            break;
                    
        default:
            System.out.println("Opcion no válida. Sólo números del 1 al 2.");
            break;
                    
            }           
    }

public static void cabecera() throws IOException{
    escritor.write("Al analizar las complejidades de forma teórica hemos obtenido\n" +
"las siguientes conclusiones:");escritor.newLine();
        escritor.write("\t-Iterativo1: complejidad constante O(1)\n");escritor.newLine();
        escritor.write("\t-Iterativo2: complejidad lineal O(n)\n");escritor.newLine();
        escritor.write("\t-Recursivo1: complejidad lineal O(n)\n");escritor.newLine();
        escritor.newLine();
        escritor.write("Para calcular las complejidades de forma empírica hemos dado\n" +
"a n los valores entre 0 y 1000 con un incremento de 10 en 10.");escritor.newLine();
escritor.newLine();
        escritor.write("Observamos que los valores que nos devuelve el programa no \n" +
"tienen un incremento constante, debido a que el ordenador no");escritor.newLine();
        escritor.write("está dedicado únicamente a la medida de tiempo de estos\n" +
"algortitmos, es decir que como dedica su capacidad a varias");escritor.newLine();
        escritor.write("tareas, los tiempos obtenidos no son exactos ni constantes.");escritor.newLine();
        escritor.newLine();
        escritor.write("T1 = iterativo1; T2 = iterativo2; T3 = recursivo1");
        escritor.newLine();
        escritor.write("Todos los tiempos son en nanosegundos");
        escritor.newLine();
        escritor.newLine();
        escritor.write("Numero \t T1 \t T2 \t T3 \t ite1 \t ite2 \t recu");
        escritor.newLine();
        escritor.write("--------------------------------------------------");
        escritor.newLine();
}


public static void pruebaEmpirica() throws FileNotFoundException, IOException{
        String linea;
        long ini;
        long end;
        double ite1 = -1;
        double ite2 = -1;
        double recu = -1;
        
        
        for(int i = 0;i<=10000;i+=50){
            linea = Integer.toString(i)+"\t|";
            switch(opcion){
                case 1:
                    ini = System.nanoTime();
                    ite1 = iterativo1(i);
                    end = System.nanoTime();
                    linea += Long.toString(end-ini)+"\t|";
                    ini = System.nanoTime();
                    ite2 = iterativo2(i);
                    end = System.nanoTime();
                    linea += Long.toString(end-ini)+"\t|";
                    ini = System.nanoTime();
                    recu = recursivo1(i);
                    end = System.nanoTime();
                    linea += Long.toString(end-ini)+"\t|"; 
                    break;
                case 2:
                    ini = System.currentTimeMillis();
                    ite1 = iterativo1(i);
                    end = System.currentTimeMillis();
                    linea += Long.toString(end-ini)+"\t|";
                    ini = System.currentTimeMillis();
                    ite2 = iterativo2(i);
                    end = System.currentTimeMillis();
                    linea += Long.toString(end-ini)+"\t|";
                    ini = System.currentTimeMillis();
                    recu = recursivo1(i);
                    end = System.currentTimeMillis();
                    linea += Long.toString(end-ini)+"\t|"; 
                    break;
            }
            linea += ite1+"\t|";  
            linea += ite2+"\t|";  
            linea += recu+"\t|";  
            escritor.write(linea);
            escritor.newLine();
        }  
    }

    public static double iterativo1(int n){
        double res = 2*n*n-n;
        return res;
    }
    
    public static double iterativo2(int n){
        double res = 0;
        for(int i = 0;i<n;i++){
            res += 4*i+1;
        }
        return res;
    }
    
    public static double recursivo1(int n){
        double res = 0;
        if(n > 0){
            res += 4*(n-1)+1;
            res += recursivo1(n-1);
        }
        return res;
    }

}
  
    

