
public class Reader implements IReader {
	private String name;
	private Book[] books = new Book[10];
	public Reader(String name){
		this.name = name;
	}
	
	public Book[] getBooksArr() {
		return books;
	}
	//c)It allows you to write a book on the reader
	public void addBooksToReader(Book book) {
		for(int i = 0; i < books.length; i++ ){
			if(books[i] == null){
				books[i] = book;
				return;
			}
		}
	}
	//c)It allows the book to the reader to unsubscribe
	public void unsubscribeBook(Book book){
		for(int i = 0; i < books.length; i++ ){
			if(books[i] != null && books[i] == book){
				books[i] = null;
				return;
			}
		}
	}
	
	public String getName() {
		return name;
	}
	//d)Lets see what the book in the hands of the reader
	public void showBooks(){
		for(int i = 0; i < books.length; i++){
			if(books[i] != null)
			System.out.println(this.name +" : " + books[i].getName());
		}
	}
}
