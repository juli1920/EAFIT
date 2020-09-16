import java.util.Scanner;

public class ControlAmbiente{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        SensorActuador sa1 = new SensorActuador(5,1,10);
        for(int i = 0; i<4; i++){
            int n = in.nextInt();
            if(i<2){
                sa1.disminuirTemp(n);
            }
            else{
                sa1.aumentarTemp(n);
            }
        }
        System.out.println(sa1.getTemperatura());
    }
    
}