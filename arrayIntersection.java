import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class arrayIntersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersection;
        if (nums1.length < nums2.length) {
            intersection = findIntersection(nums1, nums2);
        }
        else {
            intersection = findIntersection(nums2, nums1);
        }
        int[] result = new int[intersection.size()];
        int k = 0;
        for (int i: intersection) {
            result[k++] = i;
        }
        return result;
    }
    
    private static List<Integer> findIntersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> s = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
            for (int i: nums2) {
                if (s.containsKey(i)) {
                    s.put(i, s.get(i) + 1);
                }
                else {
                    s.put(i, 1);
                }
            }
            for (int i: nums1) {
                if (s.containsKey(i) && s.get(i) > 0) {
                    intersection.add(i);
                    s.put(i, s.get(i) - 1);
                }
            }
        return intersection;
    }
}