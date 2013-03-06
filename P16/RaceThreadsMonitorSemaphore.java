public class RaceThreadsMonitorSemaphore
{
	volatile int in;
	public int COUNT_MAX;
        private MonitorSemaphore sem = new MonitorSemaphore(1);
        //If we had 2 here, 2 threads would enter the critical section at the same time.
    
	public class CountThread extends Thread
	{
	    public CountThread(String name)
	    {
		    super(name);
	    }
		public void run()
		{
			for(int i = 0; i < COUNT_MAX; i++)
			{
			    sem.MSwait(1);
			    System.out.print(this.getName());
			    System.out.flush();
			    in++;
			    sem.MSsignal(1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		RaceThreadsMonitorSemaphore x = new RaceThreadsMonitorSemaphore(Integer.parseInt(args[0]));
	}

	public RaceThreadsMonitorSemaphore(int max)
	{
		this.COUNT_MAX = max;
		Thread counter1 = new CountThread("0");
		Thread counter2 = new CountThread("1");
		this.in = 0;
		
		counter1.start();
		counter2.start();
		
		try
		{
			counter1.join();
			counter2.join();
		} catch (InterruptedException ie) {return;}
		System.out.println();
		System.out.println("COUNT_MAX = " + max + "\nin = " + in + "\n2*COUNT_MAX - in = " + (2*max - in));
	}
}
