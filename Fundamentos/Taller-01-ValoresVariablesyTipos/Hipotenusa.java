import java.util.Scanner;

public class Hipotenusa{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double cateto = in.nextDouble();
        double cat2 = in.nextDouble();
        double hip = Math.sqrt(Math.pow(cateto,2)+Math.pow(cat2,2));
        System.out.println(String.format("%.2f", hip));
        in.close();
    }
}