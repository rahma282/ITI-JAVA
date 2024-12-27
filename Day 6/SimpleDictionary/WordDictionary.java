import alphaptic.*;
import java.util.Scanner;

public class WordDictionary {
    public static void main(String[] args) {
        StoreWords dictionary = new StoreWords();

        try {
            dictionary.addWord("Ahmed");
            dictionary.addWord("Ant");
            dictionary.addWord("Basmla");
            dictionary.addWord("bakr");
            dictionary.addWord("Cat");
            dictionary.addWord("car");
            dictionary.addWord("Dog");
            dictionary.addWord("apple"); 
            dictionary.addWord("zeo");
        } catch (WordException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nWords in the dictionary:");
        dictionary.printAll();


        try ( 
              Scanner scan = new Scanner(System.in)) {
            System.out.print("\nEnter a letter to view words: ");
            char letter = scan.next().charAt(0);
            try {
                dictionary.printValue(letter);
            } catch (WordException e) {
                System.out.println(e.getMessage());
            }
            }
}
}
