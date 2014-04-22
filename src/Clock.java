
public class Clock extends Thread {
	private long lastTime;
	private FactoryStoreSignal fs;
	private Event ev;
	
	public Clock(FactoryStoreSignal s, Event e)
	{
		lastTime = System.currentTimeMillis();
		fs = s;
		ev = e;
	}
	
	public void run()
	{
		while (true)
		{
			try {
				ev.set();
				ev.await(Event.EventState.UP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			 long time = System.currentTimeMillis();
			 if (time - lastTime > 2000)
			 {
				 lastTime = time;
				 fs.send();
				 ev.reset();
			 }
		}
	} //run

}
