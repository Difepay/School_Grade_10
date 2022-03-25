/***********************
*   Theme: string      *
*       Task: 5        *
************************/

package com.company;

public class Main {

    public static void main(String[] args) {
        long[] parts = new long[2];

        for (long i = 1; i < 10000; i++)
            if (isKaprekar(i, parts))
                System.out.println(i);
    }


    // Functions
    public static boolean isKaprekar(long num, long[] parts) {
        long powNum = num * num;
        int digitsCount = getDigits(powNum);

        int firstDigitsCount = digitsCount / 2;
        int secondDigitsCount = digitsCount - firstDigitsCount;

        long part1 = powNum / (int)(Math.pow(10, secondDigitsCount));
        long part2 = powNum % (int)(Math.pow(10, firstDigitsCount + (digitsCount % 2 == 0 ? 0 : 1)));

        if (num == part1 + part2) {
            parts[0] = part1;
            parts[1] = part2;
            return true;
        }

        return false;
    }

    public static int getDigits(long num)
    {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
