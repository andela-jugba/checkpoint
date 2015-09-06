package checkpoint.andela.readersclub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;
import checkpoint.andela.members.Staff;

public class ReadersClub {

	private static HashMap<String, LinkedList<Object>> bookQueues;
	private static ArrayList<Book> bookList;
	
	public ReadersClub(){
		bookQueues = new HashMap<>();
		bookList = new ArrayList<>(); 
	}
	
	public boolean addBookToClub(Book book) {
		boolean bookStatus;
		String bookTitle =  book.getBookName();
		
		if (!bookList.contains(bookTitle)) {
		// Add books to Club
		bookQueues.put(bookTitle, bookQueue(book));
		bookList.add(book);
		bookStatus = true;
		}else {
			bookStatus = false;
		}
		
		return bookStatus;
	}
	
	// add the member to the unique book queue 
	public static boolean borrowBook(Member member, Book book) {
		//process members queue
		PriorityQueue<Member> pQueueStaff;
		PriorityQueue<Member> pQueueStudents;
		
		/* check that the book exists in the library
		 * if it does, add the member to the that book borrowing queue
		 * which is a hashMap of book name and 
		 * 
		 * */
		
		if(bookList.contains(book.getBookName())) {
			// queue book borrowing members
			if(member instanceof Staff) {
				pQueueStaff = (PriorityQueue<Member>) bookQueues.get(book.getBookName()).get(1);
				if(!pQueueStaff.contains(member)) pQueueStaff.offer(member);
				System.out.println(bookQueues.toString());
			}else {
				pQueueStudents = (PriorityQueue<Member>) bookQueues.get(book.getBookName()).getLast();
				if(!pQueueStudents.contains(member)) pQueueStudents.offer(member);
				System.out.println(bookQueues.toString());
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	// create a list containing the book title,staff queue and student queue
	private LinkedList<Object> bookQueue(Book book){
		LinkedList<Object> queue = new LinkedList<>();
		PriorityQueue<Member> pQueueStudent  = new PriorityQueue<>();
		PriorityQueue<Member> pQueueStaff = new PriorityQueue<>();
		
		queue.add((String) book.getBookName());
		queue.add(pQueueStaff);
		queue.add(pQueueStudent);
		return queue;
	}
	
	// process one book queue
	public void processQueue(Book book) {
		LinkedList<Object>queue = bookQueues.get(book.getBookName());
		PriorityQueue<Member> pQueueStaff = (PriorityQueue<Member>) queue.get(1);
		PriorityQueue<Member> pQueueStudent = (PriorityQueue<Member>) queue.get(2);
		
		int num = book.getNumberOfCopies()/(pQueueStaff.size() + pQueueStaff.size()) ;
		if(num > 0) {
			while(!pQueueStaff.isEmpty()) {
				Member staff = pQueueStaff.poll(); 
				staff.getBookHolder().add(book);
				book.getListOfBooksBorrowers().add(staff);
				book.setNumberOfCopies(book.getNumberOfCopies() -1);
				
			}
			while(!pQueueStudent.isEmpty()) {
				Member student = pQueueStudent.poll();
				student.getBookHolder().add(book);
				book.getListOfBooksBorrowers().add(student);
				book.setNumberOfCopies(book.getNumberOfCopies() -1);
			}
		}else {
			while(book.getNumberOfCopies() > 0) {
				//pQueue.poll().borrowBook(bookMap.get(bookName).removeLast());
				//System.out.println(bookMap.toString());
				if(!pQueueStaff.isEmpty()) {
					Member staff = pQueueStaff.poll();
					staff.getBookHolder().add(book);
					book.getListOfBooksBorrowers().add(staff);
					book.setNumberOfCopies(book.getNumberOfCopies() -1);
				}else {
					Member student = pQueueStudent.poll();
					student.getBookHolder().add(book);
					book.getListOfBooksBorrowers().add(student);
					book.setNumberOfCopies(book.getNumberOfCopies() -1);
				}
			}
		}
			
	}
	
	// process all the book queues
	public void processQueues() {
		for(Book book: bookList) {
			processQueue(book);
		}
	}
	
	
	public static boolean returnBook(Member member, Book book) {
		
		if(bookList.contains(book) && book.getListOfBooksBorrowers().contains(member)) {
			book.getListOfBooksBorrowers().remove(member);
			book.setNumberOfCopies(book.getNumberOfCopies() + 1);
			member.getBookHolder().remove(book);
			return true;
		}
		return false;
	}
}
