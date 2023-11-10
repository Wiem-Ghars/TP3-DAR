package ClientProcessPackage;

import java.io.IOException;
import java.net.Socket;

public class ClientProcess extends Thread {
	 private Socket so;
	    private int clientOrder;
	    
	    public ClientProcess(Socket socket, int order) {
	        this.so = socket;
	        this.clientOrder = order;
	    }
	    //Client affectue son traitement
	    public void run()
	    {
	    	System.out.println("Le client numéro "+ clientOrder + " est connecté !");
           //fermeture de la socket
            try {
				so.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
	    }
}
