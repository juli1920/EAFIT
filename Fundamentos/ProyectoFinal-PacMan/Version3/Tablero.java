import java.util.Random;
import java.util.Scanner;

public class Tablero {
    private final int numFilas;
    private final int numCols;
    private Celda[][] tablero;

    public int getNumFilas() {
        return numFilas;
    }

    public int getNumCols() {
        return numCols;
    }

    public Tablero(Scanner inputfile) {
        Scanner in = new Scanner(System.in);

        assert inputfile != null;

        this.numFilas = inputfile.nextInt();
        this.numCols = inputfile.nextInt();

        System.out.println("Tablero creado");
        this.tablero = new Celda[numFilas][numCols];

        inputfile.nextLine();

        for (int i = 0; i < numFilas; i++) {
            String line = inputfile.nextLine();
            char f = 'd';
            for (int j = 0; j < numCols; j++) {
                char x = line.charAt(j);
                if (x == '*') {
                    tablero[i][j] = new Celda(true, false, '*');
                } else if (x == ' ' || x == '@') {

                    tablero[i][j] = new Celda(false, false, x);

                    if(x == '@'){
                        Random r = new Random();
                        int valorDado = r.nextInt(2);
                        boolean explosivo;

                        explosivo = (valorDado == 1);


                        tablero[i][j].setCara(new Arepita(2, new Posicion(i, j), explosivo));
                    }

                } else if (x == 'O') {
                    tablero[i][j] = new Celda(false, true, 'O');
                }
            }
        }
    }

    public void setCelda(int x, int y, Caracter per){
        this.tablero[x][y].personaje = per;
        this.tablero[x][y].setCara(per);
    }

    public void setCelda(int x, int y, char representacion){
        this.tablero[x][y].letra = representacion;
    }

    public Celda getCelda(int x, int y){
        return tablero[x][y];
    }

    public void dibujarTablero(){
        for(int i = 0; i<numFilas; i++){
            for (int j = 0; j<numCols; j++){
                char x = tablero[i][j].caracterCelda();

                if (x == '^'){
                    System.out.print(Colors.ANSI_YELLOW+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                }
                else PrintExtras(x);
            }
            System.out.println();
        }
    }

    public void dibujarTablero(boolean gano, boolean fantasma){
        for(int i = 0; i<numFilas; i++){
            for (int j = 0; j<numCols; j++){
                char x = tablero[i][j].caracterCelda();

                if(x == 'W') {
                    System.out.print(Colors.ANSI_PURPLE_BACKGROUND+Colors.ANSI_BLACK+ x + Colors.ANSI_RESET);
                }
                else if (x == '^'){
                    if(gano){
                        System.out.print(Colors.ANSI_YELLOW+Colors.ANSI_WHITE+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                    } else{
                        System.out.print(Colors.ANSI_RED_BACKGROUND+Colors.ANSI_WHITE+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
                    }
                }
                else PrintExtras(x);
            }
            System.out.println();
        }
    }

    private void PrintExtras(char x) {
        if(x == '*'){
            System.out.print(Colors.ANSI_BLUE+x+Colors.ANSI_RESET);
        } else if(x == 'O'){
            System.out.print(Colors.ANSI_RED+Colors.ANSI_BOLD+x+Colors.ANSI_RESET);
        }
        else if(x == ' '){
            System.out.print(Colors.ANSI_BLACK+x+Colors.ANSI_RESET);
        }
        else if(x == '@'){
            System.out.print(Colors.ANSI_GREEN+x+Colors.ANSI_RESET);
        }
        else if(x == 'W'){
            System.out.print(Colors.ANSI_PURPLE+x+Colors.ANSI_RESET);
        }
    }

}
