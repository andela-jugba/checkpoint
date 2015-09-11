package checkpoint.andela.readersclub;

import java.util.ArrayList;
import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class QueueProcessor {
	private ArrayList<BookQueue> bookQueues;

//	list of BookQueue
	
	public QueueProcessor() {
		bookQueues = new ArrayList<>();
	}

	private void processQueue(BookQueue bookQueue) {
		while (bookQueue.numberOfBookCopies() > 0) {
			if (bookQueue.isEmpty()) break;
			processMemberQueue(bookQueue);	
		}
			
	}

	// process the first one member on the queue
	private void processMemberQueue(BookQueue bookQueue) {
		if(bookQueue != null) {
		PriorityQueue<Member> memberQueue = bookQueue.getMemberQueue();
		Book book = bookQueue.getBook();	
		
		Member member = memberQueue.poll();
		
		bookQueue.addBorrower(member);
		book.borrow();
		System.out.println(book.getNumberOfCopies());
		}
	}

	// process all the book queues
	public void processQueues() {
		if (!bookQueues.isEmpty()) {
			for (BookQueue book : bookQueues) {
				processQueue(book);
			}
		} 
	}
	
	// add book queues
	public void addBookQueue(BookQueue bookQueue) {
		if(!bookQueues.contains(bookQueue)) {
			bookQueues.add(bookQueue);
		}
	}
	public void returnBook(Member member, Book book) {
		for(BookQueue bookQueue: bookQueues) {
			if (bookQueue.getBook() == book && bookQueue.containsBorrower(member)) {
				bookQueue.removeBorrower(member);
				bookQueue.getBook().receive();
			}
		}
	}

}
