
public class Main {

	public static void main(String[] args) {
		FactoryStoreSignal fs = new FactoryStoreSignal();
		Event e = new Event(Event.EventState.UP);
		Clock c = new Clock(fs, e);
		Factory f = new Factory(fs);
		
		f.start();
		c.start();


	}

}
