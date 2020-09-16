import java.util.Scanner;

public class Estrellas {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int i = 0;
        int n = in.nextInt();
        int[] stars = new int[6];
        stars[n]++;
        i++;
        while(n>=0){
            n = in.nextInt();
            if (n>=0){
                i++;
                stars[n]++;
            }
        }
        System.out.println("0("+stars[0]+") *("+stars[1]+") **("+stars[2]+") ***("+stars[3]+") ****("+stars[4]+") *****("+stars[5]+")");
        System.out.println("Total: "+i);
    }
}
