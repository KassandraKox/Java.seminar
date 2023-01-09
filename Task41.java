package Seminar;

/*Пусть дан LinkedList с несколькими элементами.
Реализуйте метод, который вернет “перевернутый” список. */

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class Task41 {

    public static void main(String[] args) {
        ThreadLocalRandom randomNum = ThreadLocalRandom.current();
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(randomNum.nextInt(0, 10));
        }
        System.out.println(arr);
        reverseArray(arr);
        System.out.println(arr);
    }

    private static void reverseArray(LinkedList<Integer> array) {
        for (int i = 0; i < (array.size() + 1) / 2; i++) {
            int temp = array.get(i);
            array.set(i, array.get(array.size() - 1 - i));
            array.set(array.size() - 1 - i, temp);
        }
    }
}