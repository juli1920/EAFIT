package Point;

public class Point{
    private double x;
    private double y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double distance(Point p2){
        return Math.sqrt(Math.pow(this.x-p2.getX(), 2) + Math.pow(this.y-p2.getY(), 2));
    }
}