package leetcode.explore.linkedlist;

/**
 * Design Linked List
 * https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290
 */
class MyLinkedList {
    private int val;
    private MyLinkedList next;
    private int length = 0;

    public MyLinkedList() {
        
    }

    // if bigger and equals than zero, return first value node.
    // if minus, return head node.
    private MyLinkedList indexOf(int index) {
        // "this" means head
        MyLinkedList indexNode = this;

        for(;index>=0;index--) {
            indexNode = indexNode.next;
        }

        return indexNode;
    }
    
    public int get(int index) {
        // If the index is invalid, return -1.
        if(index >= length) return -1;

        return indexOf(index).val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(length, val);
    }
    
    public void addAtIndex(int index, int val) {
        // If index is greater than the length, the node will not be inserted.
        if(index > length) return;

        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;

        MyLinkedList prevNode = indexOf(index-1);

        newNode.next = prevNode.next;
        prevNode.next = newNode;
        length++;
    }
    
    public void deleteAtIndex(int index) {
        // Delete the index node in the linked list, if the index is valid.
        if(index >= length) return;

        MyLinkedList prevNode = indexOf(index-1);
        MyLinkedList indexNode = prevNode.next;

        prevNode.next = indexNode.next;
        length--;
    }

    public static void main(String[] args) {
        // [1, 3]
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//        System.out.println(myLinkedList.get(1));              // return 2
//        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//        System.out.println(myLinkedList.get(1));              // return 3

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);

        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);

        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList.get(5));              // return 3

        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
    }
}