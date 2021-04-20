class targetSum {
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays(arr, 3));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        int sumOfArrayElements = 0;
        int countOfZero = 0;
        for (int i: nums) {
            if (i == 0) countOfZero++;
            else {
                sumOfArrayElements += i;
            }    
        }
        int arr[] = new int[nums.length - countOfZero];
        int k = 0;
        for (int i: nums) {
            if (i != 0) {
                arr[k++] = i;
            }
        }
        if ((sumOfArrayElements + S) % 2 != 0) return 0;
        int targetSubsetSum = (sumOfArrayElements + S) / 2;
        return subsetSumCount(arr, targetSubsetSum, arr.length) << countOfZero;
    }
    
    private static int subsetSumCount(int[] arr, int S, int n) {
        if (S == 0 && n == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (S == 0) {
            return 1;
        }
        if (arr[n - 1] <= S) {
            return subsetSumCount(arr, S - arr[n - 1], n - 1) + subsetSumCount(arr, S, n - 1);
        }
        else {
            return subsetSumCount(arr, S, n - 1);
        }
    }
}