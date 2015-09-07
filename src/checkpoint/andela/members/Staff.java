package checkpoint.andela.members;

import java.util.ArrayList;

import checkpoint.andela.main.Member;

public class Staff extends Member {
	private String staffNumber;
	private Double netPay;
	private ArrayList<Student> studentList;

	public Staff(String fullName, char g, String dateOfbirth, String phoneNumber) {
		super(fullName, g, dateOfbirth, phoneNumber);
		studentList = new ArrayList<>();
	}
	public Staff() {
		studentList = new ArrayList<>();
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public Double getNetPay() {
		return netPay;
	}

	public boolean setNetPay(Double netPay) {
		if(netPay > 0) {
			this.netPay = netPay;
			return true;
		}
		else return false;
	}
	public void assignToStudent(Student testStudent) {
		studentList.add(testStudent);
		
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
}
