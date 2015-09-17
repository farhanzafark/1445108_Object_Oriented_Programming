
public class calculator extends result{

	public void add(int a, int b)
	{
		
		showResult("Result of add "+ a+b);
	}
	
	public void subtract(int a, int b)
	{
		showResult("Result of subtract "+(a-b));
	}
	
	public void multiply(int a, int b)
	{
		showResult("Result of multiply "+(a*b));
	}
	
	public void divide(int a, int b)
	{
		showResult("Result of divide "+(a/b));
	}
}
