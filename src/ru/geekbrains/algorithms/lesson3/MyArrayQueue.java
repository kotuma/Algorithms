package ru.geekbrains.algorithms.lesson3;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private Object[] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;


    public void enqueue(Item item){
        if(isFull()) {
            resize(2 * queue.length);
        }
        queue[end++] = (Item) item;
        end = (end + 1) % queue.length;
        size++;
    }

    public Item dequeue(){
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        size --;
        start = (start + 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peakFront(){
        if(isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        return (Item) queue[start];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return (size == queue.length);
    }

    public int size() {
        return this.size;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            int ind = (start + i) % queue.length;
            tmp[i] = queue[ind];
        }
        queue = tmp;
        start = 0;
        end = size;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(queue[(start + i) % queue.length]);
            if (i < end - 1) {
                s.append(", ");
            }
        }
        return s.toString();
    }

}
