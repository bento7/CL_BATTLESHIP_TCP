package GUI;

public class Player {
    final public String namePlayer;
    public SelfGrid gridPlayer;

    public Player (String name){
        this.namePlayer = name;
        this.gridPlayer = new SelfGrid(this.namePlayer);
    }
}
