package checkpoint.andela.members;

import checkpoint.andela.main.Member;

public class Student extends Member {
	private String StudentNumber;
	private String mClass;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String fullName, char g, String dateOfbirth, String phoneNumber) {
		super(fullName, g, dateOfbirth, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	
	// return the student number
	public String getStudentNumber() {
		return StudentNumber;
	}
	
	//set the student number
	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}
	
	// return the class of student
	public String getmClass() {
		return mClass;
	}
	// set the class of the student
	public void setmClass(String mClass) {
		this.mClass = mClass;
	}
	
}
