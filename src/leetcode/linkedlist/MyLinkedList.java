package leetcode.linkedlist;

public class MyLinkedList {

    class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    int size;
    Node head;

    public MyLinkedList() {
        head = new Node(-1);
        size = 0;
    }

    public int get(int index) {
        if (index >= size){
            return -1;
        }

        Node currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {

        if (index > size)
            return;

        Node node = new Node(val);
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        node.next = currentNode.next;
        currentNode.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {

        if (index >= size)
            return;

        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
        size--;
    }
}
