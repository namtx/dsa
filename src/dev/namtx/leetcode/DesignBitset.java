package dev.namtx.leetcode;

import java.util.HashSet;
import java.util.Set;

public class DesignBitset {
    static class Bitset {
        Set<Integer> zeroes = new HashSet<>();
        Set<Integer> ones = new HashSet<>();
        int size;
        public Bitset(int size) {
            this.size = size;
            for (int i = 0; i < size; i++) {
                zeroes.add(i);
            }
        }

        public void fix(int idx) {
            if (zeroes.contains(idx)) {
                zeroes.remove(idx);
                ones.add(idx);
            }
        }

        public void unfix(int idx) {
            if (ones.contains(idx)) {
                ones.remove(idx);
                zeroes.add(idx);
            }
        }

        public void flip() {
            Set<Integer> tmp = zeroes;
            zeroes = ones;
            ones = tmp;
        }

        public boolean all() {
            return zeroes.isEmpty();
        }

        public boolean one() {
            return zeroes.size() < size;
        }

        public int count() {
            return ones.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                if (zeroes.contains(i)) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
            return sb.toString();
        }
    }
}
