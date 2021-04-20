class printLCS {
    public static void main(String[] args) {
        System.out.println(findLCS("AGGTAB", "GXTXAYB"));
    }
    
    private static String findLCS (String x, String y) {
        int dp[][] = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i < x.length() + 1; i++) {
            for (int j = 0; j < y.length() + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        int i = x.length(), j = y.length();
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i - 1));
                    i--; j--;
            }
            else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                }
                else {
                    i--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
