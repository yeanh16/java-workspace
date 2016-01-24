import java.net.*;
import java.io.*;

public class Server {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(4444);
    Socket socket = ss.accept();

    ObjectInputStream fromClient = new ObjectInputStream(
                            socket.getInputStream());

    int count=0;

    for(int i = 0; i < HowMany.times; i++) {
      Person p = (Person) fromClient.readObject();

      if (count++ % 1000 == 0) {
        System.out.println(p);
      }
    }
  }
}
