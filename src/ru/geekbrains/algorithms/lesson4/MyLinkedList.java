package ru.geekbrains.algorithms.lesson4;

import java.util.NoSuchElementException;

public class MyLinkedList<Item> {
    private class Node {
        Item item;
        Node next;
        Node prev;

        public Node(Node prev, Item item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private int size;
    private Node first = null;
    private Node last = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void isEmptyException() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
    }

    public Item getFirst() {
        isEmptyException();
        return first.item;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if (isEmpty()) {
            last = first;
        }
        else {
            oldFirst.prev = first;
        }
        size++;
    }

    public Item removeFirst() {
        isEmptyException();

        Node second = first.next;
        Item item = first.item;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()) {
            last = first;
        }
        else {
            second.prev = null;
        }

        return item;
    }

    public Item getLast() {
        isEmptyException();
        return last.item;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeLast() {
        isEmptyException();
        Item item = last.item;
        Node prev = last.prev;
        last.prev = null;
        last = prev;
        size--;
        if (isEmpty()) {
            first = null
        }
        else {
            last.next = null;
        }
        return item;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException()
        }
        Node current
    }
}
