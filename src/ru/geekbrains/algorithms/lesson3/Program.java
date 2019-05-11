package ru.geekbrains.algorithms.lesson3;

public class Program {
    public static void main(String[] args) {
        /*
        MyArrayStack<Character> stack = new MyArrayStack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());
        System.out.println(stack.toString());
        */
        MyArrayDeque<Character> deque = new MyArrayDeque<>();
        deque.addToLeft('a');
        deque.addToLeft('b');
        deque.addToLeft('c');
        System.out.println(deque);
        deque.addToLeft('d');
        System.out.println(deque);
        deque.addToRight('1');
        deque.addToRight('2');
        deque.addToRight('3');
        deque.addToRight('4');
        System.out.println(deque);
        deque.removeLeft();
        deque.removeLeft();
        deque.removeRight();
        deque.removeRight();
        deque.removeRight();
        System.out.println(deque);
        deque.removeLeft();
        System.out.println(deque);
        System.out.println(deque.peakLeft());
        System.out.println(deque.peakRight());
        System.out.println("Size: " + deque.size());

    }
}
