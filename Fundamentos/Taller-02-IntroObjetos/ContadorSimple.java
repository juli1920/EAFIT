
public class ContadorSimple{
    private int conteo = 1;
    
    public void aumentar(){
        this.conteo++;
    }
    
    public void disminuir(){
        this.conteo--;
    }
    
    public int getConteo(){
        return this.conteo;
    }
    
}