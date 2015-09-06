package checkpoint.andela.main;

import java.util.LinkedList;

public class BookHolder{
	//private ArrayList<Book> list;
	private LinkedList<Book> list;

	public BookHolder() {
		//list = new ArrayList<>();
		list = new LinkedList<>();
	}
	
	public void add(Book book) {
		if (book != null) {
			//if (book.getNumberOfCopies() >= 1)list.add(book);
			list.push(book);
			}else throw new IllegalArgumentException("Cannot add null book to bookHolder");
	}
	
	public Book remove(Book book) {
		int id = list.indexOf(book);
		//if(id >= 0) return list.remove(id); 
		
		if(list.contains(book)) {return list.remove(id);}
		else return null;
	}
	public Book pop() {
		if(list.size() > 0)return list.pop();
		else return null;
	}
	public Book peek() {
		return list.peek();
	}

	public int numberOfBooks() {
		return list.size();
	}
	
	
}
