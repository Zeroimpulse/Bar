
public class Factory extends Thread {
	private FactoryStoreSignal fs;
	private int maxUnits = 20;
	private int units;
	private int warehouseUnits;
	
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
			
			warehouseUnits = fs.getUnits();
			
			units = (int) (maxUnits * Math.exp(-.007 * warehouseUnits));
			System.out.println(units);
			
			fs.add(units);
			
			
			
			
			
			
		}
		
	}

}
