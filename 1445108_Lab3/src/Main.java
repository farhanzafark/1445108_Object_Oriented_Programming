
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator calc = new Calculator();
		Math math1 = new Math();
		
		//add 
		System.out.println(calc.add(3, 4));
		
		//subtract
		System.out.println(calc.subtract(4, 3));
		
		//multiply
		System.out.println(calc.multiply(3, 4));
		
		//divide
		System.out.println(calc.divide(4, 2));
		
		//factorial
		System.out.println(math1.factorial(5));
		
		//===========================================================================================//
		
		FordCar ford1 = new FordCar();
		FordCar ford2 = new FordCar();
		
		FordCar focus = new FordCar();
				
		focus.Color = "Black";
		focus.Cylinder=4;
		
		
		ford1.Color = "Orange";
		ford1.Cylinder = 8;
		ford1.Model = "Taurus";
		ford1.Accelerate();
		ford2.Start();
		
		//===========================================================================================//
		
		Person person1 = new Person();
		
		person1.Age=20;
		person1.Height=154;
		person1.Name="Ronaldo";
		
		
		//===========================================================================================//
		
		BankAccount savings1 = new BankAccount();
		savings1.account_type="savings";
		savings1.customer_name="Fayez Ahmed";
		
		System.out.println(savings1.deposit(12000));
		System.out.println(savings1.withdrawal(3500));
		
		
		//===========================================================================================//

	}

}
