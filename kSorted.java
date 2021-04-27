package JavaProgs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kSorted {
    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        kSort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    private static void kSort(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
               arr[j] = pq.poll();
               j++;
            }
        }
        while (pq.size() > 0) {
            arr[j] = pq.poll();
            j++;
        }
    }
 }
