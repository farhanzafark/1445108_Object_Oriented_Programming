package Clocks;

public class Clock {

	private Counter secs, mins, hours;
	
	public Clock()
	{
		hours = new Counter(24);
		mins = new Counter(60);
		secs = new Counter(60);
		
	}
	
	public void tick()
	{
		secs.increment();
		if(secs.ShowCount()==0)
		{
			mins.increment();
			if(mins.ShowCount()==0)
			{
				hours.increment();
			}
		}
	}
	
	public int viewHrs()
	{
		return hours.ShowCount();
	}
	
	public int viewMins()
	{
		return mins.ShowCount();
	}
	
	public void showTime()
	{
		System.out.println(hours.ShowCount()+":"+mins.ShowCount()+":"+secs.ShowCount());
	}
}
