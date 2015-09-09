package checkpoint.andela.readersclub;



import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class BookQueue {
	private Book book;
	private PriorityQueue<Member> memberQueue;

	public BookQueue() {
		memberQueue = new PriorityQueue<>();
	}

	public void put(Book book) {
		if (book != null) {
			this.book = book;		
		}
	}
	
	public boolean queueMember(Member member, Book book) {
		
		if (this.book == book) {
			// queue book borrowing members
			if(!memberQueue.contains(member))memberQueue.offer(member);
			return true;
		}
		return false;
	}

	public PriorityQueue<Member> getMemberQueue() {
		return memberQueue;
	}

	public Book getBook() {
		return book;
	}
}
