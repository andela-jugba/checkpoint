package test.checkpoint.andela.readersclub;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.readersclub.ReadersClub;

public class ReadersClubTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadersClub() {
		ReadersClub rC = new ReadersClub();
		assertNotNull("ReadersClub class should exist", rC);
	}

}
