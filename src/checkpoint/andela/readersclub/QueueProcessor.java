package checkpoint.andela.readersclub;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class QueueProcessor {
	private HashMap<String, LinkedList<PriorityQueue<Member>>> bookQueues;
	private BookQueues bQueues;
	public QueueProcessor(BookQueues bQueues) {
		this.bookQueues = bQueues.getBookQueues();
		this.bQueues = bQueues; 
	}
	
	public boolean processQueue(Book book) {
		int num;

		if (bookQueues.containsKey(book.getBookName())) {

			LinkedList<PriorityQueue<Member>> queue = bookQueues.get(book.getBookName());
		
			PriorityQueue<Member> pQueueStaff = queue.get(0);
			
			PriorityQueue<Member> pQueueStudent = queue.get(1);

				num = book.getNumberOfCopies() / (pQueueStaff.size() + pQueueStudent.size());
			
			// Depending on if there are more copies or borrowers
			// If there are more copies than borrowers, num > 0
			if (num > 0) {
				while (!pQueueStaff.isEmpty()) {
					//processStaffQueue(pQueueStaff, book);
					processMemberQueue(pQueueStaff, book);
				}
				while (!pQueueStudent.isEmpty()) {
					//processStudentQueue(pQueueStudent, book);
					processMemberQueue(pQueueStudent, book);
				}
			} else { // here number of copies less than borrower hence first come first serve based on priority
				while (book.getNumberOfCopies() > 0) {
					if (!pQueueStaff.isEmpty()) {
						processMemberQueue(pQueueStaff, book);
					} else {
						processMemberQueue(pQueueStudent, book);
					}
				}
			}
			return true;
		} else {
			return false;
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
			for (Book book : bQueues.getList()) {
				processQueue(book);
			}
			return true;
		} else
			return false;
	}


}
