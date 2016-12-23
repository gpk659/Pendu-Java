package network;

/**
 * @author Gr�gory Pyck, Simon Barr�, Amine Nafia 2TL1 G4
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public Server() throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("Le serveur est dÃ©marrÃ© sur le port 8080 !");
		//server.setSoTimeout(15000);
		Socket socket = server.accept();
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		try {
			System.out.println(input.readObject());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		socket.close();
		server.close();
		System.exit(0);
		}

	/*public void acceptePlusieursClients(){
	Thread t = new Thread(this);
	t.start();
	}*/
	
}
