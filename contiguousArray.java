package JavaProgs;
import java.util.HashMap;
import java.util.Map;

class contiguousArray {
    public static void main(String[] args) {
        System.out.println(findContArray(new int[]{0,0,1,0,0,0,1,1}));
    }

    private static int findContArray(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (nums[i] == 0) ? sum - 1 : sum + 1;
            nums[i] = sum;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                result = Math.max(result, i - m.get(nums[i]));
            }
            else {
                m.put(nums[i],i);
            }
        }
        return result;
    }
}