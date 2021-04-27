package JavaProgs;

class powerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(1));
    }
    public static boolean isPowerOfThree(int n) {
        return checkIsPowerOfThree(n / 3, n % 3 );
    }
    
    private static boolean checkIsPowerOfThree(int q, int r) {
        if (r != 0 || q == 0) {
            return false;
        }
        if (q == 1) {
            return true;
        }
        return checkIsPowerOfThree(q / 3, q % 3);
    }
}
