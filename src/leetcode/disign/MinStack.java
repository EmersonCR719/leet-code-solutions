package leetcode.disign;

public class MinStack {

    private Node top;

    private class Node {
        int data;
        int min; // Mínimo hasta este nodo
        Node next;

        public Node(int data, int min, Node next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }

    public MinStack() {
        top = null;
    }

    public void push(int val) {
        if (top == null) {
            top = new Node(val, val, null);
        } else {
            // Calculamos el nuevo mínimo
            int newMin = Math.min(val, top.min);
            Node newNode = new Node(val, newMin, top);
            top = newNode;
        }
    }

    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }

    public int top() {
        return (top != null) ? top.data : -1;
    }

    public int getMin() {
        return (top != null) ? top.min : -1;
    }

}
