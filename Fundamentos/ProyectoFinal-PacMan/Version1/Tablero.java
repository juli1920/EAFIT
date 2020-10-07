import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tablero {
    private final int numFilas;
    private final int numCols;
    private Celda[][] tablero;

    public Tablero(Scanner inputfile){
        Scanner in = new Scanner(System.in);

        assert inputfile != null;

        this.numFilas = inputfile.nextInt();
        this.numCols = inputfile.nextInt();

        System.out.println("Tablero creado");
        this.tablero = new Celda[numFilas][numCols];

        for(int i = 0; i<numFilas; i++){
            for (int j = 0; j<numCols; j++){
                char x = inputfile.next().charAt(0);
                if(x == '*'){
                    tablero[i][j] = new Celda(true, false, '*');
                } else if(x == ' ') {
                    tablero[i][j] = new Celda(false, false, ' ');
                }
                else {
                    tablero[i][j] = new Celda(false, true, 'O');
                }
            }
        }
    }

    public void setCelda(int x, int y, Caracter per){
        this.tablero[x][y].per = per;
    }

    public void setCelda(int x, int y, char representacion){
        this.tablero[x][y].car = representacion;
    }

    public Celda getCelda(int x, int y){
        return tablero[x][y];
    }

    public void dibujarTablero(){
        for(int i = 0; i<numFilas; i++){
            for (int j = 0; j<numCols; j++){
                System.out.print(tablero[i][j].caracterCelda());
            }
            System.out.println();
        }
    }
}

//TODO METODO DE LLENADO DE LA MATRIZ - LEER EL ARCHVIO CON EL SCANNER