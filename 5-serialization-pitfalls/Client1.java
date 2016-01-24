import java.net.Socket;
import java.io.*;

public class Client1 {
  public static void main(String[] args) throws IOException {

    long start = System.currentTimeMillis();

    Socket s = new Socket("localhost", 4444);
    ObjectOutputStream toServer = new ObjectOutputStream(s.getOutputStream());

    Person p = new Person("John", 0);

    for (int id=0; id < HowMany.times; id++) {
      p.setId(id);
      toServer.writeObject(p);
    }

    long end = System.currentTimeMillis();
    System.out.println("total " + (end-start)/1000 + "s");
    toServer.close();
  }
}
