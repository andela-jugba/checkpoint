package checkpoint.andela.readersclub;

import java.util.ArrayList;

import checkpoint.andela.main.Book;
import checkpoint.andela.main.Member;

public class BookList{
	private ArrayList<Book> list; // array-list of books

	// no argument constructor
	public BookList() {
		list = new ArrayList<>();
	}
	
	// add a book to the book list
	public boolean add(Book book) {
		//String bookTitle = book.getBookName();

		if (!list.contains(book)) {
			// Add books to Club
			//getBookQueues().put(bookTitle, bookQueue(book));
			getList().add(book);
			return true;
		} else {
			return false;
		}
	}

	// retrieve the list of all the books added
	public ArrayList<Book> getList() {
		return list;
	}
	
	// removes a book if present on the list
	public boolean remove(Book book) {
		if (getList().contains(book)) {
			getList().remove(book);
			return true;
		} else
			return false;
	}
	
	// process returning of borrowed books by members
	public boolean returnBook(Member member, Book book) {
		if (getList().contains(book) && book.getListOfBooksBorrowers().contains(member)) {
			book.getListOfBooksBorrowers().remove(member);
			book.setNumberOfCopies(book.getNumberOfCopies() + 1);
			member.getBookHolder().remove(book);
			return true;
		}
		return false;
	}
}
