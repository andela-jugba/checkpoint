package test.checkpoint.andela.members;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

public class StaffTest {
	Staff testStaff;
	Student testStudent;

	@Before
	public void setUp() throws Exception {
		testStaff = new Staff("James Harden", 'M', "2/13/1978", "0999095356");
		testStudent = new Student("Kol Weell", 'F', "23/45/66", "42345245525");
	}

	@Test
	public void testStaff() {
		Staff sf = new Staff();
		assertNotNull("Should not be null", sf);
		sf.setStaffNumber("nmm");
		assertEquals(sf.getStaffNumber(),"nmm");
		
	}

	@Test
	public void testSetNetPayWithWrongAmount() {
		assertFalse(testStaff.setNetPay(-1.0));
		assertTrue(testStaff.setNetPay(10.0));
		testStaff.setNetPay(20.0);
		assertNotNull(testStaff.getNetPay());
	}

	@Test
	public void testAssignStudent() {
		assertTrue(testStaff.getStudentList().isEmpty());
		testStaff.assignToStudent(testStudent);
		assertFalse(testStaff.getStudentList().isEmpty());
		assertEquals(testStaff.getStudentList().get(0).getStudentNumber(), testStudent.getStudentNumber());
	}

}
