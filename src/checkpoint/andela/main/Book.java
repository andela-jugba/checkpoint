package checkpoint.andela.main;

import java.util.UUID;

public class Book {
	private String bookName; // name of Book
	private String author; // name of book Author
	private int numberOfCopies; // number of copies of book
	private String isbnNumber; // ISBN number of book
	private String bookId; // Id tag for Book
	

	public Book(String bookName, String author, int numberOfCopies, String isbnNumber) {
		this.bookName = bookName;
		this.author = author;
		this.numberOfCopies = numberOfCopies;
		this.isbnNumber = isbnNumber;
	}
	
	

	public Book() {
		bookName = null;
		author = null;
		numberOfCopies = 0;
		isbnNumber = null;
	}
	
	public Book(String bookName, String author, String isbnNumber) {
		this.bookName = bookName;
		this.author = author;
		this.numberOfCopies = 1;
		this.isbnNumber = isbnNumber;
		
		generateBookId();
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
	
	private void generateBookId() {
		UUID num = UUID.randomUUID();
		bookId = num.toString();
	}

	public String getBookId() {
		return bookId;
	}



}
