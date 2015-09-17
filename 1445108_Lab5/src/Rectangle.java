public class Rectangle extends Shape{
	
	protected double len,wid;
	
	//custom constructors
	public Rectangle(double length, double width)
	{
		super("Rectangle");
		len = length;
		wid = width;
	}
	
	public Rectangle(String name, double side)
	{
		super(name);
		len = side;
		wid = side;
	}
	
	public double area()
	{
		double area;
		area = len*wid;
		return area;
	}
	
	public double perimeter()
	{
		double per;
		per = 2*(len+wid);
		return per;
	}

}
