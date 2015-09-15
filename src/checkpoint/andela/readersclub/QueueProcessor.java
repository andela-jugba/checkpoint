package checkpoint.andela.readersclub;

import java.util.ArrayList;

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
			bookQueue.poll();
		}
	}

	// process all the book queues
	public void processQueues() {
		if (!bookQueues.isEmpty()) {
			for (BookQueue bookQueue : bookQueues) {
				processQueue(bookQueue);
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
				bookQueue.receive();
			}
		}
	}

}
