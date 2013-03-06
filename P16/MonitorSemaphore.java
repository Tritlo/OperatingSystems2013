public class MonitorSemaphore
{
  private int Licenses = 0; //Stores the amount of licenses currently available, >= 0
  private int TotalLicenses = 0;
  
  //Use: sem = new MonitorSemaphore(L)
  //Pre: L >= 0;
  //Post: sem is a new MonitorSemaphore object with L licenses
  public MonitorSemaphore(int Licenses)
  {
    this.MSinit(Licenses);
  }
  
  //Use: sem.MSinit(L)
  //Pre: L >= 0;
  //Post: sem is initialized with L licenses
  public synchronized void MSinit(int Licenses)
  {
    this.Licenses = Licenses;
    this.TotalLicenses = Licenses;
  }

  //Use: sem.MSsignal(L)
  //Pre: L >= 0;
  //Post: sem has freed L licenses
  public synchronized void MSsignal(int toFree)
  {
    if (this.Licenses + toFree > this.TotalLicenses)
      {
	throw new IllegalArgumentException();
      }
    this.Licenses += toFree;
    notifyAll();
  }

  //Use: sem.MSsignal(L)
  //Pre: L >= 0;
  //Post: sem has waited until ask licenses were available
  public synchronized void MSwait(int ask)
  {
    while (this.Licenses < ask){
      try{
	wait();
      } catch (InterruptedException e) {}
    } 
    this.Licenses -= ask;
  }
}
