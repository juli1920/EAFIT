import java.util.Scanner;

public class ContIncrDecr {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String unkDouble = scan.next();
        unkDouble = unkDouble.replace(",", ".");
        double y = Double.parseDouble(unkDouble);
        double n = 0.0;
        int i = 0;
        while(y != 0){
            if (y >= n && y != 0){
                n = y;
                i++;
                System.out.println("+1");
            }
            else if (y != 0){
                n = y;
                i--;
                System.out.println("-1");
            }
            
        unkDouble = scan.next();
        unkDouble = unkDouble.replace(",", ".");
        y = Double.parseDouble(unkDouble);
        }
        System.out.println("Contador: "+i);
    }
}