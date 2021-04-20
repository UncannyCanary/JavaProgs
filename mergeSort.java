package JavaProgs;
import java.util.Arrays;

class mergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
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
            if (arr[l1] < arr[l2]) {
                temp[i++] = arr[l1++];
            }
            else {
                temp[i++] = arr[l2++];
            }   
        }
        while(l1 <= mid) temp[i++] = arr[l1++];
        while(l2 <= end) temp[i++] = arr[l2++];
        for (int j = start; j <= end; j++) {
            arr[j] = temp[j - start];
        }
    }
}