package library;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(){
        super("Error: Item Not Found!");
    }
}
