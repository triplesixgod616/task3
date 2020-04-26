package sample;

import java.util.List;

public class MyQueue<T> {

    private class Node {

        public transient T value;
        public transient Node next;

        public Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }

        public Node() {
            this(null, null);
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public T get() throws Exception {
        if (head == null) {
            throw new Exception("queue is empty");
        }
        T result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return result;
    }

    public void poll() throws Exception {
        if (head == null) {
            throw new Exception("queue is empty");
        }
        T result = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void remove() throws Exception {
        poll();
    }

    public void remove(T t) throws Exception {
        if (head.value == t) {
            remove();
        } else {
            Node x = head;
            Node prev = null;
            while (!(x.value == t)) {
                prev = x;
                x = x.next;
            }
            prev.next = x.next;
        }
    }

    public void add(T t) {
        if (head == null) {
            head = tail = new Node(t, null);
        } else {
            tail.next = new Node(t, null);
            tail = tail.next;
        }
        size++;
    }

    public void clear() {
        head.value = null;
        head.next = null;
        tail.value = null;
        size = 0;
    }

    public T peek() {
        return head.value;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }
}