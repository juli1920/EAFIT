public class SubArregloImpar {
    public static int[] subArreglo(int[] a){
        int b[];
        int pares = 0;
        
        for(int z: a){
            if(z%2!=0){
                pares++;
            }
        }

        b = new int[pares];

        int i = 0;
        for(int z : a){
            if(z%2!=0){
                b[i] = z;
                i++;
            }
        }

        return b;
        
    }

    public static void imprimir(int[] a){
        for(int i = 0; i<a.length-1; i++){
            System.out.println(a[i]+",");
        }
        
        System.out.println(a[a.length-1]);
    }
}
