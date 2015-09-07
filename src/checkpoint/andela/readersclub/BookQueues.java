package checkpoint.andela.readersclub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

public class BookQueues {

	private HashMap<String, LinkedList<PriorityQueue<Member>>> bookQueues;
	private ArrayList<Book> list;
	
	public BookQueues(ArrayList<Book> list) {
		bookQueues = new HashMap<>();
		this.list = list;
	}
	
	public boolean put(Book book) {
		if(!list.contains(book)) {
			bookQueues.put(book.getBookName(), bookQueue(book));
			return true;
		}else return false;
		
	}
	
	// create a list containing the book title,staff queue and student queue
	private LinkedList<PriorityQueue<Member>> bookQueue(Book book) {
		LinkedList<PriorityQueue<Member>> queue = new LinkedList<>();
		PriorityQueue<Member> pQueueStudent = new PriorityQueue<>();
		PriorityQueue<Member> pQueueStaff = new PriorityQueue<>();

		//queue.add((String) book.getBookName());
		queue.add(pQueueStaff);
		queue.add(pQueueStudent);
		return queue;
	}

	public HashMap<String, LinkedList<PriorityQueue<Member>>> getBookQueues() {
		return bookQueues;
	}

	public ArrayList<Book> getList() {
		return list;
	}

	// add the member to the unique book queue

		public  boolean queueMember(Member member, Book book) {
			// process members queue
			PriorityQueue<Member> pQueueStaff;
			PriorityQueue<Member> pQueueStudents;

			/*
			 * check that the book exists in the library if it does, add the member
			 * to the book borrowing queue which is a hashMap of book name and queues
			 * 
			 */

			if (getList().contains(book)) {
				// queue book borrowing members
				if (member instanceof Staff) {
					pQueueStaff = getMemberQueue(book, 0);
					if (!pQueueStaff.contains(member))
						pQueueStaff.offer(member);
					return true;
				} else if (member instanceof Student) {
					pQueueStudents = getMemberQueue(book, 1);
					if (!pQueueStudents.contains(member))
						pQueueStudents.offer(member);
					return true;
				}
			}
			return false;

		}
	
		
	private PriorityQueue<Member> getMemberQueue(Book book, int num){
		return bookQueues.get(book.getBookName()).get(num);
	}
}
