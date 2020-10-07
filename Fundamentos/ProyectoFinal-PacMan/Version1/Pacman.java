public class Pacman extends Caracter {
    private int puntosVida;

    public Pacman(int tipo, Posicion posicion, int puntosVida) {
        super(tipo, posicion, '^');
        this.puntosVida = puntosVida;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
}
