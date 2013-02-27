import java.util.concurrent.Semaphore;
public class RaceThreadsSemaphore
{
	volatile int in;
	public int COUNT_MAX;
	private Semaphore sem = new Semaphore(1);
	
	public class CountThread extends Thread
	{
		public void run()
		{
			for(int i = 0; i < COUNT_MAX; i++)
			{
			    sem.acquireUninterruptibly();
			    in++;
			    sem.release();
			}
		}
	}
	
	public static void main(String[] args)
	{
		RaceThreadsSemaphore x = new RaceThreadsSemaphore(Integer.parseInt(args[0]));
	}

	public RaceThreadsSemaphore(int max)
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
