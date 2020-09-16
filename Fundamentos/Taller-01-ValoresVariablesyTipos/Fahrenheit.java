import java.util.Scanner;

public class Fahrenheit{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        double n = (((double)num*9)/5)+32;

        System.out.println(String.format("%.2f", n));
        in.close();
    }
}