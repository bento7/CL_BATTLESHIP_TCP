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

//        boolean shooted = ((IBattleship) monServeur.getContexte()).shoot(3,3);
//        String battle = ((IBattleship) monServeur.getContexte()).print();
        ((IBattleship) monServeur.getContexte()).generateBattle(this.addr);
        System.out.println(this.addr);
//        ((IBattleship) monServeur.getContexte()).generateBattle("118712");
        String id = ((IBattleship) monServeur.getContexte()).players();
        System.out.println(" Depot dans serveur \n" + id);

        os.println(id);
        System.out.println(monServeur);
    }
}
