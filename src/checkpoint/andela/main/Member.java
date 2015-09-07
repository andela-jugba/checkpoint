package checkpoint.andela.main;

import java.util.Date;

import checkpoint.andela.readersclub.ReadersClub;

//Member class create to serve as superclass for students and staff class

public class Member implements Comparable<Member> {
	private String fullName; // full name of this member
	private char gender; // gender of this member
	private String dateOfbirth; // date of birth of this member
	private String email; // email of this member
	private String phoneNumber;
	private Date dateOfRegistration;
	private BookHolder bookHolder;

	// four-argument constructor
	public Member(String fullName, char g, String dateOfbirth, String phoneNumber) {
		this.fullName = fullName;
		this.gender = g;
		this.dateOfbirth = dateOfbirth;
		this.phoneNumber = phoneNumber;

		setDateOfRegistration();
		bookHolder = new BookHolder();
	}

	public Member() {
		fullName = null;
		gender = 'N';
		dateOfbirth = null;
		email = null;
		phoneNumber = null;

		setDateOfRegistration();
		bookHolder = new BookHolder();
	}

	// set the full name of the member
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	// set the gender
	public void setGender(char g) {

		gender = g;
	}

	// set date of birth
	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	// set email
	public void setEmail(String email) {
		this.email = email;
	}

	// set phone number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// set
	public void setDateOfRegistration() {
		this.dateOfRegistration = new Date();
	}

	// set full name
	public String getFullName() {
		return fullName;
	}

	// set gender
	public Character getGender() {
		return gender;
	}

	// set date of birth
	public String getDateOfbirth() {
		return dateOfbirth;
	}

	// retrieve email
	public String getEmail() {
		return email;
	}

	// retrieve the phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}

	// retrieve the date
	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	// borrow book
	public boolean borrowBook(Book book) {
		return ReadersClub.borrowBook(this, book);
	}

	// return specific book
	public boolean returnBook(Book book) {
		return ReadersClub.returnBook(this, book);
	}

	public int getNumberOfBooksBorrowed() {
		return bookHolder.numberOfBooks();
	}

	// compares members by date of registration
	public int compareTo(Member member) {
		if (getDateOfRegistration().before(member.getDateOfRegistration())) {
			return 1;
		}
		if (getDateOfRegistration().after(member.getDateOfRegistration())) {
			return -1;
		}
		return 0;
	}

	public BookHolder getBookHolder() {
		return bookHolder;
	}
}
