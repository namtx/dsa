package dev.namtx.leetcode;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String s, String t) {
        int skipS = 0;
        int skipT = 0;
        int ps = s.length() - 1;
        int pt = t.length() - 1;

        while (ps >= 0 || pt >= 0) {
            while (ps >= 0) {
                if (s.charAt(ps) == '#') {
                    skipS++;
                    ps--;
                } else {
                    if (skipS > 0) {
                        skipS--;
                        ps--;
                    } else {
                        break;
                    }
                }
            }
            while (pt >= 0) {
                if (t.charAt(pt) == '#') {
                    skipT++;
                    pt--;
                } else {
                    if (skipT > 0) {
                        skipT--;
                        pt--;
                    } else {
                        break;
                    }
                }
            }
            if (pt >= 0 && ps >= 0 && s.charAt(ps) != t.charAt(pt)) {
                return false;
            }
            if ((ps >= 0) != (pt >= 0)) {
                return false;
            }

            ps--;
            pt--;
        }

        return true;
    }
}
