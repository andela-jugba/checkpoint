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

	private void processQueue(BookQueue book) {
		int num;			
			num = book.getBook().getNumberOfCopies()/book.getMemberQueue().size();

			if (num > 0) {
				while(!book.getMemberQueue().isEmpty()) {
					processMemberQueue(book.getMemberQueue(), book.getBook());
				}
			} else{
				while (book.getBook().getNumberOfCopies() > 0) {
						processMemberQueue(book.getMemberQueue(), book.getBook());
				}
			}
	}

	// process the first one member on the queue
	private void processMemberQueue(PriorityQueue<Member> pQueueMember, Book book) {
		Member member = pQueueMember.poll();
		member.getBookHolder().add(book);
		book.getListOfBooksBorrowers().add(member);
		book.setNumberOfCopies(book.getNumberOfCopies() - 1);
	}

	// process all the book queues
	public boolean processQueues() {
		if (!bookQueues.isEmpty()) {
			for (BookQueue book : bookQueues) {
				processQueue(book);
			}
			return true;
		} else
			return false;
	}
	
	// add book queues
	public boolean addBookQueue(BookQueue bookQueue) {
		if(!bookQueues.contains(bookQueue)) {
			bookQueues.add(bookQueue);
			return true;
		}
		return false;
	}

}
