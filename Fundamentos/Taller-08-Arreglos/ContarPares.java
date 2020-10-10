public class ContarPares {
    public static void contar(int[] a){
        int pares = 0;
        
        for(int x: a){
            if(x%2==0){
                pares++;
            }
        }

        System.out.println(pares);
    }
}
