package dev.namtx.leetcode.daily;

public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int crossArea = 0;
        int totalArea = 0;
        for (int i = ax1; i < ax2; i++) {
            for (int j = ay1; j < ay2; j++) {
                if (i >= bx1 && i < bx2 && j >= by1 && j < by2) {
                    crossArea++;
                }
                totalArea++;
            }
        }

        for (int i = bx1; i < bx2; i++) {
            for (int j = by1; j < by2; j++) {
                totalArea++;
            }
        }

        return totalArea - crossArea;
    }
}
