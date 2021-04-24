package JavaProgs;

class ppFour {
    public static void main(String[] args) {
        System.out.println(checkPartitioning("abcbdd"));
    }
    public static boolean checkPartitioning(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        constructPalindromeDP(dp, s, s.length());
        for (int i = 1; i < s.length() - 1; ++i) {
            for (int j = i; j < s.length() - 1; ++j) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][s.length() - 1]) return true;
            }
        }    
        
        
        return false;    
    }
    
    private static void constructPalindromeDP(boolean[][] dp, String s, int len) {
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
    }
}
