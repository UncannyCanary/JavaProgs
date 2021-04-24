package JavaProgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class combinationSum1 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    private static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        dfsHelper(arr, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void dfsHelper(int[] arr, int target, List<Integer> temp, List<List<Integer>> result, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            dfsHelper(arr, target - arr[i], temp, result, i);
            temp.remove(temp.size() - 1);
        }
    }
}
