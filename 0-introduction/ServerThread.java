import java.net.*;
import java.io.*;
import java.util.*;

public class ServerThread extends Thread {

private HashSet<String> knownMessages = null;
private Socket socket = null;

public ServerThread(HashSet<String> knownMessages, Socket socket) {
    super("ServerThread");
    this.knownMessages = knownMessages;
    this.socket = socket;
}

public void run() {

  PrintWriter toClient;
  BufferedReader  fromClient;
    
  log("A new client connected");

  try {
      toClient = new PrintWriter(socket.getOutputStream(), true);
      fromClient  = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

      for (String clientMessage = fromClient.readLine();
           ! clientMessage.equals("bye");
           clientMessage = fromClient.readLine())
        {
          if (clientMessage.equals("")) {
              log("Got blank line from client - ignoring");
              toClient.println(""); // We need this. Why?
              continue;
          }
         
	  synchronized (knownMessages) {
          if (knownMessages.contains(clientMessage)) {
              toClient.println("Some client has already said " + clientMessage);
              log("Known message arrived:" + clientMessage);
          }
          else {
              knownMessages.add(clientMessage);
              toClient.println("You are the first client to say " 
                               + clientMessage);
              log("New message arrived: " + clientMessage);
          }
	  }
        }
        
        log("A client said `bye'");
        
        toClient.close();
        fromClient.close();
        socket.close();
    } 
    catch (IOException e) {
        System.exit(1);
    }
}
    
private void log(String message)
{
    System.out.println(message);
}
}
