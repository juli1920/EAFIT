public class Celda {
    protected boolean esMuro;
    protected boolean esSalida;
    protected Caracter car;

    public Celda(boolean esMuro, boolean esSalida, Caracter car){
        this.esMuro = esMuro;
        this.esSalida = esSalida;
        this.car = car;
    }

    public char caracterCelda(){
        return car.representacion;
    }
}
