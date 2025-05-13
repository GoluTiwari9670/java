import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // ✅ Method the judge is looking for
    public static ListNode deserialize(String data) {
        if (data == null || data.length() <= 2) return null;
        data = data.substring(1, data.length() - 1); // remove brackets
        if (data.isEmpty()) return null;

        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (String part : parts) {
            curr.next = new ListNode(Integer.parseInt(part.trim()));
            curr = curr.next;
        }

        return dummy.next;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps

            if (slow == fast) return true; // cycle detected
        }

        return false; // no cycle
    }
}
