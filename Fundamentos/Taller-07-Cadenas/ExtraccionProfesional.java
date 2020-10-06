
import java.util.Scanner;

public class ExtraccionProfesional {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();

        s = s.substring(18,s.length()-6);

        char x = s.charAt(0);
        int i = 0;
        while(x != '<'){
            i++;
            x = s.charAt(i);
        }

        s = s.substring(0,i)+s.substring(i+28);

        System.out.println(s);
    }
}