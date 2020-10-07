public class Pacman extends Caracter {
    private int puntosVida;

    public Pacman(int tipo, Posicion posicion, char representacion, int puntosVida) {
        super(tipo, posicion, representacion);
        this.puntosVida = puntosVida;
        
    }
}
