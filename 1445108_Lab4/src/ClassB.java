
public class ClassB extends ClassA{
	
	public ClassB()
	{
		super("Class B");
	}
	
	private int subtract(int a, int b)
	{
		int ans=0;
		ans = a-b;
		return ans;
	}
	
	public int resultOfMultiply()
	{
		int ans;
		ans = Multiply(3,4);
		return ans;
	}
	
	public int resultOfAdd()
	{
		int ans=0;
		//ans = Add(1,2);
		return ans;
	}
	
	protected float divide(int a, int b)
	{
		float ans;
		ans = a/b;
		return ans;
	}

}
