### Partition Labels

[leetcode - Partition Labels](https://leetcode.com/problems/partition-labels/)

### Approach

After reading the problem, we can easily come up with an idea that:
- A partition is a substring of `s`
- A character belongs to a partition, if, and only if, its last occurrence is in the partition.
- If we have a partition from `[0, 8]`, so every character inside it need to have the last occurrence `<= 8`
- For example, `s = "ababcbacadefegdehijhklij"`, we have the first partition as `ababcbaca`, since every character `a, b, c` has the last occurrence `<= 8`, `lastOccurrences['a'] == 8, lastOccurrences['b'] == 5, lastOccurrences['c'] == 7`

- We keep track of the `lastOccurrences` of character by a simple array, `int[26]`
- and counting the number of characters by the `count` variable
- For each character, we check it the last occurrence of it with the current index, if equals, it means we reached the end of partition, and push the current `count` to the answer.
- If not, we update the max last occurrence, as we have to extend the partition.
 
### Submission

```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] lastOccurrences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrences[s.charAt(i)-'a'] = i;
        }

        int max = 0;
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            int lastOccurrence = lastOccurrences[s.charAt(i)-'a'];
            max = Math.max(lastOccurrence, max);
            if (max == i) {
                ans.add(count);
                count = 1;
            } else {
                count++;
            }
        }

        return ans;
    }
}
```

