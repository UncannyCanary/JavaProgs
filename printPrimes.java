package JavaProgs;
class Solution {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
    public static int countPrimes(int n) {
        int count = 0;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n/2; i++) {
            boolean isPrime = true;
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                primes.add(i);
            }
        }
        return count;
    }
}