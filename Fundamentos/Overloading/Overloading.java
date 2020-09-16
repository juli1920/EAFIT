package Overloading;

public class Overloading {
    void mostrar(int i){
        System.out.println("Se ha ingresado un int");
    }

    public void mostrar(double i){
        System.out.println("Se ha ingresado un double");
    }

    public static void mostrar(String i){
        System.out.println("Se ha ingresado un String");
    }

    public static void mostrar(char i){
        System.out.println("Se ha ingresado un char");
    }
}
