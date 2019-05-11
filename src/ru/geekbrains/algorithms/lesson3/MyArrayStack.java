package ru.geekbrains.algorithms.lesson3;

import java.util.NoSuchElementException;

// Реализация стека на основе массива
public class MyArrayStack<Item> {
    private Object[] stack = new Object[1];
    private int size = 0;

    public void push(Item item) {
        if (isFull()) {
            resize(stack.length * 2);
        }
        stack[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        else {
            Item item = (Item) stack[size - 1];
            stack[size - 1] = null;
            size --;
            if (size == stack.length / 4 && size > 0) {
                resize(stack.length / 2);
            }
            return item;
        }

    }

    public Item peak() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        else {
            return (Item) stack[size - 1];
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return (size == stack.length);
    }

    public int size() {
        return this.size;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = stack[i];
        }
        stack = tmp;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(stack[i]);
            if (i < size - 1) {
                s.append(", ");
            }
        }
        return s.toString();
    }
}
