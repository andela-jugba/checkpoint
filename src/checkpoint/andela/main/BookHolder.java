package checkpoint.andela.main;

import java.util.ArrayList;

public class BookHolder{
	private ArrayList<Book> list;

	public BookHolder() {
		list = new ArrayList<>();
	}
	
	public void add(Book book) {
		if (book != null) {
			if (book.getNumberOfCopies() >= 1)list.add(book);
			};
	}
	
	public Book remove(Book book) {
		int id = list.indexOf(book);
		if(id >= 0) return list.remove(id); 
		else return null;
	}
	
}
