import java.net.Socket;
import java.io.*;

public class Client2 {
  public static void main(String[] args) throws IOException {

    long start = System.currentTimeMillis();

    Socket s = new Socket("localhost", 4444);
    ObjectOutputStream toServer = new ObjectOutputStream(s.getOutputStream());

    for (int id=0; id < HowMany.times; id++) {
      toServer.writeObject(new Person("John", id));
    }

    long end = System.currentTimeMillis();
    System.out.println("Total time " + (end-start)/1000 + "s");
  }
}

