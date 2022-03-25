package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


        // Task 1
        /*
        System.out.println("My best friend is Nikita");
        */


        // Task 2
        /*
        System.out.println("My name is Dima");
        System.out.println("I live in Jerusalem, Pizgat zeev");
        */


        // Task 3
        /*
        System.out.printf("Write ur height in cm: ");
        int height = reader.nextInt();

        System.out.printf("%d - your height, %d - height of dwarf (4 times less)", height, height / 4);
        */


        // Task 4
        /*
        System.out.printf("Enter any number: ");
        int x = reader.nextInt();

        int smaller = x - 22;
        int bigger = x + 22;
        int mode = x % 2;

        System.out.println(smaller);
        System.out.println(bigger);
        System.out.println(mode);
        */


        // Task 5
        System.out.printf("Enter number 1: ");
        int num1 = reader.nextInt();

        System.out.printf("Enter number 1: ");
        int num2 = reader.nextInt();

        System.out.printf("Enter number 1: ");
        int num3 = reader.nextInt();

        int summ = num1 + num2 + num3;

        System.out.printf("\nSumm of the numbers - %d", summ);
    }
}
