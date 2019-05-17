package ru.geekbrains.algorithms.lesson5;

public class MyDegree {
    public static int degree(int a, int degree){
        int res = a;
        if (degree == 0) {
            return 1;
        }
        if (degree == 1) {
            return res;
        }
        int n = 2;
        int half = a;
        while (n <= degree) {
            if (n % 2 == 0) {
                res = half * half;
            }
            else {
                half = half * a;
                res *= a;
            }
            n++;
        }
        return res;

    }
}
