package test.checkpoint.andela.main;

import static org.junit.Assert.*;

import org.junit.Test;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.BookHolder;

public class BookHolderTest {

	@Test
	public void testAdd() {
		BookHolder bh = new BookHolder();
		Book book = new Book();
		bh.add(book);
		assertEquals("Should return the added book object",bh.remove(book), book);
		
	}

}
