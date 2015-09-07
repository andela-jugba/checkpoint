package checkpoint.andela.members;

import checkpoint.andela.main.Member;

public class Staff extends Member {
	
	private String staffNumber;
	private Double netPay;
	private String studentNumber;

	public Staff(String fullName, char g, String dateOfbirth, String phoneNumber) {
		super(fullName, g, dateOfbirth, phoneNumber);
		// TODO Auto-generated constructor stub
	}
	public Staff() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		
	}
	public String getStudentNumber() {
		return studentNumber;
	}

}
