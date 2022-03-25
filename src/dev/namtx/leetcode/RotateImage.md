### (1) Rotate Image

[Leetcode - Rotate Image](https://leetcode.com/problems/rotate-image/)

### Approach

![rotate image](https://user-images.githubusercontent.com/25602820/160112545-123538a7-8cc3-4be4-94db-0ceb10affb47.jpeg)
### Submission
```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}
```
