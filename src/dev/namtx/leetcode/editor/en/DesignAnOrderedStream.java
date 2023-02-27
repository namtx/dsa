package dev.namtx.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {
    public static void main(String[] args) {
        OrderedStream solution = new DesignAnOrderedStream().new OrderedStream(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class OrderedStream {
        int ptr;
        int size;
        String[] stream;

        public OrderedStream(int n) {
            this.ptr = 1;
            this.size = n;
            this.stream = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            List<String> ans = new ArrayList<>();
            if (this.ptr == idKey) {
                while (this.ptr <= this.size && this.stream[this.ptr] != null) {
                    ans.add(this.stream[this.ptr++]);
                }
            }
            return ans;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
