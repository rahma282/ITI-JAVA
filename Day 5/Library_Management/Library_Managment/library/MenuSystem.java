package library;

import java.util.ArrayList;
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
        int choice=0;
        do {
            System.out.println("---------- Welcome to Library Management System^-^ ----------");
            System.out.println("1. Manage Library Items");
            System.out.println("2. Manage Library Clients");
            System.out.println("3. Exit");

            String input = scan.nextLine().trim(); 

            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please enter a valid number.");
                continue;
            }
    
            
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                continue;
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
                throw new IllegalArgumentException("Invalid Item Type");
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
                throw new IllegalArgumentException("Invalid Item Type");
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
                throw new IllegalArgumentException("Invalid Item Type");
            }
        }
    }

    private void addLibraryItem() throws NumberFormatException {
        boolean validInput = false;  //check if the input is valid
        
        while (!validInput) {
            try {
                System.out.println("Enter Item Type: \n1.for Book \n2.for Magazine ");
                int itemType = scan.nextInt();
                scan.nextLine();  
                if (itemType != 1 && itemType != 2) {
                    throw new IllegalArgumentException("Error: Invalid item type. Enter 1 for Book or 2 for Magazine.");
                }
                System.out.print("Enter Item ID: ");
                String idInput = scan.nextLine();  
                if (!idInput.matches("\\d+")) {
                throw new IllegalArgumentException("Error: Item ID must be a numeric value.");
                }
                int id = Integer.parseInt(idInput);  
                if (id <= 0) {
                    throw new IllegalArgumentException("Error: Item ID must be a positive integer.");
                }
    
                if (!isItemIdUnique(id)) {
                    throw new IllegalArgumentException("Error: Item ID must be unique.");
                }
    
                System.out.print("Enter Item Title: ");
                String title = scan.nextLine();
                if (title == null || title.isEmpty()) {
                    throw new IllegalArgumentException("Error: Title cannot be empty.");
                }
    
                switch (itemType) {
                    case 1:
                        System.out.print("Enter Author: ");
                        String author = scan.nextLine();
                        Book book = new Book(id, title, author);
                        if (libraryItems.isEmpty()) {
                            System.out.println("No libraries available. Adding a new library.");
                            Library<LibraryItem> newLibrary = new Library<>();
                            libraryItems.add(newLibrary);
                        }
                        libraryItems.get(0).addItem(book);
                        validInput = true; // Exit the loop 
                        break;
                    case 2:
                        System.out.print("Enter Issue Number: ");
                        String issueNumberInput = scan.nextLine().trim();
                        if (issueNumberInput.isEmpty()) {
                            throw new IllegalArgumentException("Error: Issue Number cannot be empty.");
                        }
    
                        try {
                            int issueNumber = Integer.parseInt(issueNumberInput);
                            Magazine magazine = new Magazine(id, title, issueNumber);
                            if (libraryItems.isEmpty()) {
                                System.out.println("No libraries available. Adding a new library.");
                                Library<LibraryItem> newLibrary = new Library<>();
                                libraryItems.add(newLibrary);
                            }
                            libraryItems.get(0).addItem(magazine);
                            validInput = true; 
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid Issue Number. Please enter a valid integer.");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Item Type");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again.");
            }
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
        while (true) {
            try {
                System.out.print("Enter the ID of the item to remove: ");
                int id = scan.nextInt();
                scan.nextLine();  
    
                boolean itemFound = false;
                for (Library<LibraryItem> library : libraryItems) {
                    try {
                        library.removeItemById(id);
                        System.out.println("Item removed.");
                        itemFound = true;  //found and removed
                        break;
                    } catch (ItemNotFoundException ignored) {
                        
                    }
                }
                if (!itemFound) {
                    throw new ItemNotFoundException();
                }
                break;  
            } catch (ItemNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again with a different ID.");
            } 
        }
    }
    

    private boolean isItemIdUnique(int id) {
        for (Library<LibraryItem> library : libraryItems) {
            try {
                library.retrieveItem(id);
                return false; 
            } catch (ItemNotFoundException ignored) {
            }
        }
        return true; 
    }
    private void addLibraryClient() {
        boolean validInput = false;  //check if the input is valid
    
        while (!validInput) {
            try {
                System.out.print("Enter Client ID: ");
                String idInput = scan.nextLine();  
                if (!idInput.matches("\\d+")) {
                throw new IllegalArgumentException("Error: Item ID must be a numeric value.");
                }
                int id = Integer.parseInt(idInput);
                
                if (id <= 0) {
                    throw new IllegalArgumentException("Error: Client ID must be a positive integer.");
                }
    
                if (!isIdUnique(id)) {
                    throw new IllegalArgumentException("Error: Client ID must be unique.");
                }
    
                System.out.print("Enter Client Name: ");
                String name = scan.nextLine();
                if (name == null || name.isEmpty()) {
                    throw new IllegalArgumentException("Error: Name cannot be empty.");
                }
    
                System.out.print("Enter Client Email: ");
                String email = scan.nextLine();
                if (email == null || email.isEmpty() || !isValidEmail(email)) {
                    throw new IllegalArgumentException("Error: Invalid email format.");
                }
    
                Client client = new Client(id, name, email);
                libraryClients.add(client);
                validInput = true;  // exit the loop
    
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again.");
            } 
        }
    }
    

    private void removeLibraryClient() {
        while (true) {
            try {
                System.out.print("Enter the ID of the client to remove: ");
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
                    throw new IllegalArgumentException("Client with ID " + id + " not found.");
                }
                break;  // successfully removed
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again with a valid client ID.");
            } 
        }
    }
    
    private boolean isIdUnique(int id) {
        for (Client client : libraryClients) {
            if (client.getId() == id) {
                return false; 
            }
        }
        return true; 
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
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
}
