
public class Library {
	Reader[] readers = new Reader[5];
	Book[] books = new Book[10];
	String[] mass = new String[100];
	int i = -1;
	int x = -1;
	int s = -1;
	String name;
	//b) A method that adds readers
	void addReader(Reader reader){
		i++;
		if(i < readers.length){
			readers[i] = reader;
		}else System.out.println("Filled with an array of readers!");
	}
	//g) A method that allows you to list all the readers
	void showReaders(){
		for(int k = 0; k < readers.length; k++){
			if(readers[k] != null){
			name = readers[k].getName();
			System.out.println(name);
			}
		}
	}
	//a) A method that adds books
	void addBookToLibrary(Book book){
		x++;
		if(x < books.length){
			books[x] = book;
		}else System.out.println("Filled with an array of books!");
	}
	//c)A method that allows you to upload the book to the reader
	void recordBook(Reader reader, Book book){
		s++;
		if(s < mass.length){
			mass[s] = reader.getName()+":"+ book.getName();
		}else System.out.println("Filled with an array of books!");
	}
	//d) A method that allows you to see what a particular book reader
	void show(Reader reader){
		for(int k = 0; k < mass.length; k++){
			if(mass[k] != null && mass[k].startsWith(reader.getName())){
			name = mass[k];
			System.out.println(name);
			}
		}
	}
	//c)A method that allows you to sign the book to the reader
	void unsubscribeBook(Reader reader, Book book){
		for(int k = 0; k < mass.length; k++){
			if(mass[k] != null && mass[k].equals(reader.getName()+":"+book.getName())){
				mass[k] = null;
				System.out.println("Usubscribe | "+reader.getName()+":"+book.getName());
			}
		}
	}
	//e)A method that allows the reader to look at a particular book
	void show(Book book){
		for(int k = 0; k < mass.length; k++){
			if(mass[k] != null && mass[k].endsWith(book.getName())){
			name = mass[k];
			System.out.println(name);
			}
		}
	}
	//f)A method that allows you to see a list of all the books with a note of where they are
	void show(){
		for(int k = 0; k < mass.length; k++){
			if(mass[k] != null){
			name =mass[k];
			System.out.println(name);
			}
		}
	}

}

