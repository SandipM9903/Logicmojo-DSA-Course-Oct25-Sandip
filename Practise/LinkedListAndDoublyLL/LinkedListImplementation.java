package Practise.LinkedListAndDoublyLL;

public class LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addFirst(4);
        ll.add(0, 100);
        ll.remove(20); // This won't remove anything because index 20 > size
        System.out.print(ll);
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    public String toString() {
        return val + "";
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    void addLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    Node removeFirst() {
        if (size == 0) return null;
        Node first = head;
        head = head.next;
        if (head == null) tail = null;
        size--;
        first.next = null;
        return first;
    }

    Node removeLast() {
        if (size <= 1) return removeFirst();
        Node curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }
        Node last = tail;
        tail = curr;
        tail.next = null;
        size--;
        return last;
    }

    void add(int i, int val) {
        if (i == 0) {
            addFirst(val);
            return;
        }
        if (i == size) {
            addLast(val);
            return;
        }
        if (i > size) return;

        Node curr = head;
        for (int idx = 0; idx < i - 1; idx++) {
            curr = curr.next;
        }
        Node node = new Node(val);
        node.next = curr.next;
        curr.next = node;
        size++;
    }

    Node remove(int i) {
        if (i >= size || i < 0) return null;
        if (i == 0) return removeFirst();
        if (i == size - 1) return removeLast();

        Node curr = head;
        for (int idx = 0; idx < i - 1; idx++) {
            curr = curr.next;
        }
        Node removed = curr.next;
        curr.next = curr.next.next;
        removed.next = null;
        size--;
        return removed;
    }

    public String toString() {
        if (size == 0) return "null";
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val).append("->");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
