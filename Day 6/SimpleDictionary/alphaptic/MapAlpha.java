package alphaptic;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapAlpha {
    public SortedMap<Character, TreeSet<String>> alpha;

    MapAlpha() {
        alpha = new TreeMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            alpha.put(ch, new TreeSet<>());
        }
    }
    public TreeSet<String> get(char ch) {
        return alpha.get(ch);
    }
    public SortedMap<Character, TreeSet<String>> getAlpha() {
        return alpha;
    }
 }
