
import java.util.Scanner;

public class SubTexto {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int a = in.nextInt(), b = in.nextInt();
        in.close();

        System.out.println(s.substring(a,b+1));
    }
}
