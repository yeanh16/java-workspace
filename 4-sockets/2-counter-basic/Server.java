import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

	// This will be shared by all clients:
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
	    while (true) {
		Socket clientSocket = serverSocket.accept();
                ServerThread s = new ServerThread(total, clientSocket);
		s.start();
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
