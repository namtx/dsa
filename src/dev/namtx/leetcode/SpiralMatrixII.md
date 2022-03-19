### SpiralMatrixII

[leetcode - SpiralMatrixII](https://leetcode.com/problems/spiral-matrix-ii/)

### Approach

- Use a `num` variable to keep track the number need to be added to the matrix
- Use four nested loops to add `num` to the matrix by spiral way

![spiral](https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg)

- There is a corner case when `n` is odd, and the middle position will not be filled, we have to fill it lastly.
### Submission

```java
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < (n / 2) + 1; i++) {
            // first row
            for (int j = i; j < (n - i) - 1; j++) {
                matrix[i][j] = num++;
            }
            // last column
            for (int j = i; j < (n - i) - 1; j++) {
                matrix[j][n - i - 1] = num++;
            }
            // last row
            for (int j = n - i - 1; j > i; j--) {
                matrix[n - i - 1][j] = num++;
            }
            // first column
            for (int j = n - i - 1; j > i; j--) {
                matrix[j][i] = num++;
            }
        }
        matrix[n / 2][n / 2] = num;

        return matrix;
    }
}
```
