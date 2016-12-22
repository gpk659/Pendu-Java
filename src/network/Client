package network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Client {

	public void Client()throws IOException {
		String serverAddress = JOptionPane.showInputDialog("Adresse du Serveur SVP: ");
		Socket socket = new Socket(serverAddress, 8080);
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.writeObject("Coucou, voici un message du client !");
		socket.close();
		System.exit(0);
	}
}
