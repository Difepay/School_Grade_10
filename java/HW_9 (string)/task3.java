/**********************
*   Theme: string     *
*       Task: 3       *
***********************/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a sting: ");
        System.out.println(getFirstLetters(reader.nextLine()));
    }

    // Functions
    public static String getFirstLetters(String str) {
        String[] strings = str.split(" ");
        String newStr = "";

        for (String string : strings) {
            String currChar = String.valueOf(string.charAt(0));

            if (!(newStr.toLowerCase().contains(currChar.toLowerCase())))
                newStr += string.charAt(0);
        }

        return newStr;
    }
}