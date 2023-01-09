package Seminar;

//Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task32 {
    
    public static void main(String[] args) {
        ThreadLocalRandom randomNum = ThreadLocalRandom.current();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(randomNum.nextInt(0, 10));
        }
        System.out.printf("Array: %s\n", arr);
        arr.removeIf(integer -> integer % 2 == 0);
        System.out.printf("Edited array: %s", arr);
    }
}
