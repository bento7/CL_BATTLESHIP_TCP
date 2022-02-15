package game;


public class Boat {
    boolean direction;
    final int size;
    boolean active;
    private int x_start, y_start;

    public Boat(int size){
        this.size = size;
    }
    public void setCoord(int x, int y){
        this.x_start = x;
        this.x_start = y;
    }
    public int getx() {
        return this.x_start;
    }
    public int gety() {
        return this.y_start;
    }



}
