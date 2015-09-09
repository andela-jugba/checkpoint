package checkpoint.andela.readersclub;

import java.util.ArrayList;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class ReadersClub {
	private static BookList bookList = new BookList();
	private static BookQueue bookQueue = new BookQueue();
	private  QueueProcessor queueProcessor; //= new QueueProcessor();

	// no parameter constructor
	public ReadersClub() {
		queueProcessor = new QueueProcessor();
	}

	// adds book to Club book list
	public boolean addBookToClub(Book book) {
		bookQueue.put(book);
		queueProcessor.addBookQueue(bookQueue);
		return bookList.add(book);
	}

	// add the member to the unique book queue
	public static boolean borrowBook(Member member, Book book) {
		return bookQueue.queueMember(member, book);
	}

	// process all the book queues
	public boolean processQueues() {
		return queueProcessor.processQueues();
	}

	// retrieves the book list
	public static ArrayList<Book> getBookList() {
		return bookList.getList();
	}

	// process returning of borrowed books by members
	public static boolean returnBook(Member member, Book book) {
		return bookList.returnBook(member, book);
	}

	// removes book from the book club record.
	public boolean removeBook(Book book) {
		return bookList.remove(book);
	}
}