/**********************
*   Theme: string     *
*       Task: 4       *
***********************/

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String str = reader.nextLine();
        int[] strLens = getLengths(str);

        if (strLens == null)
            System.out.println(0);
        else
            for (int i : strLens)
                System.out.printf("%d, ", i);
        System.out.print("\b\b");
    }

    // Functions
    public static int[] getLengths(String str) {
        int sentenceCount = 0;

        for (int i = 0, n = str.length(); i < n; i++)
            if (str.charAt(i) == '.' || str.charAt(i) == '!')
                sentenceCount++;

        if (sentenceCount == 0)
            return null;

        int[] lengthsArr = new int[sentenceCount];
        int currLen = 0, currIndex = 0;

        for (int i = 0, n = str.length(); i < n; i++) {
            if (str.charAt(i) == '.' || str.charAt(i) == '!') {
                lengthsArr[currIndex] = currLen;
                currIndex++;
                currLen = -1;
            } else
                currLen++;
        }

        return lengthsArr;
    }
}