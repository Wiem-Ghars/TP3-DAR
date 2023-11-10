package ClientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import OperationMT.Operation;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//création de socket
		Socket o;
		try {
			
			System.out.println("je suis un client pas encore connecte");
			o = new Socket("localhost",74);
			System.out.println("je suis un client connecte");
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Donner le premier operateur : ");
			int op1 = scanner.nextInt();
			
			System.out.print("\nDonner l'operation : ");
			String operation;
			// Verification de l'operation
			do {
				operation = scanner.nextLine();
			}while(!(operation.equals("*")) && !(operation.equals("+")) && !(operation.equals("-")) && !(operation.equals("/")));
	
			System.out.print("\nDonner le deuxieme operateur : ");
			int op2 = scanner.nextInt();
			
			scanner.close();
			
			
			// Création d'une instance de Operation à partir de la saisie de l'utilisateur
			Operation op = new Operation(op1, op2, operation.charAt(0));
			
			// Utilisation de ObjectOutputStream pour pouvoir convertir un objet (Serializable) à un fichier binaire
			// Puis l'envoyer au serveur
			OutputStream os = o.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(op);
			
			// Utlisation du ObjectInputStream pour pourvoir lire l'objet 
			InputStream is = o.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			try {
				op = (Operation) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("\n" + op.getOp1() + " " + op.getOperation()+ " " + op.getOp2() + " = " + op.getResultat());
			
			//fermeture de socket
			o.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
