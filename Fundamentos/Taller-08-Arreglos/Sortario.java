public class Sortario {
    public static boolean detectorDeMalaSuerte(int[] a){
        boolean b1 = false, b3 = false, b13 = false;

        for(int x : a){
            if(x == 1) b1 = true;
            else if(x == 3) b3 = true;
            else if (x == 13) b13 = true;

            if(b1 && b3 || b13) break;
        }

        return ((b1 && b3) || b13);
    }
}
