public class Discoteca{
    public boolean accesoDiscoteca(int edad, int dinero, String nombre){
        return (edad>=18 && dinero>=100 && !nombre.equals("jimmy"));
    }
}