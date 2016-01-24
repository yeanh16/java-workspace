public class Total {

    private int total = 0;
    
    public synchronized void add(int i) {
	total += i;
    }

    public synchronized int get() {
	return total;
    }
}
