package ClientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//création de socket
		Socket o;
		try {
			
			System.out.println("je suis un client pas encore connecte");
			o = new Socket("localhost",72);
			System.out.println("je suis un client connecte");
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
