package JavaProgs;

import java.util.Arrays;
import java.util.Random;

class quickSortExample {
    public static void main(String[] args) {
        int[] arr = {6};
        qsort(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
    
    private static void qsort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = getPivotPosition(arr, start, end);
            qsort(arr, start, pivot - 1);
            qsort(arr, pivot + 1, end);
        }
    }

    private static int getPivotPosition(int[] arr, int start, int end) {
        swapEndWithRandom(arr, start, end); // Randomised quick sort
        int pivot = arr[end];
        int i = start - 1, j = start;
        while (j <= end - 1) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
            j++;     
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void swapEndWithRandom(int[] arr, int start, int end) {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(end - start + 1) + start;
        swap(arr, randomIndex, end);
    }
}
