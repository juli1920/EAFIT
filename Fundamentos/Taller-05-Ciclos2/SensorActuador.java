public class SensorActuador{
    private int temperatura;
    private int minTemp;
    private int maxTemp;
    
    public SensorActuador(int temp, int min, int max){
        this.temperatura = temp;
        this.minTemp = min;
        this.maxTemp = max;
    }
    
    public int getTemperatura() {
        return this.temperatura;
    }
    
    public void disminuirTemp(int i){
        if(temperatura-i>=minTemp){
            this.temperatura = temperatura-i;
        }
    }
    
    public void aumentarTemp(int i){
        if(temperatura+i<=maxTemp){
            this.temperatura = temperatura+i;
        }
    }
}