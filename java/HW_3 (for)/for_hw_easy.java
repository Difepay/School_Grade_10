package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


        // Task 1
        /*
        System.out.printf("\nWrite positive number: ");
        int num = reader.nextInt();

        for (int i = (num - 1); i > 0; i--) {
            System.out.printf("\n%d", i);
        }
        */


        // Task 2
        /*
        System.out.printf("\nWrite positive number: ");
        int num = reader.nextInt();

        for (int i = (num - 1); i > 0; i--) {
            if (i % 2 == 0) {
                System.out.printf("\n%d", i);
            }
            else {
                continue;
            }
        }
        */


        // Task 3
        /*
        System.out.printf("\nWrite positive number: ");
        int num = reader.nextInt();

        for (int i = (num - 1); i > 0;  i--) {
            if (i % 2 != 0) {
                System.out.printf("\n%d", i);
            }
            else {
                continue;
            }
        }
        */


        // Task 4
        /*
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter number %d: ", i);
            arr[i] = reader.nextInt();
        }

        int maxNumber = arr[0];

        for (int i : arr) {
            if (i > maxNumber) {
                maxNumber = i;
            }
            else {
                continue;
            }
        }

        System.out.printf("\nThe max number is - %d", maxNumber);
        */


        // Task 5
        /*
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter number %d: ", i);
            arr[i] = reader.nextInt();
        }

        int minNumber = arr[0];

        for (int i : arr) {
            if (i < minNumber) {
                minNumber = i;
            }
            else {
                continue;
            }
        }

       System.out.printf("\nThe min number is - %d", minNumber);
       */


        // Task 6
        /*
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter number %d: ", i);
            arr[i] = reader.nextInt();
        }

        int maxNumber = arr[0];
        int maxIndex = 0;

        for (int i : arr) {
            if (i > maxNumber) {
                maxNumber = i;
                maxIndex++;
            }
            else {
                continue;
            }
        }

        System.out.printf("\nIndex of the max number is - %d", maxIndex);
        */


        // Task 7
        /*
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Enter number %d: ", i);
            arr[i] = reader.nextInt();
        }

        int minNumber = arr[0];
        int minIndex = 0;

        for (int i : arr) {
            if (i < minNumber) {
                minNumber = i;
                minIndex++;
            }
            else {
                continue;
            }
        }

        System.out.printf("\nIndex of the min number is - %d", minIndex);
        */


        // Task 8
        int[] weights = new int[5];

        int maxWeight = 0;
        int maxIndex = -1;

        for (int i = 0; i < weights.length; i++) {
            System.out.printf("Enter weight of the %d student: ", i+1);
            weights[i] = reader.nextInt();

            if (weights[i] < 50 && weights[i] > maxWeight) {
                maxWeight = weights[i];
                maxIndex = i;
            }
        }

        if (maxIndex == -1) {
            System.out.printf("All guys are really fat");
        }
        else {
            System.out.printf("The fattest guy which weight is under than 50kg weight - %d, and his index - %d", maxWeight, maxIndex);
        }
    }
}
