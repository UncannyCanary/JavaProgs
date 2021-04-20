package JavaProgs;
class longestIncreasingPath {
    public static void main(String[] args) {
        int[][] m = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(findLIP(m, m.length, m[0].length));
    }

    private static int[][] DIRECTIONS = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    private static int findLIP(int[][] m, int l, int t) {
        int max = 0;
        int dp[][] = new int[l][t];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < t; j++) {
                int longestPath = findLIPHelper(m, l, t, i, j, dp);
                max = Math.max(longestPath, max);
            }
        }
        return max;
    }

    private static int findLIPHelper(int[][] m, int l, int t, int i, int j, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int max = 0;
        for (int[] direction: DIRECTIONS) {
            int x = direction[0] + i, y = direction[1] + j;
            if (x > -1 && y > -1 && x < l && y < t && m[x][y] > m[i][j]) {
                int longest = findLIPHelper(m, l, t, x, y, dp);
                max = Math.max(longest, max);
            }
        }
        return dp[i][j] = max + 1;

    }
}