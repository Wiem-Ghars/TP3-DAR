package ClientProcessPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import OperationMT.Operation;

public class ClientProcess extends Thread {
	 private Socket so;
	    private int clientOrder;
	    
		private Operation oop;
	    public ClientProcess(Socket socket, int order,Operation oop) {
	        this.so = socket;
	        this.clientOrder = order;
	        this.oop=oop;
	    }
	    //Client affectue son traitement
	    public void run()
	    {
	    	
	    	System.out.println("Le client numéro "+ clientOrder + " est connecté !");
	    	// Utlisation du ObjectInputStream pour pouvoir lire l'objet 
	    				InputStream is;
						try {
							is = so.getInputStream();
							ObjectInputStream ois = new ObjectInputStream(is);
		    				
		    				// Conversion du type Object vers Operation
		    				Operation op =(Operation) ois.readObject();
		    				
		    				// Traitement
		    				int nb1 =op.getOp1();
		    				int nb2=op.getOp2();
		    				int resultat=0;
		    				switch(op.getOperation()) {
		    				case '+':
		    					resultat = nb1+nb2;
		    					break;
		    				case '-':
		    					resultat =  nb1-nb2;
		    					break;
		    				case '*':
		    					resultat =  nb1*nb2;
		    					break;
		    				case '/':
		    					resultat =  nb1/nb2;
		    					break;
		    				}
		    			
		    				op.setResultat(resultat);
		    				
		    				// Le renvoi du même objet vers le client après modification de la propriétés 'Resultat'
		    				OutputStream os = so.getOutputStream();
		    				ObjectOutputStream oos = new ObjectOutputStream(os);
		    				oos.writeObject(op);
		    				
		    				// Libération des ressources
		    				
		    				so.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    				
	    				
	    }
}
