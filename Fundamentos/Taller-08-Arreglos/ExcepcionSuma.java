public class ExcepcionSuma {
    public static int suma(int[] a){
        boolean six = false;
        int sum = 0;

        for(int x : a){
            if(!six && x != 6){
                sum += x;
            }
            else{
                if(x == 6){
                    six = true;
                }
                else if (x == 7){
                    six = false;
                }
            }
        }

        return sum;
    }
}
