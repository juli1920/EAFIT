import java.util.Scanner;

public class Asteroides{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String nom = in.next();
        
        System.out.println("Los "+num+" asteroides "+nom+" caen del cielo");
        in.close();
    }
}