package test.checkpoint.andela.readersclub;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;
import checkpoint.andela.readersclub.ReadersClub;

public class ReadersClubTest {
	private ReadersClub testClub;
	private Book testBook;
	private Book testBook2;
	private Student testStudent1;
	private Student testStudent2;
	private Staff testStaff1;
	private Staff testStaff2;
	private ArrayList<Member> list;

	@Before
	public void setUp() throws Exception {
		testClub = new ReadersClub();
		testBook = new Book("Things fall apart", "Chinua Achebe", 4, "fs3534t4g4");
		testBook2 = new Book("Gone with the wind", "Unknown", 1, "wfwf345");
		testStudent1 = new Student("Student1", 'M', "1996", "341224525");
		testStudent2 = new Student("Student2", 'F', "1997", "242425");
		testStaff1 = new Staff("Staff1", 'F', "1989", "4242545");
		testStaff2 = new Staff("Staff2", 'M', "1990", "23423424");

		testStaff2.setDateOfRegistration(2000, 5, 1);
		testStaff1.setDateOfRegistration(2008, 5, 4);
		testStudent1.setDateOfRegistration(2006, 3, 4);
		testStudent2.setDateOfRegistration(2007, 7, 12);
		
		list = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
		testClub.getQueue().clear();
		testClub.getBorrowers().clear();
		list.clear();
	}

	@Test
	public void testReadersClub() {
		assertNotNull("ReadersClub class should exist", testClub);
	}

	@Test
	public void testAddBookToClub() {
		assertNotEquals(testClub.getBook(), testBook2);
		testClub.addBookToClub(testBook2);
		assertEquals(testBook2, testClub.getBook());
	}

	@Test
	public void testReturnBookNotInClub() {
		int num = testBook.getNumberOfCopies();
		testClub.addBookToClub(testBook2);
		testStaff1.returnBook(testBook);
		assertEquals(num, testBook.getNumberOfCopies());
	}

	@Test
	public void testReturnBookAndBookBorrowedFromClub() {
		Book book = new Book("String", "author", 4, "dfdfdfg");
		testClub.addBookToClub(book);
		testStaff1.borrowBook(book);

		// process queue so the member gets the book before returning it
		testClub.processQueues();
		assertEquals(3, book.getNumberOfCopies());

		testStaff1.returnBook(book);
		assertEquals(4, book.getNumberOfCopies());
	}

	@Test
	public void testProcessQueueNonEmptyQueue() {
		testClub.addBookToClub(testBook);
		testStudent1.borrowBook(testBook);
		testClub.processQueues();
		assertEquals(testBook.getNumberOfCopies(), 3);
	}

	@Test
	public void testProcessQueueWithMoreBorrowersThanBooks() {
		Book book = new Book("hdfjfh", "kn", 3, "ffs");
		testClub.addBookToClub(book);
		testStaff1.borrowBook(book);
		testStaff2.borrowBook(book);
		testStaff1.borrowBook(book);
		testStudent1.borrowBook(book);
		testStudent2.borrowBook(book);

		testClub.processQueues();

		// Show who gets the books
		list.add(testStaff2);
		list.add(testStaff1);
		list.add(testStudent1);
		
		assertEquals(list,testClub.getBorrowers());

	}
	
	@Test
	public void testBorrowWithTwoBorrowers() {
		Book book = new Book("hdfjfh", "kn",1, "ffs");
		testClub.addBookToClub(book);
		testStaff1.borrowBook(book);
		testStaff2.borrowBook(book);
		
		testClub.processQueues();
		
		list.add(testStaff2);
		
		assertEquals(list,testClub.getBorrowers());
		
	}
	
	@Test
	public void testBorrowWhenStudentOrdersFirst() {
		Staff staff = new Staff("Staff1", 'F', "1989", "4242545");
		staff.setDateOfRegistration(2010, 5, 1);
		Book book = new Book("hdfjfh", "kn",1, "ffs");
		testClub.addBookToClub(book);
		
		testStudent1.borrowBook(book);
		staff.borrowBook(book);
		testStaff2.borrowBook(book);
		
		testClub.processQueues();
		
		list.add(testStaff2);
		
		assertEquals(list,testClub.getBorrowers());
	
	}

	@Test
	public void testProcessQueuesNonEmptyQueue() {
		testClub.addBookToClub(testBook);
		testStaff1.borrowBook(testBook);
		testClub.processQueues();

		assertEquals("Should return true for queues to process", testBook.getNumberOfCopies(), 3);
	}

}
