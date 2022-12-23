// Вывести все простые числа от 1 до 1000
package Seminar;

import java.util.ArrayList;

public class Task12 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            if (findNum(i)) {
                numbers.add(i);
            }
        }
        System.out.println(numbers);
    }

    private static boolean findNum(int n) {
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
