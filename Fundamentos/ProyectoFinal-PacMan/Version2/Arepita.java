public class Arepita extends Caracter{
    protected boolean explosiva;

    public Arepita(int tipo, Posicion posicion, boolean Explosiva) {
        super(tipo, posicion, '@');
        this.explosiva = Explosiva;
    }

    public boolean isExplosiva() {
        return explosiva;
    }

    public void setExplosiva(boolean explosiva) {
        this.explosiva = explosiva;
    }
}
