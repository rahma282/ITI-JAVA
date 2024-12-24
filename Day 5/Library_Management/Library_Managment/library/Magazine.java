package library;

public class Magazine extends LibraryItem{
    private int issueNumber;
    public Magazine(int id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    @Override
    String getItemDetails() {
        return "Magazine ID: " + getId() + ", Title: " + getTitle() + ", IssueNumber: " + issueNumber;
    }
    
}
