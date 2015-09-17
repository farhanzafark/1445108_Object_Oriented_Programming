public abstract class Shape {
	
	protected String shapeName;
	
	//custom constructor
	public Shape(String string)
	{
		shapeName = string;
	}
	
	public abstract double area();
	
	public abstract double perimeter();
	
	public String nameToString()
	{
		return shapeName;
	}
	

}
