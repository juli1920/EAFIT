
import java.util.Scanner;

public class WithoutString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next(), b = in.next();
        in.close();

        for(int i = 0; i<=s.length()-b.length(); i++){
            if(s.substring(i, i+b.length()).equals(b)){
                s = s.substring(0, i)+ s.substring(i+b.length());
                i--;
            }
        }

        System.out.println(s);
    }
}
