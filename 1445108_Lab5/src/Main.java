
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape [ ] shapeList = new Shape[5];
        shapeList[0] = new Circle(3.0);
        shapeList[1] = new Rectangle(3.0, 4.0);
        shapeList[2] = new Rectangle(2.5, 7.5);
        shapeList[3] = new Circle(2.5);
        shapeList[4] = new Square(5.0);
        for (int i = 0; i < shapeList.length; i++)  {
        	System.out.print (shapeList[i].nameToString( ) + " ");
        	System.out.print (shapeList[i].area( ) + " ");
        	System.out.println (shapeList[i].perimeter( ));
        }


	}

}
