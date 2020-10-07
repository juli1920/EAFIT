import java.awt.*;
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

        inputfile.nextLine();

        for(int i = 0; i<numFilas; i++){
            String line = inputfile.nextLine();
            char f = 'd';
            for (int j = 0; j<numCols; j++){
                char x = line.charAt(j);
                if(x == '*'){
                    tablero[i][j] = new Celda(true, false, '*');
                } else if(x == ' ') {
                    tablero[i][j] = new Celda(false, false, ' ');
                } else {
                    tablero[i][j] = new Celda(false, true, 'O');
                }
            }
        }
    }

    public void setCelda(int x, int y, Caracter per){
        this.tablero[x][y].per = per;
        this.tablero[x][y].setCara(per);
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
                char x = tablero[i][j].caracterCelda();
                if(x == '*'){
                    System.out.print(Colors.ANSI_BLUE+x+Colors.ANSI_RESET);
                }
                else if (x == '^'){
                    System.out.print(Colors.ANSI_YELLOW+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                }
                else if(x == 'O'){
                    System.out.print(Colors.ANSI_RED+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                }
                else if(x == ' '){
                    System.out.print(Colors.ANSI_BLACK+x+Colors.ANSI_RESET);
                }
                else if(x == '@'){
                    System.out.print(Colors.ANSI_BLACK+x+Colors.ANSI_RESET);
                }

            }
            System.out.println();
        }
    }

    public void dibujarTablero(boolean gano){
        for(int i = 0; i<numFilas; i++){
            for (int j = 0; j<numCols; j++){
                char x = tablero[i][j].caracterCelda();
                if(x == '*'){
                    System.out.print(Colors.ANSI_BLUE+x+Colors.ANSI_RESET);
                }
                else if (x == '^'){
                    if(gano){
                        System.out.print(Colors.ANSI_WHITE_BACKGROUND+Colors.ANSI_YELLOW+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                    }
                    else{
                        System.out.print(Colors.ANSI_RED_BACKGROUND+Colors.ANSI_WHITE+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                    }
                }
                else if(x == 'O'){
                    System.out.print(Colors.ANSI_RED+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                }
                else if(x == ' '){
                    System.out.print(Colors.ANSI_BLACK+x+Colors.ANSI_RESET);
                }
                else if(x == '@'){
                    System.out.print(Colors.ANSI_BLACK+x+Colors.ANSI_RESET);
                }

            }
            System.out.println();
        }
    }

}
