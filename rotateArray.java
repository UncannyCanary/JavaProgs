package JavaProgs;
import java.util.Arrays;

class rotateArray {
    public static void rotate(int[] nums, int k) {

        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));
    }
    
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    private static void reverse(int[] arr, int start, int end) {
        for (int i = start, k = 0; i <= (end + start)/ 2; i++, k++) {
            swap(arr, i, end - k);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1};
        rotate(arr, 2);
    }
}