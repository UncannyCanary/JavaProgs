package JavaProgs;
import java.util.ArrayList;
import java.util.List;

class reverseArrayList {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        List<Integer> rev = new ArrayList<>();
        reverse(arr, arr.size(), rev);
        System.out.println(rev);
    }

    private static void reverse(List<Integer> arr, int size, List<Integer> reversed) {
        if (size < 1) {
            return;
        }
        reversed.add(arr.get(size - 1));
        reverse(arr, size - 1, reversed);        
    }
}
