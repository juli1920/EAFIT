import java.util.Arrays;

public class DiferenciaMayorMenor {
    public static int diferencia(int[]  a){
        Arrays.sort(a); 
        return a[a.length-1]-a[0];
    }
}
