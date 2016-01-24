import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        Total total = new Total();

        // Open a server socket:
        try {
            serverSocket = new ServerSocket(4444);
        } 
	catch (IOException e) {
            System.err.println("Couldn't listen on port: 4444.");
            System.exit(-1);
        }

	// Listen to the socket, accepting connections from new clients,
	// and running a new thread to serve each new client:
	try {
		Socket clientSocket = serverSocket.accept();

		DataOutputStream toClient;
		DataInputStream  fromClient;

		try {
		    toClient = new DataOutputStream(clientSocket.getOutputStream());
		    fromClient  = new DataInputStream(clientSocket.getInputStream());

		    int i;

		    while ((i = fromClient.readInt()) != 0) {
			total.add(i);
			System.out.println("Got " + i + " from client");
			System.out.println("Sent " + total.get() + " to client");
			toClient.writeInt(total.get());
		    }

		    toClient.close();
		    fromClient.close();
		    clientSocket.close();
		} 
		catch (IOException e) {
		    System.exit(1);
		}
	}
        catch (Exception e) {
	    try {
		serverSocket.close(); 
	    }
	    catch (IOException io) {
		System.err.println("Couldn't close server socket" +
				   io.getMessage());
	    }
	}
    }
}
