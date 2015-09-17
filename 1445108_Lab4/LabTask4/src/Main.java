
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arg1, arg2, selection;
		Scanner scan = new Scanner(System.in);
		
		calculator calc = new calculator();
		
		System.out.println("Enter a choice: 1.Add 2.Subtract 3.Multiply 4.Divide");
		selection = scan.nextInt();
		
		System.out.println("Enter a number:");
		arg1 = scan.nextInt();
		System.out.println("Enter a number:");
		arg2 = scan.nextInt();
		
		switch(selection)
		{
		
		case 1:
			calc.add(arg1,arg2);
			break;
		
		case 2:
			calc.subtract(arg1,arg2);
			break;
		
		case 3:
			calc.multiply(arg1,arg2);
			break;
		
		case 4:
			calc.divide(arg1,arg2);
			break;
		}
		
		
		
		scan.close();
		
		//System.in.read();
	}

}
