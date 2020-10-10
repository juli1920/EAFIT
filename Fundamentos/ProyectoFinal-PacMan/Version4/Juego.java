import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Juego {
    Scanner inputfile;

    public Juego(String path){
        System.out.println("Archivo "+path+" cargado");
        this.inputfile = null;

        try {
            inputfile = new Scanner(new File(path));
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }


    }

    public void jugar() throws InterruptedException {
        // ----- variables -------
        Scanner in = new Scanner(System.in);
        assert inputfile != null;
        Tablero tablero = new Tablero(inputfile);
        Pacman pacman = null;
        int turno = 1;
        boolean gano = false;
        boolean salir = false;
        // ----- variables -------

        // ----- Procesamiento de los datos inciales -------
        String s = inputfile.nextLine();

        //Procesamiento de PacMan
        if(s.charAt(0) == 'P') {
            int x = Integer.parseInt(String.valueOf(s.charAt(2)));
            int y = Integer.parseInt(String.valueOf(s.charAt(4)));
            pacman = new Pacman(1, new Posicion(x, y), 0);
            tablero.setCelda(pacman.posicion.getX(), pacman.posicion.getY(), pacman);
        }


        //Creacion del BFS
        assert pacman != null;
        new BFS(tablero.numFilas, tablero.numCols, tablero);
        Stack<Posicion> mov =  BFS.bfs(tablero, pacman.posicion);
        BFS.imprimirPadre();
        BFS.imprimirDistancias();
        Stack<Posicion> moverse = BFS.pintarCamino(tablero, mov);

        //Primer turno
        for(int hh = 0; hh<30; hh++){
            System.out.println();
        }
        tablero.dibujarTablero(tablero, true);

        // ----- Procesamiento de los datos inciales -------


        // ----- Inicio del juego -------


        while(!salir){
            for(int hh = 0; hh<30; hh++){
                System.out.println();
            }

            System.out.println();
            turno++;

            Posicion siguiente = moverse.pop();

            int nX = siguiente.getX();
            int nY = siguiente.getY();



            Celda next = tablero.getCelda(nX, nY);


            if(next.letra == 'O'){
                tablero.setCelda(pacman.posicion.getX(), pacman.posicion.getY(), ' ');
                tablero.setCelda(nX, nY, pacman);
                pacman.posicion.setX(nX);
                pacman.posicion.setY(nY);

                salir = true;
                gano = true;
            }

            tablero.setCelda(pacman.posicion.getX(), pacman.posicion.getY(), ' ');
            tablero.setCelda(pacman.posicion.getX(), pacman.posicion.getY(), (String) null);
            tablero.setCelda(nX, nY, pacman);
            pacman.posicion.setX(nX);
            pacman.posicion.setY(nY);

            int time = 750;

            if(gano){
                tablero.dibujarTablero(true);
            }
            else{
                tablero.dibujarTablero(tablero, true);
            }

            TimeUnit.MILLISECONDS.sleep(time);


            System.out.println();

            if(gano){
                System.out.println(Colors.ANSI_PURPLE+Colors.ANSI_BOLD+"Ganaste "+Colors.ANSI_RESET+Colors.ANSI_GREEN+Colors.ANSI_BOLD+"el"+Colors.ANSI_RESET+Colors.ANSI_CYAN+Colors.ANSI_BOLD+" juego!"+Colors.ANSI_RESET);
            }
        }


        System.out.println(Colors.ANSI_CYAN_BACKGROUND+Colors.ANSI_BLACK+"  Fin del juego  "+Colors.ANSI_RESET);
    }
}

//TODO COLOR A PERDER, GANAR, PERDER TURNO
class Colors{
    //Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //Backgrounds
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    //Textures
    public static final String ANSI_BOLD = "\u001b[1m";
}