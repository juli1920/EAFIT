import java.util.Scanner;

public class Multiplos5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; (i*5)<=n; i++){
            System.out.println(i*5);
        }
    }
}