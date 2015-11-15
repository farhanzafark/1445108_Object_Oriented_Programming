package linked_list;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linked_list myList = new linked_list("myList");
		int newVal;
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i<5;i++)
		{
			System.out.println("add value");
			newVal = scan.nextInt();
			myList.add(newVal);
			//myList.printlist();
		}
		myList.printlist();
		System.out.println("Node Count = "+myList.Count());
		scan.close();
		
	}

}
