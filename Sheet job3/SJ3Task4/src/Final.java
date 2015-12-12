
public class Final {

	public static void main(String[] args) {
		Reader r1 = new Reader("Vasya");
		Reader r2 = new Reader("kolya");
		Book b1 = new Book("To nobody","Kupala");
		Book b2 = new Book("In winter","Kupala");
		Book b3 = new Book("Pavlinka","Kupala");
		Library lb = new Library();
		lb.addReader(r1);
		lb.addReader(r2);
		lb.addBookToLibrary(b1);
		lb.addBookToLibrary(b2);
		lb.addBookToLibrary(b3);
		lb.showReaders();
		System.out.println("-----------");
		lb.recordBook(r1, b1);
		lb.recordBook(r1, b2);
		lb.recordBook(r2, b3);
		lb.show();
		System.out.println("-----------");
		lb.show(r1);
		System.out.println("-----------");
		lb.show(b3);
		System.out.println("-----------");
		lb.unsubscribeBook(r1, b1);
		System.out.println("-----------");
		lb.show();

	}

}
