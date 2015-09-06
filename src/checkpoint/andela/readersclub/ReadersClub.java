package checkpoint.andela.readersclub;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class ReadersClub {

private HashMap<String,LinkedList<Book>> bookMap; //Hash map to hold book title and book stack
	
	public ReadersClub(){
		bookMap = new HashMap<>();
	}

	public void addBook(Book book) {
		String title = book.getBookName();
		int numberOfCopies = book.getNumberOfCopies();
		LinkedList<Book> record = new LinkedList<>();
		
		for (int i = 0; i < numberOfCopies; i++) {
			record.push(new Book(book.getBookName(),book.getAuthor(),book.getIsbnNumber()));
		}
		
		bookMap.put(title, record);
		System.out.println(bookMap.toString());
	}
	
	// method to borrow books
	public void borrowBook(PriorityQueue<Member> pQueue, Book book) {
		String bookName = book.getBookName();
		if(bookMap.containsKey(bookName)) {
//			do {
//				
//				if(bookMap.get(bookName).size() == 0 || pQueue.size() == 0) break;
//				pQueue.poll().borrowBook(bookMap.get(bookName).removeLast());
//				System.out.println(bookMap.toString());
//			}
//			while(bookMap.get(bookName).peek() != null);
			
			int num = bookMap.get(bookName).size()/pQueue.size();
			if(num > 0) {
				while(!pQueue.isEmpty()) {
					pQueue.poll().borrowBook(bookMap.get(bookName).removeLast());
					//System.out.println(bookMap.toString());
				}
			}else {
				while(!bookMap.get(bookName).isEmpty()) {
					pQueue.poll().borrowBook(bookMap.get(bookName).removeLast());
					//System.out.println(bookMap.toString());
				}
			}
			
		}else throw new IllegalArgumentException ("Book must exist in the Club!");
	}
	
	public void returnBook(Member staff) {
		Book book = staff.returnBook();
		String title = book.getBookName();
		System.out.println(book.toString());
		System.out.println(title);
		
		if (bookMap.containsKey(title) && book.getBookId() != null) {
		bookMap.get(title).add(book);
		System.out.println(bookMap.toString() + "This should increase");
		}else throw new IllegalArgumentException("You can only return books borrowed from the club");
	}
	public void listAllBooks() {
		System.out.println("The Library has the following books: ");
		for(LinkedList<Book>list: bookMap.values()) {
			for(Book book: list) {
				System.out.println("Book Title: "+ book.getAuthor() + " Book ISBN " + book.getIsbnNumber());
			}
		}
	}
}
