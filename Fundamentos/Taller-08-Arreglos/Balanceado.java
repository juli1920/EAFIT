
public class Balanceado {
    public static boolean balancear(int[] a){
        int m1 = 0, m2 = 0;

        for(int i = 0; i<((a.length-1)/2); i++){
            m1 += a[i];
            m2 += a[a.length-1-i];
        }

        return m1 == m2;
    }
}
