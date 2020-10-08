import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void jugar(){
        // ----- variables -------
        Scanner in = new Scanner(System.in), opciones = new Scanner(System.in);
        int vida = 0;
        Pacman pacman = null;
        assert inputfile != null;
        Tablero tablero = new Tablero(inputfile);
        int turno = 1;
        int vidaPerdida;
        boolean gano = false;
        // ----- variables -------

        // ----- Procesamiento de los datos inciales -------
        String s = inputfile.nextLine();

        //Procesamiento de PacMan
        if(s.charAt(0) == 'P') {
            while (true) {
                try {
                    System.out.println("Cuanta vida tiene pacman? ");
                    vida = in.nextInt();
                    break;
                } catch (InputMismatchException ignored) {
                    System.out.println("Escriba un numero entero");
                }
            }

            int x = Integer.parseInt(String.valueOf(s.charAt(2)));
            int y = Integer.parseInt(String.valueOf(s.charAt(4)));
            pacman = new Pacman(1, new Posicion(x, y), vida);
            tablero.setCelda(pacman.posicion.getX(), pacman.posicion.getY(), pacman);
        }

        while (true) {
            try {
                System.out.println("Cuanta vida perderá pacman cada 10 turnos? ");
                vidaPerdida = in.nextInt();
                break;
            } catch (InputMismatchException ignored) {
                System.out.println("Escriba un numero entero");
            }
        }

        tablero.dibujarTablero();
        System.out.println("Turno: 1");
        System.out.println("Vida: "+ pacman.getPuntosVida());
        // ----- Procesamiento de los datos inciales -------

        // ----- Inicio del juego -------
        boolean salir = false;
        while(!salir){
            System.out.println();
            turno++;

            char movimiento;

            while (true) {
                try {
                    while (true){
                        System.out.print("A donde te quieres mover? (N - arriba, S - abajo, E - derecha, W - izquierda): ");
                        movimiento = opciones.next().charAt(0);
                        movimiento = Character.toUpperCase(movimiento);
                        if(movimiento != 'N' && movimiento != 'S' && movimiento != 'E' && movimiento != 'W'){
                            System.out.println("\n Ingresa una de las opciones!");
                        }
                        else {
                            break;
                        }
                    }
                    break;
                } catch (InputMismatchException ignored) {
                    System.out.println("Escriba un caracter");
                }
            }

            System.out.println();
            movimiento = Character.toLowerCase(movimiento);

            //--- variables ---
            Celda next;
            int nX = pacman.posicion.getX();
            int nY = pacman.posicion.getY();
            //--- variables ---

            switch (movimiento){
                case 'n':
                    nX -= 1;
                    break;
                case 's':
                    nX += 1;
                    break;
                case 'e':
                    nY += 1;
                    break;
                case 'w':
                    nY -= 1;
                    break;
                default:
            }

            next = tablero.getCelda(nX, nY);

            if(next.letra == '*'){
                System.out.println(Colors.ANSI_CYAN+"La celda es un muro, perdiste tu turno"+ Colors.ANSI_RESET);
            }
            else if(next.letra == ' ' || next.letra == 'O' || next.letra == '@'){
                tablero.setCelda(pacman.posicion.getX(), pacman.posicion.getY(), ' ');

                if(next.letra == 'O'){
                    salir = true;
                    gano = true;
                }
                else if(next.letra == '@'){
                   Arepita ar = (Arepita) next.getPersonaje();

                   vida += ar.explosiva ? -5 : 1;

                   pacman.setPuntosVida(vida);
                }

                tablero.setCelda(nX, nY, pacman);
                pacman.posicion.setX(nX);
                pacman.posicion.setY(nY);
            }

            if(turno%10==0){
                vida -= vidaPerdida;
                pacman.setPuntosVida(vida);
            }


            if(gano){
                tablero.dibujarTablero(true);
            }
            else if(vida <= 0){
                tablero.dibujarTablero(false);
            }
            else{
                tablero.dibujarTablero();
            }

            System.out.println("Turno: "+turno);


            System.out.println("Vida: "+ pacman.getPuntosVida());
            System.out.println();

            if(gano){
                System.out.println(Colors.ANSI_PURPLE+Colors.ANSI_BOLD+"Ganaste "+Colors.ANSI_RESET+Colors.ANSI_GREEN+Colors.ANSI_BOLD+"el"+Colors.ANSI_RESET+Colors.ANSI_CYAN+Colors.ANSI_BOLD+" juego!"+Colors.ANSI_RESET);
            }


            if(vida <= 0 && !gano){
                System.out.println(Colors.ANSI_RED_BACKGROUND + Colors.ANSI_BLACK+Colors.ANSI_BOLD+"Perdiste! Vida agotada"+Colors.ANSI_RESET);
                break;
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