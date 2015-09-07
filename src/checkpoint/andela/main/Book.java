package checkpoint.andela.main;

import java.util.ArrayList;

public class Book {
	private String bookName; // name of Book
	private String author; // name of book Author
	private int numberOfCopies; // number of copies of book
	private String isbnNumber; // ISBN number of book
	private ArrayList<Member> listOfBooksBorrowers;
	
	public Book(String bookName, String author, int numberOfCopies, String isbnNumber) {
		setBookName(bookName);
		setAuthor(author);
		setNumberOfCopies(numberOfCopies);
		setIsbnNumber(isbnNumber);
		this.listOfBooksBorrowers = new ArrayList<>();
	}
	
	

	public Book() {
		bookName = null;
		author = null;
		numberOfCopies = 0;
		isbnNumber = null;
		this.listOfBooksBorrowers = new ArrayList<>();
	}
	
	// set the Book name
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	// set the author of the book
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// set number of books
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	
	// set the ISBN number of the book
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	// retrieve the book name
	public String getBookName() {
		return bookName;
	}
	
	// retrieve the book author
	public String getAuthor() {
		return author;
	}
	
	// retrieve the number of book copy
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	
	//retrieve the ISBN number of the book
	public String getIsbnNumber() {
		return isbnNumber;
	}
	
	public ArrayList<Member> getListOfBooksBorrowers() {
		return listOfBooksBorrowers;
	}

}
