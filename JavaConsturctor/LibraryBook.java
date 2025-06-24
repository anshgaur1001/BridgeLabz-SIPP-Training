package Java_Consturctor;
public class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public LibraryBook(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void display() {
        System.out.println(title + " by " + author + ", Price: $" + price + ", Available: " + isAvailable);
    }
    public static void main(String[] args) {
    	// LibraryBook
        LibraryBook libBook = new LibraryBook("The Alchemist", "Paulo Coelho", 12.99, true);
        libBook.display();
        libBook.borrow();
        libBook.borrow();
    }
}
