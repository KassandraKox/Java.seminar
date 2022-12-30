//К калькулятору из предыдущего дз добавить логирование.
package Seminar;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Task24 {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Task24.class.getName());
        logger.setLevel(Level.INFO);
        try {
            System.setProperty(
                    "java.util.logging.SimpleFormatter.format",
                    "[%1$tF %1$tT.%1$tL] %5$s %n");
            FileHandler ch = new FileHandler("log2.log");
            ch.setEncoding("UTF-8");
            logger.addHandler(ch);
            SimpleFormatter sFormat = new SimpleFormatter();
            ch.setFormatter(sFormat);

        } catch (IOException e) {
            e.printStackTrace();
        }

        userInput(logger);

    }

    
    public static void userInput(Logger logger) {

        boolean notCorrect = true;
        Scanner scan = new Scanner(System.in);
        String[] arr = new String[2];
        int result;

        while (notCorrect) {
            System.out.print("Введите выражение для подсчета: ");
            String input = scan.nextLine();
            logger.info("Input string: " + input);
            input = input.replace(" ", "");
            try {
                if (!input.contains("+") && !input.contains("-") && !input.contains("*") && !input.contains("/")) {
                    System.out.println("Вы не ввели символ операции (+ - * /). Повторите ввод.");
                    logger.info("No operation error. ");
                    notCorrect = true;
                } else if (input.contains("+")) {
                    arr = input.split("\\+");
                    result = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
                    System.out.println("Результат: " + result);
                    logger.info("Result: " + result);
                    notCorrect = false;
                } else if (input.contains("-")) {
                    arr = input.split("-");
                    result = Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
                    System.out.println("Результат: " + result);
                    logger.info("Result: " + result);
                    notCorrect = false;
                } else if (input.contains("*")) {
                    arr = input.split("\\*");
                    result = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
                    System.out.println("Результат: " + result);
                    logger.info("Result: " + result);
                    notCorrect = false;
                } else if (input.contains("/")) {
                    arr = input.split("/");
                    try {
                        result = Integer.parseInt(arr[0]) / Integer.parseInt(arr[1]);
                        System.out.println("Результат: " + result);
                        logger.info("Result: " + result);
                        notCorrect = false;
                    } catch (ArithmeticException e) {
                        System.out.println("Ошибка: деление на ноль. Повторите ввод.");
                        logger.info("Divizion zero error. ");
                        notCorrect = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода: неверный символ. Повторите ввод ");
                logger.info("Input error ");
                notCorrect = true;
            }
        }
    }
}