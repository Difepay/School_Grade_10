package com.company;

import java.util.Scanner;
import java.lang.Math;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Random1() tasks
        Scanner reader = new Scanner(System.in);
        Date DateTime = new Date();

        // Task 1
        /*
        String randomNumberStr = Integer.toString(getRandom(10000, 1));
        System.out.printf("%s - this number is %d digit", randomNumberStr, randomNumberStr.length());
        */

        // Task 2
        /*
        int number;
        do {
            System.out.printf("Enter integer (0-200): ");
            number = reader.nextInt();
        } while (number < 0 || number > 200);

        int it = getRandom(7, 1);
        System.out.printf("%d - random number (1-6)\n", it);

        for (int i = number, n = (int)(number + Math.pow(it, 2)); i < n; i += it) System.out.printf("%c\n", i);
        */

        // Task 3
        /*
        String[] namesOfCards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String currentCard;

        do {
            System.out.printf("Enter your card (for example - heart 11): ");
            currentCard = reader.nextLine();
        } while (Integer.parseInt(currentCard.split(" ")[1]) < 2 || Integer.parseInt(currentCard.split(" ")[1]) > 14);
        currentCard = currentCard.toLowerCase();

        int cardIndex = Integer.parseInt(currentCard.split(" ")[1]);
        String cardType = currentCard.split(" ")[0];
        cardType = cardType.substring(0, 1).toUpperCase() + cardType.substring(1);

        if (cardType.equals("Dimond") || cardType.equals("Heart") || cardType.equals("Spade") || cardType.equals("Club")) System.out.printf("%s %s\n", namesOfCards[cardIndex-2], cardType);
        else System.out.printf("This card doen't exist!\n");
        */

        // Task 4
        /*
        int currentYear = DateTime.getYear() + 1900;
        System.out.printf(getTypeOfYear(currentYear) ? "%d - is leap year" : "%d - is not leap year", currentYear);
        */

        // Task 5
        byte[] cubeValues = get2Values((byte)7, (byte)1);
        int result = cubeValues[0] == cubeValues[1] ? (cubeValues[0] + cubeValues[1]) * 2 : (cubeValues[0] + cubeValues[1]);

        System.out.printf("%d : %d\n", cubeValues[0], cubeValues[1]);

        if (cubeValues[0] != cubeValues[1]) System.out.printf("First checker can be mooved by %d steps and second checker can be mooved by %d steps\nOr only one checker can be mooved by %d steps\n", cubeValues[0], cubeValues[1], result);
        else System.out.printf("First checker can be mooved by %d steps twice and second checker can be mooved by %d steps twice\nOr only one checker can be mooved by %d steps\n", cubeValues[0], cubeValues[1], result);
    }


    // Functions
    public static int getRandom(int max, int min) {
        return (int)(Math.floor(Math.random() * (max - min)) + min);
    }

    public static boolean getTypeOfYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static byte[] get2Values(byte max, byte min) {
        byte[] values = {(byte)(Math.floor(Math.random() * (max - min)) + min), (byte)(Math.floor(Math.random() * (max - min)) + min)};
        return values;
    }
}
