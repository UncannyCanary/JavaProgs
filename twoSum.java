package JavaProgs;
import java.util.HashMap;
import java.util.Map;

class twoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(twoSumCalc(arr, 9).toString());
    }
    public static int[] twoSumCalc(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                return new int[]{i, map.get(t)};
            }
        }
        return new int[1];
    }
}