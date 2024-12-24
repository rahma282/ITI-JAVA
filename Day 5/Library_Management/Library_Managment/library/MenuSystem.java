package library;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSystem {
    private ArrayList<Library<LibraryItem>> libraryItems;
    private ArrayList<Client> libraryClients;
    private static Scanner scan = new Scanner(System.in);

    public MenuSystem() {
        libraryItems = new ArrayList<>();
        libraryClients = new ArrayList<>();
    }

    public ArrayList<Library<LibraryItem>> getLibraryItems() {
        return libraryItems;
    }

    public ArrayList<Client> getLibraryClients() {
        return libraryClients;
    }

    public void DisplayMenuSystem() {
        int choice = 0;
        do {
            System.out.println("---------- Welcome to Library Management System^-^ ----------");
            System.out.println("1. Manage Library Items");
            System.out.println("2. Manage Library Clients");
            System.out.println("3. Exit");

            try {
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
                scan.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("You must input numbers, not strings");
                scan.nextLine(); // Clear invalid choice
            }

            switch (choice) {
                case 1:
                    manageLibraryItems();     
                    break;
                case 2:
                    manageLibraryClients();
                    break;
                case 3:
                    System.out.println("Exiting program... See you again");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);
    }

    private void manageLibraryItems() {
        while (true) {
            System.out.println("\n-------- Manage Library Items --------");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Remove Item");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    addLibraryItem();
                    break;
                case 2:
                    retrieveItems();
                    break;
                case 3:
                    removeLibraryItem();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void manageLibraryClients() {
        while (true) {
            System.out.println("\n--------- Manage Library Clients ---------");
            System.out.println("1. Add Client");
            System.out.println("2. View Clients");
            System.out.println("3. Remove Client");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    addLibraryClient();
                    break;
                case 2:
                    viewLibraryClients();
                    break;
                case 3:
                    removeLibraryClient();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void addLibraryItem() {
        System.out.println("Enter Item Type (1 for Book, 2 for Magazine): ");
        int itemType = scan.nextInt();
        scan.nextLine();  

        System.out.print("Enter Item ID: ");
        int id = scan.nextInt();
        scan.nextLine();  

        System.out.print("Enter Item Title: ");
        String title = scan.nextLine();

        switch (itemType) {
            case 1:
                System.out.print("Enter Author: ");
                String author = scan.nextLine();
                Book book = new Book(id, title, author);
                if (libraryItems.isEmpty()) {
                    System.out.println("No libraries available. Adding a new library.");
                    Library<LibraryItem> newLibrary = new Library<>();
                    libraryItems.add(newLibrary);
                }   libraryItems.get(0).addItem(book);
                break;
            case 2:
                System.out.print("Enter Issue Number: ");
                int issueNumber = scan.nextInt();
                Magazine magazine = new Magazine(id, title, issueNumber);
                if (libraryItems.isEmpty()) {
                    System.out.println("No libraries available. Adding a new library.");
                    Library<LibraryItem> newLibrary = new Library<>();
                    libraryItems.add(newLibrary);
                }   libraryItems.get(0).addItem(magazine);
                break;
            default:
                System.out.println("Invalid Item Type");
                break;
        }
    }

    private void retrieveItems() {
        if (libraryItems.isEmpty()) {
            System.out.println("No items available.");
        } else {
            for (Library<LibraryItem> library : libraryItems) {
                library.displayItems();
            }
        }
    }

    private void removeLibraryItem() {
        System.out.print("Enter the ID of the item to remove: ");
        int id = scan.nextInt();
        scan.nextLine();  

        try {
            for (Library<LibraryItem> library : libraryItems) {
                library.removeItemById(id); 
                System.out.println("Item removed.");
                return;
            }
        } catch (ItemNotFoundException e) {
            System.out.println("Item not found: " + e.getMessage());
        }
    }

    private void addLibraryClient() {
        System.out.print("Enter Client ID: ");
        int id = scan.nextInt();
        scan.nextLine();  

        System.out.print("Enter Client Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Client Email: ");
        String email = scan.nextLine();

        Client client = new Client(id, name, email);
        libraryClients.add(client);
    }

    private void viewLibraryClients() {
        if (libraryClients.isEmpty()) {
            System.out.println("No clients available.");
        } else {
            for (Client client : libraryClients) {
                System.out.println(client.getClientDetails());
            }
        }
    }

    private void removeLibraryClient() {
        System.out.println("Enter the ID of the client to remove: ");
        int id = scan.nextInt();
        scan.nextLine();  

        boolean found = false;
        for (Client client : libraryClients) {
            if (client.getId() == id) {
                libraryClients.remove(client);
                System.out.println("Client removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Client not found.");
        }
    }
}
