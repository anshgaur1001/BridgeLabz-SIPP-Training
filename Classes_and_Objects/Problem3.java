package Classes_and_Objects;
class Book{
	String title,author;
	int price;
	public Book(String title, String author, int price) {
		this.title= title;
		this.author=author;
		this.price= price;
	}
	public void details() {
		System.out.println("Title of the book: "+title);
		System.out.println("Author of the book: "+author);
		System.out.println("Price of the book: "+price);
	}
}
public class Problem3 {
	public static void main(String[] args) {
		Book book1= new Book("My life","Deepanshu",500);
		Book book2= new Book("Your life","Ansh",700);
		Book book3= new Book("Our life","Harsh",600);
		book1.details();
		book2.details();
		book3.details();
		
	}
}

