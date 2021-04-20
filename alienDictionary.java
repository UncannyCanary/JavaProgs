package JavaProgs;
import java.util.HashMap;
import java.util.Map;

class alienDictionary {
    public static void main(String[] args) {
        String[] words = {"rocept","zpvxl"};
        String order = "gvwyilukqmzhncetajbdoxfspr";
        System.out.println(isAlienSorted(words, order));
    }

    private static boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> m = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            m.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare((words[i]),(words[i + 1]), m)) return false;            
        }
        return true;
    }

    private static boolean compare(String s1, String s2, Map<Character, Integer> map) {
        int l1 = s1.length(), l2 = s2.length();
        for (int i = 0, j = 0; i < l1 && j < l2; i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (map.get(s1.charAt(i)) > map.get(s2.charAt(j))) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        if (l1 > l2) return false;
        return true;
    }
    
}