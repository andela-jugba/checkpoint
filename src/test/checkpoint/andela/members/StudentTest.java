package test.checkpoint.andela.members;

import static org.junit.Assert.*;

import org.junit.Test;

import checkpoint.andela.members.Student;

public class StudentTest {

	@Test
	public void testStudentClass() {
		Student st = new Student();
		assertNotNull("should not be null", st);
		
		st.setmClass("D");
		st.setStudentNumber("133143");
		assertEquals(st.getmClass(), "D");
		assertEquals(st.getStudentNumber(), "133143");
	}

}
