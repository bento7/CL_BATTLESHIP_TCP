package launchPattern;
import game.IBattleship;
import servPattern.ServeurTCP;

import java.io.PrintStream;

import servPattern.IProtocole;


public class ProtocolePingPong implements IProtocole {

    public String addr;
    public ServeurTCP monServeur;
    public PrintStream os;

    public ProtocolePingPong(String addr, ServeurTCP monServeur, PrintStream os) {
        this.monServeur = monServeur;
        this.os = os;
        this.addr = addr;
    }

    @Override
    public void run(){

        ((IBattleship) monServeur.getContexte()).generateBattle("1");
        System.out.println(this.addr);
        ((IBattleship) monServeur.getContexte()).generateBattle("2");
        String id = ((IBattleship) monServeur.getContexte()).players();

//        String battle = ((IBattleship) monServeur.getContexte()).print();
//        System.out.println(" Depot dans serveur \n" + id);

        os.println(id);
//        os.println(battle);
        boolean shooted = ((IBattleship) monServeur.getContexte()).shoot(3,3,"1");
        String battle = ((IBattleship) monServeur.getContexte()).print("2");

        os.println(battle);
//        System.out.println(monServeur);
    }
}
