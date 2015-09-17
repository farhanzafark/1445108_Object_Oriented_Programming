
public class Math {

	
	public int factorial(int num1)
	{
		int count;
		int fact;
		fact = num1;
		for(count=num1-1;count>0;count--)
		{
			fact = fact*count;
		}
		return fact;
	}
}
