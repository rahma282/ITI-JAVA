package library;
abstract public class LibraryItem {
    private int id;
    private String title;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    abstract String getItemDetails();
}
