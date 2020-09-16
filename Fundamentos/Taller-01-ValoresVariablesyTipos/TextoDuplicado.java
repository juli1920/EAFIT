import java.util.Scanner;

public class TextoDuplicado{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        String palabra = entrada.next();
        System.out.println(palabra+palabra);
        entrada.close();
    }
}