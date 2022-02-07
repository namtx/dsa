package dev.namtx.leetcode;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
abstract class VersionControl {
    abstract public boolean isBadVersion(int version);
}

public class FirstBadVersion extends VersionControl {
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    @Override
    public boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}
