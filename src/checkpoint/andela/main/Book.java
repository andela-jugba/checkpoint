package checkpoint.andela.main;


public class Book {
	private String bookName; // name of Book
	private String author; // name of book Author
	private int numberOfCopies; // number of copies of book
	private String isbnNumber; // ISBN number of book
	
	// four arguments constructor
	public Book(String bookName, String author, int numberOfCopies, String isbnNumber) {
		setBookName(bookName);
		setAuthor(author);
		setNumberOfCopies(numberOfCopies);
		setIsbnNumber(isbnNumber);
	}
	
	// Default constructor
	public Book() {
		bookName = null;
		author = null;
		numberOfCopies = 1;
		isbnNumber = null;
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
	
	public void borrow() {
		numberOfCopies--;
	}
	public void receive() {
		numberOfCopies++;
	}
}
