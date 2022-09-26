package leetcode.explore.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/
 *
 * 첫번쨰 풀이 : hashtable을 사용하여 공간복잡도가 O(N)인 풀이
 * (예정) 두번째 풀이 : two pointer를 활용한 공간복잡도 O(1)인 풀이
 */
public class LinkedListCycle1 {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> hashTable = new HashMap<>();

        ListNode nextNode = head;
        while(nextNode != null) {
            if(hashTable.containsKey(nextNode)) {
                return true;
            }

            hashTable.put(nextNode, 1);
            nextNode = nextNode.next;
        }
        return false;
    }

    /**
     * 속도가 다른 두 개의 포인터를 활용한 권장풀이방법
     * 공간복잡도가 O(1)임
     *
     * 속도도 cycle 없으면 2칸씩 검사하던 fast가 끝에 도달하여 끝나고
     * 있어도 slow가 한 바퀴쨰 돌때까지 만나게되므로 속도도 동일하게 빠름
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode n1 = new ListNode(1);
        head.next = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;

        LinkedListCycle1 sol = new LinkedListCycle1();
        System.out.println(sol.hasCycle(head));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
