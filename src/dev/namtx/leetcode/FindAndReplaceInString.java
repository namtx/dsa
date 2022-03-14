package dev.namtx.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class FindAndReplaceInString {
    public static void main(String[] args) {
        System.out.println(new FindAndReplaceInString().findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int offset = 0;
        HashMap<Integer, String> indiceSourceMap = new HashMap<>();
        HashMap<Integer, String> indiceTargetMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            indiceSourceMap.put(indices[i], sources[i]);
            indiceTargetMap.put(indices[i], targets[i]);
        }
        Arrays.sort(indices);

        for (int i = 0; i < indices.length; i++) {
            int index = offset + indices[i];
            String target = indiceTargetMap.get(indices[i]);
            String source = indiceSourceMap.get(indices[i]);
            if (s.startsWith(indiceSourceMap.get(indices[i]), index)) {
                // replace
                s = replace(index, s, source, target);
                offset += target.length() - source.length();
            }
        }

        return s;
    }

    private String replace(int index, String s, String source, String target) {
        return s.substring(0, index) +
                target +
                s.substring(index + source.length());
    }
}
