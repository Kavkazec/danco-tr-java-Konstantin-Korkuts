import java.util.Arrays;

public class Library implements ILibrary{
	private Reader[] readers = new Reader[100];
	private Book[] books = new Book[100];
	
	
	public Reader[] getReaders() {
		return readers;
	}
	//b)Adds a new reader
	public void addReaders(Reader reader) {
		for(int i = 0; i < readers.length; i++ ){
			if(readers[i] == null){
				readers[i] = reader;
				return;
			}
		}
	}
	
	public Book[] getBooks() {
		return books;
	}
	//a)Lets you add a book to the library
	public void addBooksToLibrary(Book book) {
		for(int i = 0; i < books.length; i++ ){
			if(books[i] == null){
				books[i] = book;
				return;
			}
		}
	}
	//e)Lets look at some specific book reader
	public void  findReaderAndShow(Book book){
		Book[] arr = new Book[0];
		for(int i = 0; i < readers.length; i++ ){
			if(readers[i] != null){
				arr = Arrays.copyOf(readers[i].getBooksArr(), readers[i].getBooksArr().length);
				for(int j = 0; j < arr.length; j++ ){
					if(arr[j] != null && arr[j].equals(book)){
						System.out.println(readers[i].getName());
					}
				}
			}
		}
		
	}
	//g)It allows you to display a list of all readers
	public void showReaders(){
		for(int i = 0; i < readers.length; i++){
			if(readers[i] != null)
			System.out.println(readers[i].getName());
		}
	}
	//f)It allows you to display a list of all the books with a note of where they are
	public void findBooks(){
		Book[] arr = new Book[0];
		for(int i = 0; i < books.length; i++){
			for(int k = 0; k < readers.length; k++){
			if(books[i] != null &&readers[k] != null ){
				arr = Arrays.copyOf(readers[k].getBooksArr(), readers[k].getBooksArr().length);
				for(int j = 0; j < arr.length; j++ ){
					if(arr[j] != null && arr[j].equals(books[i])){
						System.out.println("The book " + books[i].getName() + " is at " + readers[k].getName() + "!");
						break;
					} else if(arr[j] != null && arr[j].equals(books[i]) == false)
						System.out.println("The book " + books[i].getName() + " at library!");
					
				}
			  }
			}
			
		}
	}

}
