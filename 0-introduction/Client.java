import java.io.*;
import java.net.*;

public class Client {

private Socket server;
private PrintWriter toServer;
private BufferedReader fromServer;
private BufferedReader fromUser;

public Client(String serverName)
{
    try {
        server = new Socket(serverName, 4444);
        toServer = new PrintWriter(server.getOutputStream(), true);
        fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
    } 
    catch (UnknownHostException e) {
        error("Unknown host: " + serverName);
    } 
    catch (IOException e) {
        error("Couldn't get I/O for the connection to " + serverName);
    }
    
    fromUser = new BufferedReader(new InputStreamReader(System.in));
}

private void error(String message) 
{
    System.err.println(message);
    System.exit(1); // Don't do this in practice! (Why?)
}


private void tell(String message) 
{
    System.out.println(message);
}


public void finalize () 
{
    try {
        // Let server know we are done.
        
        toServer.println("bye"); 

        // Close the streams:

        toServer.close();
        fromServer.close();
        fromUser.close();
        server.close();
    }
    catch (IOException e) {
        error("Something went wrong ending the client");
    }
}


public void run() 
{
    try {
        tell("Say `bye' when you are done");

        for (String userInput = fromUser.readLine();
             userInput != null && ! userInput.equals("bye");
             userInput = fromUser.readLine())
            {                         
                toServer.println(userInput);
                tell("sent message to server");

		String serverResponse = fromServer.readLine();
                
                if (serverResponse == null)
                    {
                        tell("The server appears to have crashed");
                        System.exit(1);
                    }
		else
                    tell(serverResponse);
            }

        toServer.println("bye");
    }
    catch (IOException e) {
        error("Socket commmunication broke");
    }
}
}

