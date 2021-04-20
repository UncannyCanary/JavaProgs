class longestPalSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    private static String longestPalindrome(String str) {
        if (str.length() <= 1) {
            return str;
        }
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = true;
        }
        int j, i = 0, n = 0;
        int maxPalLength = 1;
        String maxPalSubString = str.substring(0,1);
        // Fill dp right triangle table
        while (n < str.length()) {
            for (i = 0, j = n + 1; i < str.length() && j < str.length(); i++, j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if ( j - i == 1 || dp[i + 1][ j - 1]) {
                        if (j - i + 1 > maxPalLength) {
                            maxPalLength = j - i + 1;
                            maxPalSubString = str.substring(i, j + 1);
                        }
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = false;
                    }    
                } else {
                    dp[i][j] = false;
                }
            }
            i = 0;
            n++;
        }
        return maxPalSubString;
    }

}