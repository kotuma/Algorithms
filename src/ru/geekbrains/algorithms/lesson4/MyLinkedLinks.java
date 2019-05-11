package ru.geekbrains.algorithms.lesson4;

import java.util.NoSuchElementException;

public class MyLinkedLinks<Item> {
    private class Node {
        Item item;
        Node next;
        Node prev;

        public Node(Item item, Node next) {
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
        first = new Node(item, oldFirst);
        if (isEmpty()) {
            last = first;
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
        return item;
    }

    public Item getLast() {
        isEmptyException();
        return last.item;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node(item, null);
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
        previous =
    }
}
