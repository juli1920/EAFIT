import java.util.InputMismatchException;
import java.util.Scanner;

public class Tablero {
    private int numFilas;
    private int numCols;
    private Celda[][] tablero;

    public Tablero(Scanner in){

        while(true){
            System.out.print("Ingrese n° de filas: ");
            try{
                this.numFilas = in.nextInt();
                break;
            } catch (InputMismatchException ignored){
                System.out.println("\n");
                System.out.println("Ingrese un numero entero ");
            }
        }

        System.out.println("\n");

        while(true){
            System.out.print("Ingrese n° de columnas: ");
            try{
                this.numCols = in.nextInt();
                break;
            } catch (InputMismatchException ignored){
                System.out.println("\n");
                System.out.println("Ingrese un numero entero ");
            }
        }

        System.out.println("Tablero creado");
        this.tablero = new Celda[numFilas][numCols];
    }

    public void dibujarTablero(){
        for(int i = 0; i<numFilas; i++){
            for (int j = 0; j<numCols; j++){
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }
}

//TODO METODO DE LLENADO DE LA MATRIZ - LEER EL ARCHVIO CON EL SCANNER