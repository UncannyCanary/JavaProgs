import java.util.ArrayDeque;
import java.util.Deque;

class Pair {
    public final char a;
    public final int b;
    
    Pair(char a, int b) {
        this.a = a;
        this.b = b;
    }
}

class removeAdjacentDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
    public static String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
           if (stack.peek() == null) {
               stack.push(new Pair(s.charAt(i), 1));
           } 
           else {
               if (s.charAt(i) == stack.peek().a) {
                   if (stack.peek().b + 1 == k){
                       int count = 0;
                       while (count != k - 1) {
                           stack.pop();
                           count++;
                       }
                   }
                   else {
                    stack.push(new Pair(s.charAt(i), stack.peek().b + 1));
                   }    
               }
               else {
                   stack.push(new Pair(s.charAt(i), 1));
               }
           } 
        }
        StringBuilder result = new StringBuilder();
        for (Pair i: stack) {
            result.append(i.a);
        }
        return result.reverse().toString();
    }
}