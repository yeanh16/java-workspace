public class Philosopher extends Thread {
  private int name;
  private Object firstFork, secondFork;

  public Philosopher(int name, Object firstFork, Object secondFork) {
    this.name = name;
    this.firstFork = firstFork;
    this.secondFork = secondFork;
  }

  public void run () {
    for (int i = 0; true; i++) {
      synchronized (firstFork) {
        System.out.println("Philosopher " + name + " grabbed a fork");

        synchronized (secondFork) {
          System.out.println("Philosopher " + name + " grabbed the other fork");
          System.out.println(name + " is eating for the " + i + " time");

          try { 
              sleep(400); // Eating takes some time.
          }
          catch (InterruptedException e) {
          }    
        }

        System.out.println("Philosopher " + name + " released a fork");
      }

      System.out.println("Philosopher " + name + " released the other fork");
    }
  }
}
