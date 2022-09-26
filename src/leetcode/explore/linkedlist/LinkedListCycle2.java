package leetcode.explore.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
 *
 * 첫번쨰 풀이 : hashtable을 사용하여 공간복잡도가 O(N)인 풀이
 * (예정) 두번째 풀이 : two pointer를 활용한 공간복잡도 O(1)인 풀이
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> hashTable = new HashMap<>();

        ListNode nextNode = head;
        while(nextNode != null) {
            if(hashTable.containsKey(nextNode)) {
                return nextNode;
            }

            hashTable.put(nextNode, 1);
            nextNode = nextNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode n1 = new ListNode(1);
        head.next = n1;
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;

        LinkedListCycle2 sol = new LinkedListCycle2();
        System.out.println(sol.detectCycle(head));
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
