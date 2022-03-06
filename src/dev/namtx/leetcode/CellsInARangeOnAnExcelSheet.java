package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CellsInARangeOnAnExcelSheet {
    public List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();
        String[] parts = s.split(":");
        for (int i = parts[0].charAt(0) - 'A'; i <= parts[1].charAt(0)-'A'; i++) {
            for (int j = parts[0].charAt(1)-'0'; j <= parts[1].charAt(1)-'0'; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append((char)(i + 'A'));
                sb.append((char)(j + '0'));
                ans.add(sb.toString());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CellsInARangeOnAnExcelSheet().cellsInRange("A1:F1"));
    }
}
