import java.util.Scanner;

public class SumaPares {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int total =0;
        for (int i = 0; i<n; i++){
            int x = in.nextInt();
            if(x%2==0){
                total += x;
            }
        }

        System.out.println(total);
    }
}
