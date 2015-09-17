
public class Calculator {
	private int sum;
	//public int num1, num2;
	
	public int add(int num1, int num2)
	{
		sum= num1+num2;
		return sum;
	}
	
	public int subtract(int num1, int num2)
	{
		sum= num1-num2;
		return sum;
	}
	
	public int multiply(int num1, int num2)
	{
		sum= num1*num2;
		return sum;
	}
	
	public int divide(int num1, int num2)
	{
		sum= num1/num2;
		return sum;
	}
}
