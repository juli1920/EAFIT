
public class Caracter{
    protected int tipo;
    protected Posicion posicion;
    protected char representacion;

    public Caracter(int tipo, Posicion posicion, char representacion){
        this.tipo = tipo;
        this.posicion = posicion;
        this.representacion = representacion;
    }

}

class Posicion{
    private int x;
    private int y;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }
}


