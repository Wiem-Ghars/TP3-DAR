package ServerPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ClientProcessPackage.ClientProcess;
import OperationMT.Operation;
public class ServerMT extends Thread {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		// création d’un thread
		 new ServerMT().start() ;
		}
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Je suis un serveur en attente la connexion d'un client");	
			ServerSocket serverSocket =new ServerSocket(74);
			
			 int clientOrder = 1;
			 	//attendre la connection du plusieurs client
	            while (true) {
	            	Socket socket = serverSocket.accept();
	    			System.out.println("Client connecté");
	                System.out.println("Nouvelle connexion client : " + socket.getRemoteSocketAddress());
	             // Créer le service de l'operation pour chaque client
	                Operation oper = new Operation();
	       
	                // Passer le service de l'operation à ClientProcess
	                ClientProcess clientprocess = new ClientProcess(socket, clientOrder, oper);
	                
	                clientprocess.start(); 
	                clientOrder++;
	                 
	                }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
