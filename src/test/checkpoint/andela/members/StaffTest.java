package test.checkpoint.andela.members;

import static org.junit.Assert.*;

import org.junit.Test;

import checkpoint.andela.members.Staff;

public class StaffTest {

	@Test
	public void testStaff() {
		Staff sf = new Staff();
		assertNotNull("Should not be null", sf);
	}
	
}
