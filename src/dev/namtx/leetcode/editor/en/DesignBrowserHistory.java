package dev.namtx.leetcode.editor.en;

public class DesignBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new DesignBrowserHistory().new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    class DoublyLinkedListNode {
        String value;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;

        public DoublyLinkedListNode(String value) {
            this.value = value;
        }
    }

    class BrowserHistory {
        DoublyLinkedListNode head;
        DoublyLinkedListNode current;

        public BrowserHistory(String homepage) {
            head = new DoublyLinkedListNode(homepage);
            current = head;
        }

        public void visit(String url) {
            current.next = new DoublyLinkedListNode(url);
            current.next.prev = current;
            current = current.next;
        }


        public String back(int steps) {
            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }
            return current.value;
        }

        public String forward(int steps) {
            while (steps > 0 && current.next != null) {
                current = current.next;
                steps--;
            }
            return current.value;
        }
    }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
    //leetcode submit region end(Prohibit modification and deletion)

}
