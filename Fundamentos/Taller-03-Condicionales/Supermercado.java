import java.util.Scanner;

public class Supermercado{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int s = in.nextInt();
        
        int total = 0;
        
        if (t == 1){total = 5*s;}
        else if (t == 2){total = 10*s;}
        else {total = 15*s;}
        
        System.out.println(total);
    }
}