public class Slave extends Thread {

    private String name;
    private BankAccount balance;
 
    public Slave (String name, BankAccount balance) {
        this.name = name;
        this.balance = balance; 
    }

    private void tell(String message) {
        System.out.println(message);
    }

    public void run () {
	tell("Slave " + name + " got started");

	for(int i=0;i<1000;i++){
		balance.payIn(1, name);
		balance.payIn(-1, name);
	}

	tell("Slave " + name + " finished");
    }
}

