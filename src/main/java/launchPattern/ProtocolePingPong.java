package launchPattern;
import game.Board;
import game.IBattleship;
import game.IBoard;
import servPattern.ServeurTCP;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import servPattern.IContext;
import servPattern.IProtocole;


public class ProtocolePingPong implements IProtocole {

    public int valeurDemandee;
    public ServeurTCP monServeur;
    public PrintStream os;

    public ProtocolePingPong(int valeurDemandee, ServeurTCP monServeur, PrintStream os) {
        this.valeurDemandee = valeurDemandee;
        this.monServeur = monServeur;
        this.os = os;
    }

    @Override
    public void run(){

        String battle = ((IBattleship) monServeur.getContexte()).print();

        System.out.println(" Depot dans serveur \n" + battle);
        os.println(battle);
        System.out.println(monServeur);
    }
}
