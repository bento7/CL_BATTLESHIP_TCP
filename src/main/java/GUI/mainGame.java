package GUI;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * @author Minh Phan minh.phan@sjsu.edu
 * CS 151 HW4 Fall 2017
 */

public class mainGame {

    private mainGame() {

    }

    public static void main(String[] args) {
        mainGame game = new mainGame();
        game.scenario1();
        theWindow tw = new theWindow();
        tw.initGUI();

    }

    public void scenario1(){
        System.out.println("scenario 1");

        // Création des joueurs

    }
}