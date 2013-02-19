public class RaceThreads
{
	volatile int in;
	public int COUNT_MAX;
	
	public class CountThread extends Thread
	{
		public void run()
		{
			for(int i = 0; i < COUNT_MAX; i++) in++;
		}
	}
	
	public static void main(String[] args)
	{
		RaceThreads x = new RaceThreads(Integer.parseInt(args[0]));
	}
	public RaceThreads(int max)
	{
		this.COUNT_MAX = max;
		Thread counter1 = new CountThread();
		Thread counter2 = new CountThread();
		this.in = 0;
		
		counter1.start();
		counter2.start();
		
		try
		{
			counter1.join();
			counter2.join();
		} catch (InterruptedException ie) {return;}
		
		System.out.println("COUNT_MAX = " + max + "\nin = " + in + "\n2*COUNT_MAX - in = " + (2*max - in));
	}
}
