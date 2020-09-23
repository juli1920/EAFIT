class Planeta{
    private String nombre;
    private double masa;
    int contador = 0;

    public Planeta(){
        this.nombre = "Tierra";
        this.masa = 5.972;
    }

    public Planeta(String nombre, double masa){
        this.nombre = nombre;
        this.masa = masa;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public Planeta planetaMedio(Planeta p){
        return new Planeta(p.nombre, p.masa/2);
    }
}