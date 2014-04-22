
public class Factory extends Thread {
	private FactoryStoreSignal fs;
	private int maxUnits;
	private int units;
	
	public Factory (FactoryStoreSignal s) {
		fs = s;
	}
	
	public void run() {
		
		while(true) {
			try {
				fs.waitS();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			units = (int) (Math.random() * 6);
			
			System.out.println(units);
			
			
			
			
		}
		
	}

}
