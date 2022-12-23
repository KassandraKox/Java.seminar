package Seminar;

//Реализовать простой калькулятор
import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int firstNumber = input.nextInt();
        System.out.print("Введите второе число: ");
        int secondNumber = input.nextInt();
        System.out.print("Введите оператор * / + - : ");
        String operator = input.next();
        switch (operator) {
            case "*" -> System.out.printf("%d * %d = %d", firstNumber, secondNumber, firstNumber * secondNumber);
            case "/" -> System.out.printf("%d / %d = %d", firstNumber, secondNumber, firstNumber / secondNumber);
            case "+" -> System.out.printf("%d + %d = %d", firstNumber, secondNumber, firstNumber + secondNumber);
            case "-" -> System.out.printf("%d - %d = %d", firstNumber, secondNumber, firstNumber - secondNumber);
            default -> System.out.print("Ошибка!");
        }
    }
}
