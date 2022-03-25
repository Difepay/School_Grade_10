/**********************
*   Theme: string     *
*       Task: 1       *
***********************/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[][] text = new String[3][3];
        getStrings(text, reader);
        printResult(text);
    }

    // Functions
    public static void getStrings(String[][] str, Scanner reader) {
        for (int i = 0, rows = str.length - 1; i < rows; i++) {
            System.out.printf("\nPlease fill text%d with 3 lines, max 10 letters in each line:\n", i + 1);
            for (int j = 0, cols = str[i].length; j < cols; j++)
                str[i][j] = reader.nextLine();
        }
    }

    public static void printResult(String[][] str) {
        int lastStringIndex = str.length - 1;
        System.out.printf("\ntext%d is:\n", lastStringIndex + 1);

        for (int i = 0, n = str[lastStringIndex].length; i < n; i++) {
            String newStr = str[0][i] + str[1][i];
            if (newStr.length() <= 10)
                str[lastStringIndex][i] = newStr;
            else
                str[lastStringIndex][i] = "";

            System.out.println(str[lastStringIndex][i]);
        }
    }
}
