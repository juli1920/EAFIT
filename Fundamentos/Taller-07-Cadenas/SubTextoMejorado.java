
import java.util.Scanner;

public class SubTextoMejorado {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int a = in.nextInt(), b = in.nextInt();
        in.close();

        xd(s, a, b);
    }

    public static void xd(String s, int a, int b){
        if(b > s.length()-1){
            System.out.println("Error");
            return;
        }

        if(a > b){
            System.out.println("Error2");
            return;
        }

        System.out.println(s.substring(a,b+1));
    }
}