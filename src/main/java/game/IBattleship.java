package game;

public interface IBattleship {
    public boolean shoot(int x, int y);

    public String print();

    void generateBattle(String player);

    public String players();

}
