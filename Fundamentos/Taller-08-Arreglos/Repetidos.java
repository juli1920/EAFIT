import java.util.ArrayList;


public class Repetidos {
    public static int detectorDeRepetidos(ArrayList<Integer> a){
        int num = a.get(0), repeated = 0;
        boolean ready = true;

        for(int i = 1; i<a.size(); i++){
            if(a.get(i) == num && ready){
                repeated++;
                ready = false;
            }
            else if(a.get(i) != num){
                num = a.get(i);
                ready = true;
            }

        }
        
        return repeated;
    }
}
