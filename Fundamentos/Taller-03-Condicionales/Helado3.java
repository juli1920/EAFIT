import java.util.Scanner;

public class Helado3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        int edad = in.nextInt();
        
        
        
        if(temp>27 && edad>=18){
            int dinero = in.nextInt();
            if (dinero >5000){
                System.out.println("Comprar helado cerveza");
            }
            else {
                System.out.println("De que me hablas viejo");
            }
            
        }
        else {
            System.out.println("Lo sentimos juventud");
        }
    }
}