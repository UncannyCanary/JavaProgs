package JavaProgs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class firstNegativeInWindow {
    public static void main(String[] args) {
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        System.out.println(getFirstNegativeInWindow(arr, 3));
    }

    private static List<Integer> getFirstNegativeInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> negativeNumbers = new ArrayDeque<>();
        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[j] < 0) {
                negativeNumbers.add(arr[j]); //Calculation part
            }
            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {
                if (negativeNumbers.isEmpty()) {
                    result.add(0);
                }
                else {
                    result.add(negativeNumbers.peek());
                    if (arr[i] == negativeNumbers.peek()) {
                        negativeNumbers.poll();
                    }
                }    
                i++; j++;        
            }
            
        }
        return result;
    }
}
