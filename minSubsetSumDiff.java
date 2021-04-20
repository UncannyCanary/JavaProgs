import java.util.ArrayList;
import java.util.List;

class minSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,7};
        System.out.println("Minimum subset sum diff: " + findMinSubsetSumDiff(arr));
    }

    private static int findMinSubsetSumDiff(int[] arr) {
        int range = 0;
        for (int i: arr) {
            range += i;
        }
        List<Integer> v = modifiedSubsetSum(arr, range);
        int min = Integer.MAX_VALUE;
        for (int i : v) {
            min = Math.min(min, range - 2 * i);
        }
        return min;
    }

    private static List<Integer> modifiedSubsetSum(int[] arr, int range) {
        boolean[][] dp = new boolean[arr.length + 1][range + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < range + 1; j++) {
                if (i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
            }
        }
        List<Integer> v = new ArrayList<>();
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                if (arr[ i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (i == arr.length && j <= range / 2 && dp[i][j] == true ) {
                   v.add(j);
                }
            }

        }
        System.out.println(dp[arr.length][range]);
        return v;


    }
    
}