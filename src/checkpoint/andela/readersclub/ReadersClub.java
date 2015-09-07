package checkpoint.andela.readersclub;

import java.util.ArrayList;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class ReadersClub {

	//private static HashMap<String, LinkedList<Object>> bookQueues = new HashMap<>();
	//private static ArrayList<Book> bookList = new ArrayList<>();
	private static BookList bookList = new BookList();
	private static BookQueues bookQueues = new BookQueues(bookList.getList());
	private QueueProcessor qProcessor;
	

	// no parameter constructor
	public ReadersClub() {
		qProcessor = new QueueProcessor(bookQueues);
	}

	// adds book to Club book list
	public boolean addBookToClub(Book book) {
		bookQueues.put(book);
		return bookList.add(book);
	}

	// add the member to the unique book queue

	public static boolean borrowBook(Member member, Book book) {
		return bookQueues.queueMember(member, book);

	}
	
	// process one book queue
	public boolean processQueue(Book book) {
		return qProcessor.processQueue(book);
	}

	// process all the book queues
	public boolean processQueues() {
		return qProcessor.processQueues();
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