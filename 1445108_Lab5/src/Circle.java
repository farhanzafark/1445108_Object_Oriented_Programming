
public class Circle extends Shape{
	
	private double rad; 
	
	public Circle(double radius)
	{
		super("Circle");
		rad = radius;
	}
	
	public double area()
	{
		double area;
		area = Math.PI*rad*rad;
		return area;
	}
	
	public double perimeter()
	{
		double per;
		per = 2*Math.PI*rad;
		return per;
	}


}
