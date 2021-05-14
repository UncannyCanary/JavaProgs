package JavaProgs;
class multpleSumsTarget {
    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1,1,1,2}));
    }
    public static boolean isPossible(int[] target) {
        int maxSum = 0;
        int restSum = 0;
        int maxSumIndex = -1;
        while(true) {
            for (int i = 0; i < target.length; i++) {
                restSum = restSum + target[i];
                if (target[i] > maxSum) {
                    restSum = restSum + maxSum;
                    maxSum = target[i];
                    maxSumIndex = i;
                    restSum = restSum - target[i];
                }
            }
            if (maxSum % restSum <= 0) return false;
            else {
                target[maxSumIndex] = maxSum % restSum;
                int totalSum = 0;
                for (int i = 0; i < target.length; i++) {
                    totalSum += target[i];
                }
                if (totalSum == target.length) {
                    return true;
                }
                restSum = maxSum = 0;
            }
        }    
        
    }
}
