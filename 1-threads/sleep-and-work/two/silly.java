import java.util.*;

public class Slave extends Thread {

    private String name;
 
    public Slave (String name) {
        this.name = name; 
    }

    private void tell(String message) {
        System.out.println(message);
    }

    public void run () {
        Random r = new Random();

    int i = 0;
    while (true) {
               int n = r.nextInt(2000);

                i = i + 1;
                tell(name + " has counted " + i + 
                    " and now will sleep for " + n + "ms");
                try {
                  sleep(n);
                }
                catch (InterruptedException e) {
                }
    }
}

