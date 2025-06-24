package Java_Consturctor;

public class Book{
	//instance variable with public, protected and private access modifiers
	public String ISBN;
	protected String title;
	private String author;
	
	//constructor
	public Book(String ISBN,String title,String author) {
		this.ISBN=ISBN;
		this.title=title;
		this.author=author;
	}
	
	//method to get author name
	public String getAuthor() {
		return this.author;
	}
	
	//method to set author name
	public void setAuthor(String Updated_AuthorName) {
		this.author=Updated_AuthorName;
	}
	public static void main(String[] args) {
		 // Creating an EBook instance
	     EBook book = new EBook("978-3-16-148410-0", "Learning Java", "Ansh Gaur");
	     // Displaying the details
	     book.displayEBookDetails();

	     // Updating the author name
	     book.setAuthor("Ayan");
	     System.out.println("After updating the author:");
	     book.displayEBookDetails();
	}
}
//subClass
class EBook extends Book{
	public EBook(String ISBN, String title, String author) {
		super(ISBN, title, author);
	}

	// Method to display eBook details
    public void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        // Accessing private author via public getter
        System.out.println("Author: " + getAuthor());
    }
}
