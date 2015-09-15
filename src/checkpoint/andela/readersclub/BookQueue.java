package checkpoint.andela.readersclub;



import java.util.ArrayList;
import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class BookQueue {
	private Book book;
	private PriorityQueue<Member> memberQueue;
	private ArrayList<Member> bookBorrowers;

	public BookQueue() {
		memberQueue = new PriorityQueue<>();
		bookBorrowers = new ArrayList<>();
	}

	public void put(Book book) {
		if (book != null) {
			this.book = book;		
		}
	}
	
	public void queueMember(Member member, Book book) {
		
		if (this.book == book) {
			// queue book borrowing members
			if(!memberQueue.contains(member))memberQueue.offer(member);
		}
	}

	public PriorityQueue<Member> getMemberQueue() {
		return memberQueue;
	}

	public Book getBook() {
		return book;
	}
	
	//add member to list of borrowers
	private void addBorrower(Member member) {
		bookBorrowers.add(member);
	}
	public void removeBorrower(Member member) {
		bookBorrowers.remove(member);
	}
	public int numberOfBookCopies() {
		return book.getNumberOfCopies();
	}
	public boolean isEmpty() {
		return memberQueue.isEmpty();
	}
	public boolean containsBorrower(Member member) {
		return bookBorrowers.contains(member);
	}
	
	private void borrow() {
		book.borrow();
	}
	
	public void receive() {
		book.receive();
	}
	
	public void poll() {
		addBorrower(memberQueue.poll());
		borrow();
	}

	public ArrayList<Member> getBorrowers() {
		return bookBorrowers;
	}
}

