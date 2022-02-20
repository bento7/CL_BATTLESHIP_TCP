package launchPattern;
import java.io.IOException;
import java.io.PrintStream;
import static java.lang.Integer.parseInt;
import game.Board;
import servPattern.IContext;
import servPattern.ServeurTCP;
import servPattern.IProtocole;

public class UnContexte implements IContext {
    public String[] chaine;
    public ServeurTCP monServeur;
    public PrintStream os;

    public UnContexte(String[] chaine, ServeurTCP monServeur, PrintStream os) {
        this.chaine = chaine;
        this.monServeur = monServeur;
        this.os = os;
    }



    public IProtocole getProtocole(String addr) throws IOException {
        String comType = chaine[0];
        String value = "";
        if(chaine.length > 1){
            value = chaine[1];
        }
        switch (comType){
            case "Initialiser":
                return new ProtocolePingPong(addr, monServeur, os);

            default:
                os.println("Erreur de protocole..... \n");
                throw new IOException("Protocole Inexistant");
        }
    }
}
