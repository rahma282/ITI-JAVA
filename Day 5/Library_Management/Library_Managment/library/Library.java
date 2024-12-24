package library;

import java.util.ArrayList;
import java.util.List;

public class Library<T extends LibraryItem> {
    List<T> items;

    public Library() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T retrieveItem(int id) throws ItemNotFoundException { //retrive using id check if id is found retrive
        for (T item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new ItemNotFoundException(); 
    }

    public void removeItemById(int id) throws ItemNotFoundException {
        for (T item : items) {
            if (item.getId() == id) {
                items.remove(item);
                return;
            }
        }
        throw new ItemNotFoundException(); 
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("The library is empty.");
        }
        for (T item : items) {
            System.out.println(item.getItemDetails()); 
        }
    }
}
