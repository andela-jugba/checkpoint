package test.checkpoint.andela.main;

import static org.junit.Assert.*;

import org.junit.Test;

import checkpoint.andela.main.Book;

public class BookTest {

	@Test
	public void testMember() {
		Book book = new Book();
		assertNotNull(book);
	}

}
