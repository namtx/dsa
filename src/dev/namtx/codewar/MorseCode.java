package dev.namtx.codewar;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
    public String solve(String input) {
        Map<String, String> codes = new HashMap<>();
        codes.put(".-", "A");
        codes.put("-...", "B");
        codes.put("-.-.", "C");
        codes.put("-..", "D");
        codes.put(".", "E");
        codes.put("..-.", "F");
        codes.put("--.", "G");
        codes.put("....", "H");
        codes.put("..", "I");
        codes.put(".---", "J");
        codes.put("-.-", "K");
        codes.put(".-..", "L");
        codes.put("--", "M");
        codes.put("-.", "N");
        codes.put("---", "O");
        codes.put(".--.", "P");
        codes.put("--.-", "Q");
        codes.put(".-.", "R");
        codes.put("...", "S");
        codes.put("-", "T");
        codes.put("..-", "U");
        codes.put("...-", "V");
        codes.put(".--", "W");
        codes.put("-..-", "X");
        codes.put("-.--", "Y");
        codes.put("--..", "Z");

        String[] words = input.split(" / ");

        StringBuilder sb = new StringBuilder();
        for (String w: words) {
            int offset = -1;
            for (String c: w.split(" ")) {
                sb.append((char)(codes.get(c).charAt(0) + offset)) ;
                offset -= 1;
            }
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MorseCode().solve("--- --. -.-- .. .-- / -. .-- .-- -..- .-.. / - .-- -.- ..- / --.- .... --- / --.- -- / -- . .-- --. ..- / .-.. ..- ..- ...- .--- / .-- --.- --. / -. . .-.. / .-- .. .-. .--- / .-.. -.. ...- ..-. - / -.- - - ..- .. / -... ..-. --.. / --- --. . .-.. ..-. .-- / ...- .--- .- / -.-. . - --. ..- -..- / . ...- -.-.--- --. -.-- .. .-- / -. .-- .-- -..- .-.. / - .-- -.- ..- / --.- .... --- / --.- -- / -- . .-- --. ..- / .-.. ..- ..- ...- .--- / .-- --.- --. / -. . .-.. / .-- .. .-. .--- / .-.. -.. ...- ..-. - / -.- - - ..- .. / -... ..-. --.. / --- --. . .-.. ..-. .-- / ...- .--- .- / -.-. . - --. ..- -..- / . ...- -.-."));
    }
}
