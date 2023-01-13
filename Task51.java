//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
package Seminar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Task51 {
    
    public static void main(String[] args) {
        ArrayList<HashMap<String, ArrayList<String>>> phoneBook = new ArrayList<>();
        String[] fieldsArray = {"ID", "First Name", "Last Name", "Phone"};
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        System.out.println("User's phonebook.");
        while (flag) {
            int menuChoice = choiceMenu(input);
            switch (menuChoice) {
                case 1 -> printPhoneBook(phoneBook, fieldsArray);
                case 2 -> fillMap(input, phoneBook, fieldsArray);
                case 3 -> deleteEntry(input, phoneBook);
                case 0 -> flag = false;
            }
        }
    }

    private static void fillMap(Scanner inp, ArrayList<HashMap<String, ArrayList<String>>> book, String[] fields) {
        HashMap<String, ArrayList<String>> userInput = new HashMap<>();

        ArrayList<String> bookSize = new ArrayList<>();
        bookSize.add(String.valueOf(book.size()));
        userInput.put("ID", bookSize);

        ArrayList<String> phones = new ArrayList<>();
        String tmp = "";
        for (String field : fields) {
            if (!field.equals("ID") && !field.equals("Phone")) {
                System.out.printf("Please, fill in the field %s: ", field);
                ArrayList<String> value = new ArrayList<>();
                tmp = inp.nextLine();
                value.add(tmp);
                userInput.put(field, value);
            }
            while (field.equals("Phone")) {
                System.out.printf("Please, fill in the field %s: ", field);
                tmp = inp.nextLine();
                phones.add(tmp);
                System.out.print("Add another phone number? Y/N?: ");
                String choice = inp.nextLine().toUpperCase();
                if (choice.equals("n") || choice.equals("N")) {
                    userInput.put(field, phones);
                    break;
                }
            }
        }
        book.add(userInput);
    }

    private static void printPhoneBook(ArrayList<HashMap<String, ArrayList<String>>> book, String[] fields) {
        if (book.size() == 0) {
            System.out.println("Phone book is empty.");
        }
        for (HashMap<String, ArrayList<String>> map : book) {
            for (String field : fields) {
                if (!field.equals("Phone")) {
                    System.out.printf("%s = %s\n", field, map.get(field).get(0));
                } else {
                    for (int i = 0; i < map.get(field).size(); i++) {
                        System.out.printf("%s%d = %s\n", field, i + 1, map.get(field).get(i));
                    }
                }
            }
            System.out.println("=====");
        }
        System.out.println("");
    }

    private static int choiceMenu(Scanner inp) {
        System.out.println("");
        System.out.print("""
                Menu:
                1 - Display phone book.
                2 - Add an entry to the phone book.
                3 - Delete an entry from the phone book.
                0 - Exit
                :""");
        int choice = inp.nextInt();
        inp.nextLine();
        System.out.println("");
        return choice;
    }

    private static void deleteEntry(Scanner inp, ArrayList<HashMap<String, ArrayList<String>>> book) {
        System.out.print("Add ID for delete: ");
        int deletion = inp.nextInt();
        inp.nextLine();
        book.remove(deletion);
        System.out.println("");
    }
}
