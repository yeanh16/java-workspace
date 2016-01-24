// Usage:
//        java Client hostname

import java.io.*;
import java.net.*;

public class Client {

    Socket server;
    DataOutputStream toServer;
    DataInputStream fromServer;
    BufferedReader fromUser;

    Client(String serverName)
    {
        try {
            server = new Socket(serverName, 4444);
            toServer = new DataOutputStream(server.getOutputStream());
            fromServer = new DataInputStream(server.getInputStream());
        } 
        catch (UnknownHostException e) {
            error("Unknown host: " + serverName);
        } 
        catch (IOException e) {
            error("Couldn't get I/O for the connection to " + serverName);
        }

	fromUser = new BufferedReader(new InputStreamReader(System.in));
    }


    private void error(String message) {
	System.err.println(message);
	System.exit(1); // Don't do this in practice! (Why?)
    }


    private void tell(String message) {
	System.out.println(message);
    }


    public void finalize () {
	try {
	    // Let server know we are done.
	    // Our convention is to send "0" to indicate this.

	    toServer.writeInt(0); 

	    // Close the streams:

	    toServer.close();
	    fromServer.close();
	    fromUser.close();
	    server.close();
	}
	catch (IOException e) {
	    error("Something went wrong ending the client");
	    System.exit(-1); // Don't do this in practice.
	}
    }


    public void run() {
	try {
	    String userInput;
	    int serverNumber;

	    while ((userInput = fromUser.readLine()) != null) {

		// We stipulate that a blank line tell the client to end:

		if (userInput.equals(""))
		    break; 
		
		int userNumber = Integer.parseInt(userInput);
		
		toServer.writeInt(userNumber);
		tell("sent " + userNumber + " to server");

		serverNumber = fromServer.readInt();
		tell("got " + serverNumber + " from server");
	    }
	}
	catch (IOException e) {
	    error("Socket commmunication broke");
	}
    }
}

