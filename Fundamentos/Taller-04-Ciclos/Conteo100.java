import java.util.Scanner;

public class Conteo100 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int i = 0;
        while(true){
            int n = in.nextInt();
            if (n>100){
                i++;
            }
            else if (n==0){
                System.out.println(i);
                break;
            }
        }
    }
}