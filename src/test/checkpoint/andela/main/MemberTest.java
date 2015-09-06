package test.checkpoint.andela.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class MemberTest {
	Book testBook;
	Member member;
	@Before
	public void setUp() throws Exception {
		member = new Member("James Harden",'M', "12/3/1988", "23243545");
		testBook = new Book();
	}
	@Test
	public void testMember(){	
		assertNotNull(member);
	}
	
	@Test
	public void testBorrowBook() {
		assertFalse(member.borrowBook(testBook));
	}
	
	@Test
	public void testReturnBook() {
		member.borrowBook(testBook);
		member.returnBook(testBook);
		assertEquals(0, member.getNumberOfBooksBorrowed());
	}

}
