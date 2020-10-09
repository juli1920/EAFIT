import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Tablero {
    final int numFilas;
    final int numCols;
    private Celda[][] tablero;
    protected static int empties = 0;
    protected static Posicion meta;

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
                } else if (x == ' ' ) {
                    tablero[i][j] = new Celda(false, false, x);
                    empties++;
                } else if (x == 'O') {
                    tablero[i][j] = new Celda(false, true, 'O');
                    meta = new Posicion(i, j);
                    empties++;
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

    public void dibujarTablero(boolean gano){
        for(int i = 0; i<numFilas; i++){
            for (int j = 0; j<numCols; j++){
                char x = tablero[i][j].caracterCelda();

                if (x == '^'){
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
    }

    public static int getEmpties() {
        return empties;
    }

    public void setEmpties(int empties) {
        Tablero.empties = empties;
    }

    public static Posicion getMeta() {
        return meta;
    }

    public void setMeta(Posicion meta) {
        Tablero.meta = meta;
    }
}

class BFS {
    private static int[][] d;
    private static Posicion[][] padre;
    int size;
    static int[] xCambio = {1, 0, 0, -1};
    static int[] yCambio = {0, 1, -1, -0};

    public BFS(int n, int s){
        d = new int[n][s];
        padre = new Posicion[n][s];
    }

    public static void bfs(Tablero a, Posicion fuente){
        for (int i = 0; i < d.length; ++i){
            for(int j = 0; j<d[0].length; j++){
                d[i][j] = -1;
                padre[i][j] = null;
            }
        }

        Queue<Posicion> q = new LinkedList<>();
        q.add(new Posicion(fuente.getX(), fuente.getY()));
        d[fuente.getX()][fuente.getY()] = 0;
        padre[fuente.getX()][fuente.getY()] = new Posicion(0, 0);

        while(q.size() > 0){
            Posicion cur = q.element();
            q.remove();
            for(int i = 0; i<4; i++){
                int nX = cur.getX() + xCambio[i];
                int nY = cur.getY() + yCambio[i];
                char next = a.getCelda(nX, nY).letra;

                if(next == '*') continue;

                if(d[nX][nY] == -1){
                    d[nX][nY] = d[cur.getX()][cur.getY()]+1;
                    padre[nX][nY] = new Posicion(cur.getX(), cur.getY());
                    q.add(new Posicion(nX, nY));
                }
                else if (d[nX][nY] > d[cur.getX()][cur.getY()]+1){
                    d[nX][nY] = d[cur.getX()][cur.getY()]+1;
                    padre[nX][nY] = new Posicion(cur.getX(), cur.getY());
                    q.add(new Posicion(nX, nY));
                }
            }
        }




    }

    public static void imprimpirDistancias(){
        System.out.println("distancias");
        for (int[] ints : d) {
            for (int j = 0; j < d[0].length; j++) {
                String s;
                if(ints[j] == -1){
                    s = (Colors.ANSI_BLUE+ints[j]+Colors.ANSI_RESET);
                }
                else{
                    s = Colors.ANSI_BLACK + ints[j] + Colors.ANSI_RESET;
                }
                System.out.printf("%12s",s);

            }
            System.out.println();
        }
    }

    public static void imprimirPadre(){
        System.out.println("padre");
        for(int i = 0; i<d.length; i++){
            for(int j = 0; j<d[0].length; j++){
                String s;
                if(padre[i][j] == null){
                    s = ("[--]");
                }
                else if(padre[i][j].getX() == 0){
                    s = Colors.ANSI_BLUE+"   [" + padre[i][j].getX() + "," + padre[i][j].getY() + "]"+Colors.ANSI_RESET;
                }
                else{
                    s = "[" + padre[i][j].getX() + "," + padre[i][j].getY() + "]";
                }
                System.out.printf("%8s", s);

            }
            System.out.println();
        }
    }
}

