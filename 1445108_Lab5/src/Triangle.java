
public class Triangle extends Shape{
	
	protected double base, height;
	
	public Triangle(double base_length, double ht)
	{
		super("Triangle");
		base = base_length;
		height = ht;
		
	}
	
	public double area()
	{
		double area;
		area = 0.5*base*height;
		return area;
	}
	
	public double perimeter()
	{
		double per;
		per = 2*(base+height);
		return per;
	}


}
