package library;

public class Book extends LibraryItem{
    private String author;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }
    

    @Override
    String getItemDetails() {
        return "Book ID: " + getId() + ", Title: " + getTitle() + ", Author: " + author;
    }

}
