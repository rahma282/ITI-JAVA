import library.*;

public class LibraryManagement {
    public static void main(String[] args) {
        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book(2, "1984", "George Orwell");

        Magazine magazine1 = new Magazine(1, "National Geographic", 2024);
        Magazine magazine2 = new Magazine(2, "TIME", 2024);

        Client client1 = new Client(1, "Rahma Mostafa", "rahma.M@example.com");
        Client client2 = new Client(2, "Gohar", "gohar.G@example.com");

       
        Library<LibraryItem> library = new Library<>();
        MenuSystem menuSystem = new MenuSystem();

        // Add items to the library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);
        library.addItem(magazine2);

        
        menuSystem.getLibraryClients().add(client1);
        menuSystem.getLibraryClients().add(client2);

        
        menuSystem.getLibraryItems().add(library);

        menuSystem.DisplayMenuSystem();
    }
}
