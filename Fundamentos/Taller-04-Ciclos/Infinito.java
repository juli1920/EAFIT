import java.util.Scanner;

public class Infinito {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            if (n==0){
                break;
            }
            else{
                System.out.println(n*3);
            }
        }
    }
}