package Clocks;

public class AlarmClock extends Clock{

	private boolean alarmOn;
	
	private int hrSet, minSet;
	
	public AlarmClock()
	{
		alarmOn = false;
	}
	
	public void setAlarm(int hours, int mins)
	{
		hrSet = hours;
		minSet = mins;
		alarmOn = true;
	}
	
	public void tick()
	{
		super.tick();
		if((alarmOn == true) && (super.viewHrs()==hrSet)&& (super.viewMins()==minSet))
		{
			System.out.println("Ring, Ring!!");
			
		}
	}
	
	public void resetAlarm()
	{
		alarmOn = false;
	}
}
