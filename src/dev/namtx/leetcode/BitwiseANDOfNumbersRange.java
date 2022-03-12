package dev.namtx.leetcode;

class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int mask = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            mask++;
        }
        return left << mask;
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(5, 7));
    }
}
