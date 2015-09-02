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
	}
	
	@Test
	public void testAssignToStudent(){
		testStaff.assignToStudent(testStudent);
		assertEquals("Student number should be the same", testStaff.getStudentNumber(), testStudent.getStudentNumber());
	}
	
	
}
