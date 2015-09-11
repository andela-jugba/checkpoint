package checkpoint.andela.readersclub;

import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class ReadersClub {
	private static BookQueue bookQueue = new BookQueue();
	private static QueueProcessor queueProcessor; //= new QueueProcessor();

	// no parameter constructor
	public ReadersClub() {
		queueProcessor = new QueueProcessor();
	}

	// adds book to Club book list
	public void addBookToClub(Book book) {
		bookQueue.put(book);
		queueProcessor.addBookQueue(bookQueue);
	}

	// add the member to the unique book queue
	public static void borrowBook(Member member, Book book) {
		 bookQueue.queueMember(member, book);
	}

	// process all the book queues
	public void processQueues() {
		 queueProcessor.processQueues();
	}

	// process returning of borrowed books by members
	public static void returnBook(Member member, Book book) {
		 queueProcessor.returnBook(member, book);
	}

	
	public PriorityQueue<Member> getQueue() {
		return bookQueue.getMemberQueue();
	}
	public Book getBook() {
		return bookQueue.getBook();
	}
	
}
