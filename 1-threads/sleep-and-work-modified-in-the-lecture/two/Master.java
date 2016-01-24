public class Master {

    private static void tell(String message) {
        System.out.println(message);
    }

    public static void main (String args[]) {
        tell("Master got started");

        tell("Master is starting slave John");
        Slave john = new Slave ("John");
        john.start();

        tell("Master is starting slave Mary");
        Slave mary = new Slave ("Mary");
        mary.start();
        
        int n = 5;

        tell("Master will sleep for " + n + " seconds");

        try {
            Thread.sleep(n * 1000); 
            tell("Master has woken up");
        }
        catch (InterruptedException e) {
            tell("Somebody has awaken the Master" + e);
            // This actually won't happen.
        }
        finally {
            john.interrupt();
            mary.interrupt();
	}

	tell("Master ended");
        }
}
