package dev.namtx.leetcode.editor.en;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int price: prices) {
            if (price < minPrice) minPrice = price;
            if (price - minPrice > profit) profit = price -minPrice;
        }

        return profit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
