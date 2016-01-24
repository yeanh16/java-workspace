import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
    private Total total = null;
    private Socket socket = null;

    public ServerThread(Total total, Socket socket) {
	super("ServerThread");
	this.total = total;
	this.socket = socket;
    }

    public void run() {
	DataOutputStream toClient;
	DataInputStream  fromClient;

	try {
	    toClient = new DataOutputStream(socket.getOutputStream());
	    fromClient  = new DataInputStream(socket.getInputStream());

	    int i;

	    while ((i = fromClient.readInt()) != 0) {
                total.add(i);
		System.out.println("Got " + i + " from client");
                System.out.println("Sent " + total.get() + " to client");
		toClient.writeInt(total.get());
	    }

	    toClient.close();
	    fromClient.close();
	    socket.close();
	} 
	catch (IOException e) {
	    System.exit(1);
	}
    }
}
