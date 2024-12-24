package letter;
public class Str {
    public boolean isLetter(String s){
        if (s == null){
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!(c>='A' && c<='Z') && !(c>='a' && c<='z')) {
                return false;
            }
        }
        return true;
    }
    public boolean onlyAlphabet(String s){
        // chars() method to get the character stream and process them one at a time.
        return (s != null) && (s.chars().allMatch(Character :: isLetter)); //method reference
    }
}
