package JavaProgs;

import java.util.PriorityQueue;

public class connectRopes {
    public static void main(String[] args) {
        System.out.println(minCostToConnectRopes(new int[]{4,3,2,6}));
    }

    private static int minCostToConnectRopes(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int totalLength = 0;
        for (int i: arr) {
            pq.add(i);
        }
        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            totalLength += first + second;
            pq.add(first + second);
        }
        return totalLength;
    }
}
