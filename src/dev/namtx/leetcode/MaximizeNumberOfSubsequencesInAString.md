### Maximize Number of Subsequences in a String

[leetcode - Maximize Number of Subsequences in a String](https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string)

### Approach

After reading the solution, we might have some following conclusions:
- For example, we have a text as `aaaab`, and the pattern as `ab`, the position we need to insert into `a` (`i`) is not important, as long as `i` is before the first occurrence of `b` in text, by that, inserted `a` can combine with all `b`s from text.
- For simplicity, we will consider adding `a` at the `0` index.
- The same for `b`, to maximize the number of subsequences, we will add b to `text.length` index.
- Now we have two options: adding `a` to `0` index or `b` to `text.length` index.
- We have to choose `b` as with one `b` we can combine it to 4 `a`s, but with `a`, we only have one additional subsequence.
- So, we iterate over the `text`'s characters and count subsequences.
- After that, we will add to count additional subsequences, which is equal to the maximum number of `a` or `b` in text.

There is two edge cases:
- when the `pattern[0] === pattern[1]`, so the number subsequences exactly is equal to `n * (n + 1) / 2`, with `n` is the number of `pattern[0]` or `pattern[1]` in text.
- when there is no `pattern[0]` or `pattern[1]` inside `text`, so, we simply add the missing character to start or end of text, to the answer is equal to `Math.max(countFirstCharacter, countSecondCharacter)`

### Solution

```java
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        char[] patternChars = pattern.toCharArray();
        long countFirstCharacter = 0;
        long countSecondCharacter = 0;
        long ans = 0;
        for (char c: text.toCharArray()) {
            if (c == patternChars[0]) {
                countFirstCharacter++;
            } else if (c == patternChars[1]) {
                ans += countFirstCharacter;
                countSecondCharacter++;
            }
        }
        if (patternChars[0] == patternChars[1]) {
            return (long) (((double)countFirstCharacter) * ((double) countFirstCharacter + 1) / 2);
        }
        if (countFirstCharacter == 0 || countSecondCharacter == 0) {
            return Math.max(countFirstCharacter, countSecondCharacter);
        }
        return (long) ((double)ans + (double) Math.max(countFirstCharacter, countSecondCharacter));
    }
}
```
