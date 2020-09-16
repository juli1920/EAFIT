import java.util.Scanner;

public class Helado{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int temp = in.nextInt();
        
        if(temp>27){
            System.out.println("Comprar helado cerveza");
        }
        in.close();
    }
}
