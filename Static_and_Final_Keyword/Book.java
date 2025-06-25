package Static_and_Final_Keyword;

public class Book {
	//static variable
	static String libraryName="Santi Postakalaya";
	
	//instance variable 
	String title;
	String author;
	
	//final variable to ensure the unique identifier of a book and cannot be changed
	final String isbn;
	
	public Book(String title,String author,String isbn) {
		this.title=title;
		this.author=author;
		this.isbn=isbn;
	}
	
	//Method to display book details
	public void displayDetails(){
		if (this instanceof Book) {
			displayLibraryName();
			System.out.println("Title : "+title);
			System.out.println("Author : "+author);
			System.out.println("ISBN : "+isbn);
		}
		else {
			System.out.println("Invalid book instance.");
		}
	}
	
	//static method to display Name of the library
	public static void displayLibraryName() {
		System.out.println("Library Name : "+libraryName);
	}
	
	//main method for testing
	public static void main(String[] args) {
		Book book1=new Book("My life","Ansh","1567");
		Book book2=new Book("My Success","Ayan","1012");
		
		book1.displayDetails();
		book2.displayDetails();
	}
}
