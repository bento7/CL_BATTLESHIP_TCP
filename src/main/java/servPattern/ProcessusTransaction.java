package servPattern;
import launchPattern.UnContexte;
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
/**
 * Processus de Transaction (anciennement ServeurSpecifique)
 */
class ProcessusTransaction extends Thread {

	private Socket clientSocket;
	private ServeurTCP monServeurTCP;
	private IProtocole protocoleEchange;
	private UnContexte contexte;

	public  ProcessusTransaction(Socket uneSocket, ServeurTCP unServeur) {        
		super("ServeurThread");
		clientSocket = uneSocket;
		System.out.println("[ProcessusTransaction] CLIENT : " + clientSocket);
		monServeurTCP = unServeur;
	}

	@Override
	public void run() {
		String inputReq;

		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintStream os = new PrintStream(clientSocket.getOutputStream());
			System.out.println("Serveur avec  Client ");
			System.out.println(clientSocket);

			if ((inputReq = is.readLine()) != null) {
				System.out.println(" Msg 2 Recu " + inputReq);
				String chaines[] = inputReq.split(" ");
				System.out.println(" Ordre Recu " + chaines[0]);
				try {
					contexte = new UnContexte(chaines, monServeurTCP, os);
					setProtocoleEchange(contexte.getProtocole(clientSocket.getInetAddress().toString()));
					protocoleEchange.run();
				}catch (IOException e){
					os.println("Erreur de protocole..... \n");
				}
			}
			clientSocket.close();
			os.close();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IProtocole getProtocoleEchange() {
		return protocoleEchange;
	}

	public void setProtocoleEchange(IProtocole protocoleEchange) {
		this.protocoleEchange = protocoleEchange;
	}


}
