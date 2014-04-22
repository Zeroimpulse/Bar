import java.util.ArrayList;

/**
 * FactoryStoreSignal is used by Clock to signal the Waiter threads that a clock tick has
 * occurred. The heart of the signaling algorithm is in waitS().
 * @author P. von Kaenel
 *
 */
public class FactoryStoreSignal {
	private int units;
	private boolean started;
	private Store s;
	private Factory f;

	/**
	 * Constructor creates an ArrayList to store Waiters.  
	 * Also, a boolean that indicates the FactoryStoreSignal hasn't yet been
	 * activated is set.
	 */
	public FactoryStoreSignal() {
		units = 0;
		started = false;
	}
	
	public int getUnits() {
		return units;
	}

	/**
	 * Threads that have already received the signal are put in a wait
	 * state.  New signals clear the ArrayList of Waiters that have received
	 * the signal, so waiting threads are released and are added to
	 * the ArrayList.
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void waitS() throws InterruptedException {
		Factory f = (Factory)Thread.currentThread();
		started = false;
		while (!started) 
			wait();
		
		
		
	}

	/**
	 * This sends the signal. The list of Waiters that received the signal
	 * is cleared. 
	 */
	public synchronized void send() {
		started = true;
		notifyAll();
		
	}
}
