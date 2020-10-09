public class InvertirArreglo {
    public static int[] invertir(int a[]){
        for(int x = 0; x<a.length/2; x++){
            int temp = a[x];
            a[x] = a[a.length-1-x];
            a[a.length-1-x] = temp;
        }

        return a;
    }

    public static void imprimir(int a[]){
        for(int x = 0; x<a.length-1; x++){
            System.out.print(a[x]+",");
        }
        System.out.println(a[a.length-1]);
    }
}
