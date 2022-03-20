package game;


public interface IBattleship {

    public boolean shoot(int x, int y, String id);

    public String print(String id);

    void generateBattle(String player);

    public String players();

}
