package JavaProgs;
import java.util.regex.Pattern;
class wordFilterExample {
    public static void main(String[] args) {
        String[] words = {"cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"};
        WordFilter w = new WordFilter(words);
        w.f("bccbacbcba","a");
    }
}



class WordFilter {

    String[] words;
    public WordFilter(String[] words) {
        this.words = words.clone();
    }
    
    public int f(String prefix, String suffix) {
        int indexWithMaxLength = -1;
        int maxLength = Integer.MIN_VALUE;
        int i = 0;
        String regex = "^" + prefix + ".*" + suffix + "$";
        for (String word: words) {
            if (Pattern.matches(regex, word)) {
                if (word.length() > maxLength) {
                    maxLength = word.length();
                    indexWithMaxLength = i;
                }
            }
            i++;
        }
        return indexWithMaxLength;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
