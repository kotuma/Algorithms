package ru.geekbrains.algorithms.lesson3;

import java.util.NoSuchElementException;

public class MyArrayDeque<Item> {
    private Object[] deque = new Object[1];
    private int size = 0;
    private int left = 0; // левая граница
    private int right = 0; // следующая позищия за правой границей


    public void addToRight(Item item){
        if(isFull()) {
            resize(2 * deque.length);
        }
        deque[right++] = item;
        right %= deque.length;
        size++;
    }

    public void addToLeft(Item item){
        if(isFull()) {
            resize(2 * deque.length);
        }
        left = (left - 1 + deque.length) % deque.length;
        deque[left] = item;
        size++;
    }


    public Item removeLeft(){
        if(isEmpty()) {
            throw new NoSuchElementException("Deque is Empty");
        }
        Item item = (Item) deque[left];
        deque[left] = null;
        size --;
        left = (left + 1) % deque.length;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item removeRight(){
        if(isEmpty()) {
            throw new NoSuchElementException("Deque is Empty");
        }
        right = (right - 1 + deque.length) % deque.length;
        Item item = (Item) deque[right];
        deque[right] = null;
        size--;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item peakLeft(){
        if(isEmpty()) {
            throw new NoSuchElementException("Deque is Empty");
        }
        return (Item) deque[left];
    }

    public Item peakRight(){
        if(isEmpty()) {
            throw new NoSuchElementException("Deque is Empty");
        }
        return (Item) deque[(right - 1 + deque.length) % deque.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return (size == deque.length);
    }

    public int size() {
        return this.size;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            int ind = (left + i) % deque.length;
            tmp[i] = deque[ind];
        }
        deque = tmp;
        left = 0;
        right = size;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(deque[(left + i) % deque.length]);
            //s.append(", ");
            if ((left + i) % deque.length != (right - 1 + deque.length) % deque.length)  {
                s.append(", ");
            }
        }
        return s.toString();
    }

}
