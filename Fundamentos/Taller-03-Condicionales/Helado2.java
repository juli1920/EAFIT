import java.util.Scanner;

public class Helado2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        int edad = in.nextInt();
        
        
        
        if(temp>27 && edad>=18){
            System.out.println("Comprar helado cerveza");
        }
        else {
            System.out.println("Lo sentimos juventud");
        }
    }
}