
public class Clock extends Thread {
	private long lastTime;
	private FactoryStoreSignal fs;
	
	public Clock(FactoryStoreSignal s)
	{
		lastTime = System.currentTimeMillis();
		fs = s;
	}
	
	public void run()
	{
		while (true)
		{
			
			 long time = System.currentTimeMillis();
			 if (time - lastTime > 2000)
			 {
				 lastTime = time;
				 fs.send();
			 }
		}
	} //run

}
