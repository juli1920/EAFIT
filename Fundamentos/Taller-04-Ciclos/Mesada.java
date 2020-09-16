import java.util.Scanner;

public class Mesada {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String b = in.next();
        while(true){
            int n = in.nextInt();
            if (n>500){
                System.out.println(b+" eres mi angel");
                break;
            }
            else{
                System.out.println(b+" me decepcionas");
            }
        }
    }
}