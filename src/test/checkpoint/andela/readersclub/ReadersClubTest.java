package test.checkpoint.andela.readersclub;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import checkpoint.andela.main.Book;
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
	private Book bk;

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
	}

	@After
	public void tearDown() throws Exception {
		ReadersClub.getBookList().clear();
	}

	@Test
	public void testReadersClub() {
		assertNotNull("ReadersClub class should exist", testClub);
	}

	@Test
	public void testAddBookToClub() {
		assertTrue(testClub.addBookToClub(testBook2));
		assertFalse(testClub.addBookToClub(testBook2));
		assertTrue(testClub.removeBook(testBook2));
		assertFalse(testClub.addBookToClub(bk));
	}

	@Test
	public void testRemoveBookNotInClub() {
		assertFalse("Should be false if book not in club", testClub.removeBook(testBook2));
	}

	@Test
	public void testRemoveBookInClub() {
		testClub.addBookToClub(testBook);
		assertTrue("Should be true if book is in club", testClub.removeBook(testBook));
	}

	@Test
	public void testBorrowBookNotInClub() {
		assertFalse(testStaff1.borrowBook(testBook));
	}

	@Test
	public void testBorrowBookInClub() {
		testClub.addBookToClub(testBook);
		assertTrue(testStaff1.borrowBook(testBook));
		assertTrue(testStudent1.borrowBook(testBook));
	}

	@Test
	public void testReturnBookNotInClub() {
		assertFalse(testStaff1.returnBook(testBook));
	}

	@Test
	public void testReturnBookAndBookBorrowedFromClub() {
		Book book = new Book("String", "author", 4, "dfdfdfg");
		testClub.addBookToClub(book);
		testStaff1.borrowBook(book);

		// process queue so the member gets the book before returning it
		testClub.processQueues();

		assertTrue(testStaff1.returnBook(book));
	}

	@Test
	public void testProcessQueueEmptyQueue() {
		assertFalse("There should be no queue to process for this book", testClub.processQueues());
	}

	@Test
	public void testProcessQueueNonEmptyQueue() {
		testClub.addBookToClub(testBook);
		testStudent1.borrowBook(testBook);
		assertTrue("Should process the existing queue", testClub.processQueues());
	}

	@Test
	public void testProcessQueueWithMoreBorrowersThanBooks() {
		Book book = new Book("hdfjfh", "kn",3, "ffs");
		testClub.addBookToClub(book);
		testStaff1.borrowBook(book);
		testStaff2.borrowBook(book);
		testStaff1.borrowBook(book);
		testStudent1.borrowBook(book);
		testStudent2.borrowBook(book);

		testClub.processQueues();
//		System.out.println("The first: "+book.getListOfBooksBorrowers().get(0).getFullName());
//		System.out.println("The second: "+book.getListOfBooksBorrowers().get(1).getFullName());
//		System.out.println("The third: "+book.getListOfBooksBorrowers().get(2).getFullName());
//	//System.out.println("The fourth: "+book.getListOfBooksBorrowers().get(3).getFullName());

	}

	@Test
	public void testProcessQueuesEmptyQueue() {
		testClub.processQueues();
		assertFalse("Should return false if queues equals zero", testClub.processQueues());
	}

	@Test
	public void testProcessQueuesNonEmptyQueue() {
		testClub.addBookToClub(testBook);
		testStaff1.borrowBook(testBook);

		assertTrue("Should return true for queues to process", testClub.processQueues());
	}

}
