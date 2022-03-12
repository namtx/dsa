package dev.namtx.leetcode;

public class ValidNumber {
    public boolean isNumber(String s) {
        int ePosition = s.indexOf('e');
        if (ePosition == -1) {
            ePosition = s.indexOf('E');
        }
        if (ePosition == -1) {
            return isInteger(s) || isDecimal(s);
        } else {
            return isDecimal(s.substring(0, ePosition)) && isInteger(s.substring(ePosition+1));
        }
    }

    private boolean isInteger(String s) {
        if (s.length()==0) return false;
        char c = s.charAt(0);
        if (!(c >= '0' && c <= '9')) {
            if (c == '+' || c == '-') {
                if (s.length()==1) return false;
            } else {
                return false;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (!(c >= '0' && c <= '9')) return false;
        }

        return true;
    }

    private boolean isDecimal(String s) {
        if (s.length()==0) return false;
        boolean dotSeen = false;
        char c = s.charAt(0);
        if (c == '.') {
            dotSeen = true;
            if (s.length() == 1) {
                return false;
            }
        } else if (c == '-' || c == '+') {
            if (s.length() == 1) {
                return false;
            }
        } else if (c >= '0' && c <= '9') {
        } else {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '.') {
                if (dotSeen) return false;
                char prev = s.charAt(i-1);
                if (prev == '-' || prev == '+') {
                    if (s.length()==2) return false;
                }
                dotSeen = true;
                continue;
            }
            if (c < '0' || c > '9') return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new ValidNumber().isNumber("000-23"));
        System.out.println(new ValidNumber().isNumber("4e+"));
//        String[] decimalStrings = new String[]{
//                "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789",
//                "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"
//        };
//        for (String s: decimalStrings) {
//            System.out.println(new ValidNumber().isNumber(s));
//        }
    }
}
