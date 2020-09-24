
import java.util.Scanner;


public class DeFront {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        s = s.toLowerCase();
        in.close();

        if(s.charAt(1) != 'b') s = s.substring(0,1) + s.substring(2);
        if(s.charAt(0) != 'a') s = s.substring(1);

        System.out.println(s);
    }
    
}
