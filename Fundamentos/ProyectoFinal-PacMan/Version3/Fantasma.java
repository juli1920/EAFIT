public class Fantasma extends Caracter{
    boolean loVeo;
    int[][] movimientos ={
            {1,0}, //0 derecha
            {0,1}, //1 abajo
            {0,-1},//2 arriba
            {-1,0} //3 izquierda
    };

    int[][] movimientos2 ={
            {2,0}, //0 derecha
            {0,2}, //1 abajo
            {0,-2},//2 arriba
            {-2,0} //3 izquierda
    };

    public Fantasma(int tipo, Posicion posicion, boolean loVeo) {
        super(tipo, posicion, 'W');
        this.loVeo = loVeo;
    }
}
