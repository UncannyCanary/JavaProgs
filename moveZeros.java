package JavaProgs;
import java.util.Arrays;

class moveZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        solve(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void solve(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSortHelper(arr, start, mid);
            mergeSortHelper(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int arr[], int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int l1 = start, l2 = mid + 1, i = 0;
        while (l1 <= mid && l2 <= end) {
            if (arr[l1] != 0) {
                temp[i++] = arr[l1++];
            }
            else if (arr[l2] != 0) {
                temp[i++] = arr[l2++];
            }
            else {
                break;
            }  
        }
        while(l1 <= mid) temp[i++] = arr[l1++];
        while(l2 <= end) temp[i++] = arr[l2++];
        for (int j = start; j <= end; j++) {
            arr[j] = temp[j - start];
        }
    }
}