package Clocks;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlarmClock clock1 = new AlarmClock();
		clock1.setAlarm(0, 12);
		for(int i =0; i<1000;i++)
		{
			clock1.tick();
			clock1.showTime();
		}
	}

}
