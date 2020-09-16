import java.util.Scanner;

public class PrincipalJugador{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Jugador p1 = new Jugador();
        
        int salud = in.nextInt();
        String nombre = in.next();
        
        p1.setNombre(nombre);
        p1.setSalud(salud);
        
        salud = in.nextInt();
        p1.reducirSalud(salud);
        
        salud = in.nextInt();
        p1.reducirSalud(salud);
        
        System.out.println(p1.getNombre()+p1.getSalud());
        
    }
}