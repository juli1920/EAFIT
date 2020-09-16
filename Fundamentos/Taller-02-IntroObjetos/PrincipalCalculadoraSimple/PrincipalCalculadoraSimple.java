import java.util.Scanner;

public class PrincipalCalculadoraSimple {
    
    public static void main(String[] args){
        CalculadoraSimple calc = new CalculadoraSimple();
        
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        
        System.out.println(calc.sumar(n1, n2));
        System.out.println(calc.restar(n1, n2));   
        in.close();
    }
    
    
}