package dev.namtx.leetcode.editor.en;

public class DesignAStackWithIncrementOperation {
    public static void main(String[] args) {
        CustomStack stack = new DesignAStackWithIncrementOperation().new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class CustomStack {
        int maxSize;
        int ptr;
        int[] stack;
        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            this.ptr = -1;
            this.stack = new int[maxSize];
        }

        public void push(int x) {
            if (ptr == maxSize-1) return;
            ptr++;
            this.stack[ptr] = x;
        }

        public int pop() {
            if (ptr == -1) {
                return -1;
            } else {
                int value = this.stack[ptr];
                ptr--;
                return value;
            }
        }

        public void increment(int k, int val) {
            int j = Math.min(ptr, k-1);
            for (int i = 0; i <= j; i++) {
                this.stack[i] += val;
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
