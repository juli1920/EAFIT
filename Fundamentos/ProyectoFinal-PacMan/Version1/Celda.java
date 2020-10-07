public class Celda {
    protected boolean esMuro;
    protected boolean esSalida;
    protected char car;
    protected Caracter per;

    public Celda(boolean esMuro, boolean esSalida, char car){
        this.esMuro = esMuro;
        this.esSalida = esSalida;
        this.car = car;
    }

    public char caracterCelda(){
        return car;
    }

    public Caracter getCara() {
        return per;
    }

    public void setCara(Caracter cara) {
        this.per = cara;
        car = per.representacion;
    }
}
