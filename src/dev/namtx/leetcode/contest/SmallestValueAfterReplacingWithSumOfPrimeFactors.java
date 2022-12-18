package dev.namtx.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

public class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    private static final Set<Integer> primes = new HashSet<>();
    private static final Set<Integer> notPrimes = new HashSet<>();
    public static void main(String[] args) {
        System.out.println(new SmallestValueAfterReplacingWithSumOfPrimeFactors().smallestValue(4));
    }

    public int smallestValue(int n) {
        while (!isPrime(n)) {
            int prev = n;
            int sum = 0;
            int i = 2;
            while (n > 1 && !isPrime(n)) {
                while (isPrime(i) && n % i == 0) {
                    sum += i;
                    n /= i;
                }
                i++;
            }
            n = sum + (n == 1 ? 0 : n);
            if (n == prev) return n;
        }
        return n;
    }

    private boolean isPrime(int n) {
        if (primes.contains(n)) return true;
        if (notPrimes.contains(n)) return false;
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                notPrimes.add(n);
                return false;
            }
        }
        primes.add(n);
        return true;
    }
}
