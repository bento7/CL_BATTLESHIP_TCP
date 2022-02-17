package game;
import launchPattern.UnContexte;
import servPattern.IContext;
import servPattern.ServeurTCP;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Battleship extends ArrayList<Board> implements IBattleship, IContext{
    final int nbplayers;


    public Battleship(int nbplayers) {
        if (nbplayers <= 0)
            throw new InvalidParameterException("C'est quoi ça un nb de joueurs négatif ou nul?");
        this.nbplayers = nbplayers;

        generateBattle();
    }

    private Board board;
//    private IContext context;


    public void generateBattle() {
        board = new Board(10);
        this.add(board);
    }


    public String print() {
        return board.print();
    }

    public void openBattleship() {
        ServeurTCP myServ = new ServeurTCP(this,6666 );
        myServ.start();
    }
}
