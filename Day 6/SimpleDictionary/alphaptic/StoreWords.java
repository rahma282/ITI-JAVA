package alphaptic;
import java.util.*;

public class StoreWords {
    MapAlpha alpha= new MapAlpha();
    //Develop and application that stores words into that collection.
    public void addWord(String word) throws WordException{
        if (word == null || word.isEmpty()){
            return;
        }
        char firstchar = Character.toLowerCase(word.charAt(0));  
        if (Character.isAlphabetic(firstchar)) {
            alpha.get(firstchar).add(word);
        } else {
            throw new WordException("Invalid word:"+ word+" Words must start with an alphabet.");
        }

    }
    //Provide methods to print all the letters and correspondingwords
    public void printAll(){
        for (Character ch : alpha.getAlpha().keySet()) {
            System.out.print("Letter: " + ch+" ");
            TreeSet<String> words = alpha.get(ch);
            for (String word : words) {
                System.out.print(word + " ");
            }
            System.out.println("\n----------------------------------------------------");
        }

    }
    //Provide a method to print the words of a given letter
    public void printValue(char ch) throws WordException{
        ch=Character.toLowerCase(ch);
        if (alpha.getAlpha().containsKey(ch) &&!alpha.get(ch).isEmpty()){
            System.out.println("Letter: "+ch);
             System.out.print("Words: ");
            for (String word : alpha.get(ch)) {
                System.out.print(word + " , ");
            }

        } else {
            throw new WordException("No words found for the letter: " + ch);
        }
    }
}
