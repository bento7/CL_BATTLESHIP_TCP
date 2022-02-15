package game;


public class Boat {
    boolean direction = true;// if true boat vertical
    final int size;
    boolean active;
    private int x_start, y_start;

    public Boat(int size, int x, int y){
        this.size = size;
        this.x_start = x;
        this.y_start = y;
    }

    public int getx() {
        return this.x_start;
    }
    public int gety() {
        return this.y_start;
    }

//    public void coord() {
//
//    }

}
