import java.util.Arrays;

class countSubsetSumDiff {
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,2,3};
        System.out.println(countAllSubsetSumDiff(arr, 1));
    }
    
    private static int countAllSubsetSumDiff(int[] arr, int diff) {
        int sum = 0;
        for (int i: arr) {
            sum += i;
        }
        if ((diff + sum) % 2 != 0) {
            return 0;
        }
        int targetSumOfSubset = (diff + sum) / 2;
        int[][] dp = new int[arr.length + 1][targetSumOfSubset + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return countSubsetSumWithGivenSum(arr, targetSumOfSubset, arr.length, dp);
    }

    private static int countSubsetSumWithGivenSum(int[] arr, int target, int n, int[][] dp) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        if (arr[n - 1] <= target) {
            return dp[n][target] = countSubsetSumWithGivenSum(arr, target - arr[n- 1], n - 1, dp) + countSubsetSumWithGivenSum(arr, target, n - 1, dp); 
        }
        else {
            return dp[n][target] = countSubsetSumWithGivenSum(arr, target, n - 1, dp);
        }
    }
}
