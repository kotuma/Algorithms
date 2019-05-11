package ru.geekbrains.algorithms.lesson3;

public class ProgrammStringConvertor {
    public static void main(String[] args) {
        MyArrayStack<Character> stack = new MyArrayStack<>();
        String string = new String("Маша ела кашу");
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        StringBuilder resultString = new StringBuilder();
        while(!stack.isEmpty()) {
            resultString.append(stack.pop());
        }
        System.out.println(resultString.toString());
    }
}
