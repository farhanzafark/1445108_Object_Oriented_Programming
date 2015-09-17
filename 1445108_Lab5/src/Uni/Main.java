package Uni;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String stName, dept;
		int stId;
		
		/*
		System.out.println();*/
		
		Student[] students = new Student[5];
		
		for(int i = 0; i <students.length;i++)
		{
			System.out.println("Enter Student Name");
			stName = scan.next();
			
			System.out.println("Enter id");
			stId = scan.nextInt();
			
			System.out.println("Enter department");
			dept = scan.next();
		
			students[i] = new Student(stName,stId, dept);
			
		}
		
		scan.close();
		
		for(int j = 0; j<students.length;j++)
		{
			System.out.println(students[j].studentName + " " + students[j].studentId+ " "+students[j].depName);
		}


	}

}
