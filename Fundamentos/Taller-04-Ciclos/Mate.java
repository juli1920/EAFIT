public class Mate {
    public int factorial(int num) {
        int fact = 1;
        for (int i = 0; i <num; i++) {
            fact *= num-i;
        }

        return fact;
    }

}  