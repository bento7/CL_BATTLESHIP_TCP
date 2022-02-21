package game;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import launchPattern.UnContexte;
import servPattern.IContext;
import servPattern.ServeurTCP;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Battleship extends ArrayList<Board> implements IBattleship, IContext{
    /**
     * Classe regroupant les boards des joueurs
     */
    final int nbplayers;
//    List<Board> id = new ArrayList<Board>();

    public Battleship(int nbplayers) {
        if (nbplayers <= 0)
            throw new InvalidParameterException("C'est quoi ça un nb de joueurs négatif ou nul?");
        this.nbplayers = nbplayers;
    }

    private Board board;


    public void generateBattle(String player){
//        for (Board board: this) {
//            if (board.player == player){
//                throw new IllegalAccessException("Vous êtes déjà connecté");
//            }
//        }

        if (this.size() < this.nbplayers) {
            board = new Board(10, player);
            this.add(board);
        } // il faut faire connecter qu'une seule fois chaque joueur
        else {
            throw new InvalidParameterException("Trop de joueurs connectés");
        }

    }

    public String players() {
        String id = "";
        for (Board board: this){
            id += board.player;
        }
        return id;
    }

    public String print() {
        return board.print();
    }

    public boolean shoot(int x, int y) {
        return board.shooted(x, y);
    }

    public void openBattleship() {
        ServeurTCP myServ = new ServeurTCP(this,6666 );
        myServ.start();
    }
}
