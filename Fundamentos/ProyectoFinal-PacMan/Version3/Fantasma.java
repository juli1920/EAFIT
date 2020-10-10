public class Fantasma extends Caracter{
    boolean loVeo;
    int[][] movimientos ={
            {1,0}, //0 abajo
            {0,1}, //1 derecha
            {0,-1},//2 izquierda
            {-1,0} //3 arriba
    };

    int[][] movimientos2 ={
            {2,0}, //0 abajo
            {0,2}, //1 derecha
            {0,-2},//2 izquierda
            {-2,0} //3 arriba
    };

    public Fantasma(int tipo, Posicion posicion, boolean loVeo) {
        super(tipo, posicion, 'W');
        this.loVeo = loVeo;
    }
}
