package launchPattern;

import game.IBattleship;
import servPattern.IProtocole;
import servPattern.ServeurTCP;

import java.io.PrintStream;

public class ProtocoleShoot implements IProtocole {
    public String addr;
    public ServeurTCP monServeur;
    public PrintStream os;

    public ProtocoleShoot(String addr, ServeurTCP monServeur, PrintStream os) {
        this.monServeur = monServeur;
        this.os = os;
        this.addr = addr;
    }

    @Override
    public void run(){

        ((IBattleship) monServeur.getContexte()).generateBattle("1");
        ((IBattleship) monServeur.getContexte()).generateBattle("2");

        System.out.println(this.addr);
        String id = ((IBattleship) monServeur.getContexte()).players();

//        String battle = ((IBattleship) monServeur.getContexte()).print();
//        System.out.println(" Depot dans serveur \n" + id);

        os.println(id);
//        os.println(battle);
        boolean shooted = ((IBattleship) monServeur.getContexte()).shoot(3,3,"1");
        String battle = ((IBattleship) monServeur.getContexte()).print("1");
        String board = ((IBattleship) monServeur.getContexte()).print("2");
        os.println(battle);
        os.println(board);
//        System.out.println(monServeur);
    }
}

