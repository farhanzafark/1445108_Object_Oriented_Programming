package Uni;

public class Student extends Department{
	
	protected String studentName;
	protected int studentId;
	public Student(String Name, int Id, String deptName)
	{
		
		super(deptName);
		studentName = Name;
		studentId = Id;
	}

}
