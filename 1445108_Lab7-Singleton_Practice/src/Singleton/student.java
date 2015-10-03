package Singleton;

public class student {

	private static student stObj = new student();
	
	private student() {	}
	
	public static student getInstance()
	{
		return stObj;
	}
	
	protected static void printStatement()
	{
		System.out.println("This is a student object");
	}
}
