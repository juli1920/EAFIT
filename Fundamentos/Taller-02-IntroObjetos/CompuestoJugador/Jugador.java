public class Jugador{
    private String nombre;
    private int salud;
    
    public int getSalud(){return this.salud;}
    
    public String getNombre(){return this.nombre;}
    
    public void setSalud(int salud){this.salud = salud;}
    
    public void setNombre(String nombre){this.nombre = nombre;}
    
    public void reducirSalud(int s){
        this.salud -= s;
    }
 }