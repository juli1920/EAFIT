public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        String path = "laberinto.txt";
        Juego play = new Juego(path);
        play.jugar();

    }
}
