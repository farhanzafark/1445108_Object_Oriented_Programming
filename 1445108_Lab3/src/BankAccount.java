
public class BankAccount {
	
	public String customer_name, account_type;
	private int balance = 10000;

	public int deposit(int depositAmount)
	{
		balance = balance + depositAmount;
		return balance;
	}
	
	public int withdrawal(int withdrawAmount)
	{
		balance = balance - withdrawAmount;
		return balance;
	}


}
