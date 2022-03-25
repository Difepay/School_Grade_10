/***********************
*   Theme: string      *
*       Task: 2        *
************************/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] stringArr = new String[5];
        boolean[] result = new boolean[5];
        resetBool(result);

        getStrings(stringArr, reader);
        int maxLength = getNumber(5, 20, reader);

        System.out.printf("Count of names that shorter than %d is %d\n", maxLength, getCount(stringArr, maxLength, result));
        printIndexes(result);
    }

    // Functions
    public static int getCount(String[] strings, int maxLength, boolean[] result) {
        int counter = 0;

        for (int i = 0, n = strings.length; i < n; i++) {
            if (strings[i].length() < maxLength) {
                counter++;
                result[i] = true;
            }
        }

        return counter;
    }

    public static void resetBool(boolean[] result) {
        for (int i = 0, n = result.length; i < n; i++)
            result[i] = false;
    }

    public static void getStrings(String[] strings, Scanner reader) {
        for (int i = 0, n = strings.length; i < n; i++) {
            System.out.printf("Enter %d string: ", i);
            strings[i] = reader.nextLine();
        }
    }

    public static int getNumber(int min, int max, Scanner reader) {
        while (true) {
            System.out.printf("Enter a number between %d-%d: ", min, max);

            int number = reader.nextInt();
            if (number >= min && number <= max)
                return number;
        }
    }

    public static void printIndexes(boolean[] result) {
        System.out.print("There are indexes:");
        for (int i = 0, n = result.length; i < n; i++)
            if (result[i])
                System.out.printf(" %d,", i);
        System.out.print("\b");
    }
}
