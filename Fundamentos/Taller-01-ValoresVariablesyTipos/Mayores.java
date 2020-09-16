import java.util.Scanner;

public class Mayores{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
         int nom = in.nextInt();
        
        System.out.println((num+nom)+"\n"+(num*nom));
        in.close();
    }
}