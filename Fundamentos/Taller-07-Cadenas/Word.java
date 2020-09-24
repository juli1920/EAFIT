
import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String txt  = in.next();
        txt = txt.toLowerCase();

        System.out.println(txt.length());
        System.out.println(xd(txt));
        
        in.close();
    }

    public static int xd(String s){
        int i = 0;
        for(char x: s.toCharArray()){
            if(x == 'a'){
                System.out.println(i);
                return i;
            }
            i++;
        }
    
        return -1;
    }
}
