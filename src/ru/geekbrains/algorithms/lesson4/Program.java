package ru.geekbrains.algorithms.lesson4;

public class Program {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.addFirst('a');
        list.addFirst('b');
        list.addFirst('c');
        list.addFirst('d');
        System.out.println("Count = " + list.size());
        System.out.println(list);
        System.out.println(list.get(1));
        list.set(1, 'F');
        System.out.println(list.get(1));
        list.addFirst('A');
        list.addLast('Z');
        System.out.println(list);
        list.add(2, '2');
        System.out.println(list);
        list.removeLast();
        list.removeFirst();
        System.out.println("Count = " + list.size());
        System.out.println(list);
        list.remove('F');
        //System.out.println(list);

        for (Character item:
             list) {
            System.out.println(item);
        }

    }

}
