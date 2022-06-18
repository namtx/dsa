package dev.namtx.leetcode;

/**
 * cookies = [8,15,10,20,8], k = 2
 * output: 31
 */
public class FairDistributionOfCookies {
    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(new FairDistributionOfCookies().distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
    }

    public int distributeCookies(int[] cookies, int k) {
        int[] bags = new int[k];
        solve(cookies, k, bags, 0);
        return ans;
    }

    private void solve(int[] cookies, int k, int[] bags, int i) {
        if (i >= cookies.length) {
            int tmp = Integer.MIN_VALUE;
            for (int bag : bags) {
                tmp = Math.max(tmp, bag);
            }
            ans = Math.min(ans, tmp);
            return;
        }
        for (int j = 0; j < k; j++) {
            bags[j] += cookies[i];
            solve(cookies, k, bags, i + 1);
            bags[j] -= cookies[i];
        }
    }
}
