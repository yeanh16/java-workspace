import java.net.Socket;
import java.io.*;

public class Client3 {
  public static void main(String[] args) throws IOException {

    long start = System.currentTimeMillis();

    Socket s = new Socket("localhost", 4444);
    ObjectOutputStream toServer = new ObjectOutputStream(s.getOutputStream());

    Person p = new Person("John", 0);

    for (int id=0; id < HowMany.times; id++) {
      p.setId(id);
      toServer.writeObject(p);
  
      toServer.reset();
    }

    long end = System.currentTimeMillis();
    System.out.println("Total time " + (end-start)/1000 + "s");
  }
}
