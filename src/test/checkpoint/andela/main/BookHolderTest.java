package test.checkpoint.andela.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.BookHolder;

public class BookHolderTest {
	BookHolder bh;
	Book book;
	Book nullBook;
	
	@Before
	public void setUp() throws Exception {
		bh = new BookHolder();
		book = new Book();
	}
	
	@Test
	public void testAdd() {
		bh.add(book);
		assertEquals("Should return the added book object",bh.remove(book), book);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullBook() {
		bh.add(nullBook);
	}
	
	@Test
	public void testRemove() {
		assertNull("Should return null when a book not on the list is removed",bh.remove(book));
	}
	
	@Test
	public void testPop() {
		bh.add(book);
		Book bk = bh.pop();
		assertSame("Should return the same book object",bk, book);
		
		assertNull("Should return null when a book is removed from an empty list", bh.pop());
	}
	
	@Test
	public void testPeek() {
		bh.add(book);
		assertSame("Should show the book at the top of the list",book, bh.peek());
	}
	
	@Test
	public void testNumberOfBooks() {
		int num = bh.numberOfBooks();
		assertEquals("should contain 0 book", num, 0);
	}
}
