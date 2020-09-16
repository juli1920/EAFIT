import java.util.Scanner;

public class FriendZone{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String nom1 = in.next();
        String nom2 = in.next();
        
        System.out.println(nom1+" deja en la friend zone a "+nom2);
        in.close();
    }
}