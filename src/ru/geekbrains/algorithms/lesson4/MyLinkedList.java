package ru.geekbrains.algorithms.lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<Item> {
        Node cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = cursor.item;
            cursor = cursor.next;
            return item;
        }
    }

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
            first = null;
        }
        else {
            last.next = null;
        }
        return item;
    }

    private Node getNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode;
        if (index < size / 2) {    // Search from begin of list
            currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
        }
        else {                      // Search from end of list
            currentNode = last;
            int currentIndex = size - 1;
            while (currentIndex > index) {
                currentNode = currentNode.prev;
                currentIndex--;
            }
        }
        return currentNode;
    }

    public Item get(int index) {
        Node currentNode = getNode(index);
        return currentNode.item;
    }

    public void set(int index, Item item) {
        Node currentNode = getNode(index);
        currentNode.item = item;
    }

    public int indexOf(Item item){
        Node currentNode = first;
        int currentIndex = 0;
        while (!currentNode.item.equals(item) && currentNode != null) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        return currentNode != null ? currentIndex : -1;
    }

    public boolean contains(Item item){
        return indexOf(item) > -1;
    }

    public Item remove(Item item) {
        Node currentNode = first;
        /*
            не рабочий код при попытке удаления несуществующего item,
            т.к. currentNode = null и вторая часть условия приводит к ошибке

        while (currentNode != null || !currentNode.item.equals(item)) {
            currentNode = currentNode.next;
        }
        */
        while (currentNode != null) {
            if ( currentNode.item.equals(item) ) {
                break;
            }
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            return null;
        }

        if (currentNode == first) {
            return removeFirst();
        }

        if (currentNode == last) {
            return removeLast();
        }

        Node next = currentNode.next;
        Node prev = currentNode.prev;

        prev.next = next;
        next.prev = prev;
        size--;

        currentNode.prev = null;
        currentNode.next = null;

        return currentNode.item;
    }

    public void add(int index, Item item) { // Add before index
        if ( index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
        }
        else if (index == size) {
            addLast(item);
        }
        else {
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < index) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            Node prev = currentNode.prev;
            Node next = currentNode;
            Node newNode = new Node(prev, item, next);

            prev.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node currentNode = first;
        while (currentNode != null) {
            s.append(currentNode.item.toString());
            if (currentNode.next != null) {
                s.append(", ");
            }
            currentNode = currentNode.next;
        }
        return s.toString();
    }
}
