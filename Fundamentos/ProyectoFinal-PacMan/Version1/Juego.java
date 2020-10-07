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
        int vida;
        Pacman pacman = null;
        assert inputfile != null;
        Tablero tablero = new Tablero(inputfile);
        // ----- variables -------

        // ----- Procesamiento de los datos inciales -------
        String s = inputfile.nextLine();

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

            int x = s.charAt(2);
            int y = s.charAt(4);
            pacman = new Pacman(1, new Posicion(x, y), vida);
            tablero.setCelda(pacman.posicion.getX(), pacman.posicion.getY(), pacman);
        }

        tablero.dibujarTablero();
        // ----- Procesamiento de los datos inciales -------

        // ----- Inicio del juego -------
        boolean salir = false;
        while(salir){
            char movimiento;

            while (true) {
                try {
                    System.out.print("A donde te quieres mover? (N - arriba, S - abajo, E - derecha, W - izquierda): ");
                    movimiento = opciones.next().charAt(0);
                    while (true){
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

            movimiento = Character.toLowerCase(movimiento);
            switch (movimiento){
                case 'n':
                    if(tablero.getCelda(pacman.posicion.getX(), (pacman.posicion.getY())+1).car == '*'){
                        System.out.println("La celda es un muro, perdiste tu turno");
                    }
                    break;
                case 's':

                    break;
                case 'e':

                    break;
                case 'w':

                    break;
            }


            tablero.dibujarTablero();
        }
    }
}
