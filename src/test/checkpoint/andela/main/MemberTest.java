package test.checkpoint.andela.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

public class MemberTest {
	Book testBook;
	Member member;

	@Before
	public void setUp() throws Exception {
		member = new Member("James Harden", 'M', "12/3/1988", "23243545");
		testBook = new Book("bb", "fdf", 1, "fdfdf");
	}

	@Test
	public void testMember() {
		assertNotNull(member);
		assertEquals(member.getFullName(), "James Harden");
		assertEquals(member.getGender().toString(), "M");
		assertEquals(member.getDateOfbirth(),"12/3/1988");
		assertEquals(member.getPhoneNumber(), "23243545");
		
		member.setEmail("this@goo.com");
		assertEquals(member.getEmail(), "this@goo.com" );
		
	}
 
	@Test
	public void testReturnBook() {
		member.borrowBook(testBook);
		member.returnBook(testBook);
		assertEquals(1, testBook.getNumberOfCopies());
	}

	@Test
	public void testCompareTo() {
		Member mem = new Member();
		member.setDateOfRegistration(2000, 2, 1);
		assertEquals(1,member.compareTo(mem));
		assertEquals(0, mem.compareTo(mem));
		assertEquals(-1, mem.compareTo(member));
	}
	
	@Test
	public void testCompareToDifferentClasses() {
		Staff sf = new Staff();
		sf.setDateOfRegistration(1999, 1, 4);
		Staff sf1 = new Staff();
		Student sd = new Student();
		Student sd1 = new Student();
		sd1.setDateOfRegistration(1992, 2, 3);
		
		assertEquals(-1,sf.compareTo(sd));
		assertEquals(1, sd.compareTo(sf));
		assertEquals(1, sf.compareTo(sf1));
		assertEquals(-1, sf1.compareTo(sd1));
		assertEquals(1, sd1.compareTo(sd));
		assertEquals(-1, sd.compareTo(sd1));
		
		assertEquals(1, sf.compareTo(sf1));
		assertEquals(-1, sf1.compareTo(sf));
		
	}
}
