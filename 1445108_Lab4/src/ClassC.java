
public class ClassC extends ClassB {
	
	private String someStr;
	public ClassC()
	{
		super();
	} 
	
	public String printHello()
	{
		setString();
		return someStr;
	}
	
	private void setString()
	{
		someStr="Hello World";
	}
	
	protected String printALine()
	{
		return "This is another string.";
	}
	
	

}
