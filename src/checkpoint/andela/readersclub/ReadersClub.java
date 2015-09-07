package checkpoint.andela.readersclub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.members.Staff;
import checkpoint.andela.members.Student;

public class ReadersClub {

	private static HashMap<String, LinkedList<Object>> bookQueues = new HashMap<>();
	private static ArrayList<Book> bookList = new ArrayList<>();

	// no parameter constructor
	public ReadersClub() {
	}

	// adds book to Club book list
	public boolean addBookToClub(Book book) {
		String bookTitle = book.getBookName();

		if (!getBookList().contains(book)) {
			// Add books to Club
			getBookQueues().put(bookTitle, bookQueue(book));
			getBookList().add(book);
			return true;
		} else {
			return false;
		}
	}

	// add the member to the unique book queue

	public static boolean borrowBook(Member member, Book book) {
		// process members queue
		PriorityQueue<Member> pQueueStaff;
		PriorityQueue<Member> pQueueStudents;

		/*
		 * check that the book exists in the library if it does, add the member
		 * to the book borrowing queue which is a hashMap of book name and queues
		 * 
		 */

		if (getBookList().contains(book)) {
			// queue book borrowing members
			if (member instanceof Staff) {
				pQueueStaff = getMemberQueue(book, 1);
				if (!pQueueStaff.contains(member))
					pQueueStaff.offer(member);
				return true;
			} else if (member instanceof Student) {
				pQueueStudents = getMemberQueue(book, 2);
				if (!pQueueStudents.contains(member))
					pQueueStudents.offer(member);
				return true;
			}
		}
		return false;

	}
	
	@SuppressWarnings("unchecked")
	private static PriorityQueue<Member> getMemberQueue(Book book, int num){
		return (PriorityQueue<Member>) getBookQueues().get(book.getBookName()).get(num);
	}

	// create a list containing the book title,staff queue and student queue
	private LinkedList<Object> bookQueue(Book book) {
		LinkedList<Object> queue = new LinkedList<>();
		PriorityQueue<Member> pQueueStudent = new PriorityQueue<>();
		PriorityQueue<Member> pQueueStaff = new PriorityQueue<>();

		queue.add((String) book.getBookName());
		queue.add(pQueueStaff);
		queue.add(pQueueStudent);
		return queue;
	}

	// process one book queue
	public boolean processQueue(Book book) {
		int num;

		if (getBookQueues().containsKey(book.getBookName())) {

			LinkedList<Object> queue = getBookQueues().get(book.getBookName());
			@SuppressWarnings("unchecked")
			PriorityQueue<Member> pQueueStaff = (PriorityQueue<Member>) queue.get(1);
			@SuppressWarnings("unchecked")
			PriorityQueue<Member> pQueueStudent = (PriorityQueue<Member>) queue.get(2);

			//if (pQueueStaff.size() + pQueueStudent.size() == 0) {}
			//	return false;
			//else
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
		if (!getBookQueues().isEmpty()) {
			for (Book book : getBookList()) {
				processQueue(book);
			}
			return true;
		} else
			return false;
	}

	// retrieves the book list
	public static ArrayList<Book> getBookList() {
		return bookList;
	}
	
	// retrieves the book queue
	private static HashMap<String, LinkedList<Object>> getBookQueues() {
		return bookQueues;
	}

	// process returning of borrowed books by members
	public static boolean returnBook(Member member, Book book) {
		if (getBookList().contains(book) && book.getListOfBooksBorrowers().contains(member)) {
			book.getListOfBooksBorrowers().remove(member);
			book.setNumberOfCopies(book.getNumberOfCopies() + 1);
			member.getBookHolder().remove(book);
			return true;
		}
		return false;
	}

	// removes book from the book club record.
	public boolean removeBook(Book book) {
		if (getBookList().contains(book)) {
			getBookList().remove(book);
			return true;
		} else
			return false;
	}
}