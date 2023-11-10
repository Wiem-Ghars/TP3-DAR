package ServerPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ClientProcessPackage.ClientProcess;
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
			ServerSocket serverSocket =new ServerSocket(72);
			
			 int clientOrder = 1;
			 	//attendre la connection du plusieurs client
	            while (true) {
	            	Socket socket = serverSocket.accept();
	    			System.out.println("Client connecté");
	                System.out.println("Nouvelle connexion client : " + socket.getRemoteSocketAddress());
	                ClientProcess clientprocess = new ClientProcess(socket, clientOrder);
	                clientprocess.start();
	                 clientOrder++;
	                serverSocket.close();}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
