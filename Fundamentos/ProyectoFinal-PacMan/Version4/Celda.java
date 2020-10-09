public class Celda {
    protected boolean esMuro;
    protected boolean esSalida;
    protected char letra;
    protected Caracter personaje;

    public Celda(boolean esMuro, boolean esSalida, char letra){
        this.esMuro = esMuro;
        this.esSalida = esSalida;
        this.letra = letra;
    }

    public char caracterCelda(){
        return letra;
    }

    public Caracter getPersonaje() {
        return personaje;
    }

    public void setCara(Caracter cara) {
        this.personaje = cara;
        letra = personaje.representacion;
    }
}
