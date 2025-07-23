package marketplace;

public class BookCategory implements Category {
    private String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }

    @Override
    public String getCategoryName() {
        return "Book - " + genre;
    }
}
