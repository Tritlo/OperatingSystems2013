public class RaceThreads
{
	volatile long in;
	volatile boolean[] flag;
	volatile int turn;
	public long COUNT_MAX;
	
	public class CountThread extends Thread
	{
		int nr;
		public CountThread(int number)
		{
			super();
			this.nr = number;
		}
		public void run()
		{
			for(long i = 0l; i < COUNT_MAX; i++) 
			{
				flag[nr] = true;
				turn = 1-nr;
				while(flag[1-nr] && turn == 1-nr){}
				in++;
				flag[nr] = false;
			}
		}
	}
	
	public static void main(String[] args)
	{
		RaceThreads x = new RaceThreads(Long.parseLong(args[0]));
	}
	public RaceThreads(long max)
	{
		this.COUNT_MAX = max;
		Thread counter1 = new CountThread(0);
		Thread counter2 = new CountThread(1);
		this.in = 0l;
		this.flag = new boolean[2];
		flag[0] = false;
		flag[1] = false;
		
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
