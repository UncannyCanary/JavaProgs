package JavaProgs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class topKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i: nums) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new SortByFrequency());
        for (Map.Entry<Integer, Integer> entry: m.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        
        return result;
    }
    
    private static class SortByFrequency implements Comparator<Map.Entry<Integer,Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer,Integer> b) {
           return a.getValue() - b.getValue();
        }
    }
}