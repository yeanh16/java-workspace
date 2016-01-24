import java.util.ArrayList;

public class BankAccount {

    private int balance = 0;
    private ArrayList<String> statement = new ArrayList<String>();
    
    public synchronized void payIn(int amount, String name){
    	this.balance = balance + amount;
    	this.statement.add(name + ", " + amount);
    }

    public int getBalance() {
	return this.balance;
    }
    
    public ArrayList<String> getStatement(){
    	return this.statement;
    }
}
