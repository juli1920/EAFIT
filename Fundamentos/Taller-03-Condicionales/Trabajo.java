import java.util.Scanner;

public class Trabajo{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int dia = in.nextInt();
        double salario = in.nextDouble();
        switch(dia){
            case 1:
                salario *= 1.455;
                break;
            case 4:
                salario *= 1.1;
                break;
            case 5:
                salario *= 1.295;
                break;
            case 6:
            case 7:
                salario *= 1.75;
        }
        System.out.println(String.format("%.2f", salario));
    }
}