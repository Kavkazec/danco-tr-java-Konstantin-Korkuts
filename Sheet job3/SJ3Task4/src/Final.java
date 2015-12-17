
public class Final {

	public static void main(String[] args) {
		Library lb = new Library();
		
		Reader r1 = new Reader("Vasya");
		Reader r2 = new Reader("Kolya");
		lb.addReaders(r1);
		lb.addReaders(r2);
		
		Book b1 = new Book();
		b1.setName("Var");
		Book b2 = new Book();
		b2.setName("Garden");
		Book b3 = new Book();
		b3.setName("Darkness");
		Book b4 = new Book();
		b4.setName("Konstantin");
		lb.addBooksToLibrary(b1);
		lb.addBooksToLibrary(b2);
		lb.addBooksToLibrary(b3);
		lb.addBooksToLibrary(b4);
		
		r1.addBooksToReader(b1);
		r1.addBooksToReader(b2);
		r2.addBooksToReader(b3);
		r1.unsubscribeBook(b2);
		
		r1.showBooks();
		r2.showBooks();
		
		System.out.println("------------------");
		lb.findReaderAndShow(b3);
		System.out.println("------------------");
		lb.showReaders();
		System.out.println("------------------");
		lb.findBooks();
		
		
	}

}
