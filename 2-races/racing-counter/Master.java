public class Master {

    private static void tell(String message) {
        System.out.println(message);
    }

    public static void main(String args[]) {
        tell("Master got started");

        Counter counter = new Counter();

        Slave [] slave = new Slave[args.length];

        for (int i = 0; i < args.length; i++) {
            tell("Master is starting slave " + args[i]);
            slave[i] = new Slave(args[i],counter);
            slave[i].start();
        }

        tell("Master will now wait for each slave to finish");

        try {
            for (Slave s : slave)
                s.join();
	}
        catch (InterruptedException e) {
            tell("Interruption before completion of the joins" + e);
            tell("Master has given up waiting for slaves");
	    // This won't actually happen.
        }

	tell("counter should be 0 and actually is " + counter.get());
	    
        tell("Master is exiting");
    }
}
