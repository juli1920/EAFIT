public class Arepita extends Caracter{
    protected boolean esExplosiva;

    public Arepita(int tipo, Posicion posicion, boolean esExplosiva) {
        super(tipo, posicion, '@');
        this.esExplosiva = esExplosiva;
    }
}
