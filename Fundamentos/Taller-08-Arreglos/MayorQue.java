
public class MayorQue {

    public static void mayor(int[] a){
        boolean print = false;
        
        for(int x : a){
            if(x > a[0]){
                print = true;
                System.out.println(x);
            }
        }

        if(!print) System.out.println("No hay ningun numero mayor que el primero");
        
    
    }
}
