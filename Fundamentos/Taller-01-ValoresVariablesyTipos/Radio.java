
import java.util.Scanner;

public class Radio {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        num *= num * Math.PI;
        String area = String.format("%.2f", num);

        System.out.println(area);
        in.close();
    }
}
