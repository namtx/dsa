package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/add-digits/
 */
public class AddDigits {
    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(38));
    }

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }
}
