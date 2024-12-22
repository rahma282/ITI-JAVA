import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SpiltString {
    public static void main(String[] args) {
        /*
         * given a sequence and a word, your task is that to count the number of
         * occurrence of given word in sentence in the string
         * and print the number of occurrence of the word.
         * 1-perform the above task using only methods os the string class(2 ways).
         * 2-perform the above task using StringTokenizer class.
         */
        String sentence = "ITI develops people and ITI house of developers and ITI for people";
        String word = "ITI";

        System.out.println("count of ITI using Splits is: " + countWordsUsingSplit(sentence) + "\n"); 
        System.out.print("count of ITI using CollectionFrequacy is: " +countWordUsingCollectionFrequacy(sentence, word) + "\n");
        System.out.println("\ncount of words using Tokenizer is: " + countWordsUsingStringTokenizer(sentence, word)+ "\n");
    }

    /*
     * Count number of spacific word in given String using split() and regular expression
     * return number of words
     */
    public static int countWordsUsingSplit(String input) {  //first method 
        // check if the string is null or empty then return zero
        if (input == null) {
            return 0;
        }
        // Splitting the string
        String[] words = input.split(" ITI");
        //String s = Arrays.toString(words);
        //System.out.println(s);
        return words.length;
    }
    /*
        * count the number of spacific word using  Collections.frequency()
        * return number of words
    */
    public static int countWordUsingCollectionFrequacy(String sentence ,String targetWord){
        if (sentence == null) {
            return 0;
        }
        int wordCount = Collections.frequency(Arrays.asList(sentence.split(" ")), targetWord);
        return wordCount;
    }

    /*
     * Count number of spacific word in given String using StirngTokenizer
     * return count of words
     */
    public static int countWordsUsingStringTokenizer(String sentence, String word) {  //return cound of word in spacific sentance
        if (sentence == null) {
            return 0;
        }
        StringTokenizer tokens = new StringTokenizer(sentence,word);
        return tokens.countTokens();
    }

}

