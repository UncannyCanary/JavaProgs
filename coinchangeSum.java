package JavaProgs;
class coinchangeSum {
    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,3}));
    }
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
                if (i > 0 && j > 0) {
                    if (coins[ i - 1] <= j) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    }
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[coins.length][amount];
    }
}
