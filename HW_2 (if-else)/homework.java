package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);


        // Task 1
        /*
        System.out.print("Write first jump length: ");
        double jump1 = reader.nextDouble();

        System.out.println("Write second jump length: ");
        double jump2 = reader.nextDouble();

        System.out.println("Write 3rd jump length: ");
        double jump3 = reader.nextDouble();

        if (jump1 < 4 || jump2 < 4 || jump3 < 4) {
            System.out.printf("You failed!\n");
        } else {
            if ( (jump1 + jump2 + jump3) / 3 > 5) {
                System.out.printf("Success. Go to the tournament!\n");
            } else {
                System.out.printf("Success. But don't go to the tournament!\n");
            }
        }
        */


        // Task 2
        /*
        System.out.print("Write count of children: ");
        int children = reader.nextInt();

        System.out.print("Write count of containers with 11 candies: ");
        int cand11 = reader.nextInt();

        System.out.print("Write count of containers with 25 candies: ");
        int cand25 = reader.nextInt();

        int remains =  (cand11 * 11) + (cand25 * 25) - children * 3;

        if ( (cand11 * 11) + (cand25 * 25) >= children * 3) {
            System.out.printf("\nEnough, and remains " +  remains + " candies");
        } else {
            System.out.printf("\nNot enough");
        }
        */


        // Task 3
        /*
        System.out.print("Write number of students: ");
        int students = reader.nextInt();

        System.out.print("Write number of teachers: ");
        int teachers = reader.nextInt();

        int people = students + teachers;

        if (people < 51 || people == 51) {
            System.out.printf("\nThey need 1 bus");
        } else  {
            int buses = people / 51;

            if (people % 51 != 0) {
                System.out.printf("\nThey need " + (buses + 1) + " buses");
            } else {
                System.out.printf("\nThey need " + buses + " buses");
            }
        }
        */


        // Task 4
        /*
        System.out.print("Write a card number: ");
        int cardNum = reader.nextInt();

        if (cardNum % 100 == 25) {
            System.out.printf("\nYou won 111 ILS!");
        } else if (cardNum % 100 == 33) {
            System.out.printf("\nYou won 251 ILS!");
        } else {
            System.out.printf("\nNot today my friend!");
        }
        */

        // The last task
        int madrihim = 0;

        System.out.print("Write count of the young children: ");
        int youngCount = reader.nextInt();

        System.out.print("Write count of the old children: ");
        int oldCount = reader.nextInt();

        madrihim = youngCount % 10 == 0 ? youngCount / 10 : (youngCount / 10) + 1;
        madrihim += oldCount % 15 == 0 ? oldCount / 15 : (oldCount / 15) + 1;

        System.out.printf("\nCount of madrihim - " + madrihim);
    }
}
