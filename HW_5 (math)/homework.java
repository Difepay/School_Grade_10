package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Math tasks
        Scanner reader = new Scanner(System.in);

        // Task 1
        /*
        int height1 = 0;
        int height2 = 0;

        do
        {
            System.out.printf("Enter first height: ");
            height1 = reader.nextInt();
        }
        while (height1 < 0);
        do
        {
            System.out.printf("Enter second height: ");
            height2 = reader.nextInt();
        }
        while (height2 < 0);

        int difference = Math.abs(height1 - height2);
        System.out.printf("The difference of heights is %d", difference);
        */


        // Task 2
        /*
        int[] grades = new int[4];
        int maxGrade = -1;
        float averageGrade = 0;

        for (int i = 0, n = grades.length; i < n; ++i)
        {
            do
            {
                System.out.printf("%d) Enter grade: ", i);
                grades[i] = reader.nextInt();
            }
            while (grades[i] < 0 || grades[i] > 100);

            if (grades[i] > maxGrade)
                maxGrade = grades[i];

            averageGrade += grades[i];
        }
        averageGrade /= grades.length;

        System.out.printf("Max grade: %d\n", maxGrade);
        System.out.printf("Average grade: %d\n", Math.round(averageGrade));

        for (int i = 0, n = grades.length; i < n; ++i)
        {
            System.out.printf("%d) Diffrence is: %d\n", i+1, Math.abs(Math.round(averageGrade) - grades[i]));
        }
        */


        // Task 3
        /*
        int x = 0;

        for (int i = 0; i < 27; ++i)
        {
            System.out.printf("%d) Enter x: ", i);
            x = reader.nextInt();
            int y = ((int)Math.pow(x, 3) + 6 * (int)Math.pow(x, 2) - 10);
            System.out.printf("When x is %d - y is %d\n", x, y);
        }
        */


        // Task 4
        /*
        int x = 0;

        while (true)
        {
            System.out.printf("Enter x: ");
            x = reader.nextInt();

            if (x > -2 && x < 6)
                break;
            else {
                double y = Math.sqrt((int) Math.pow(x, 2) - 4 * x - 12);
                System.out.printf("When x is %d - y is %f\n", x, y);
            }
        }
        */


        // Task 5
        /*
        int num = 0;
        int result = 0;

        do
        {
            System.out.printf("Enter number bigger than 10000: ");
            num = reader.nextInt();
        }
        while (num <= 10000);

        // First way
        result = Math.round((float)num / 100) * 100;

        // Second way


        System.out.printf("Result is %d", result);
        */


        // Task 6
        /*
        System.out.println(Math.min(7, Math.min(2, Math.min(3, Math.min(4, 6)))));
        */


        // Task 7
        /*
        float price = 0;
        do {
            System.out.printf("Enter price (for example 10.99): ");
            price = reader.nextFloat();
        }
        while (price < 0);

        int agorots = (int)(price * 100 % 100);
        int shekels = (int)price;

        System.out.printf("Shekels: %d\nAgorot: %d\n", shekels, agorots);
        */


        // Task 8
        /*
        int radius = 0;
        do {
            System.out.printf("Enter radius: ");
            radius = reader.nextInt();
        }
        while (radius < 0);

        float P = (float)(Math.PI * 2 * radius);
        float S = (float)(Math.PI * (int)Math.pow(radius, 2));
        float S_P = (float)(Math.PI * (int)Math.pow(radius, 2) * 4);
        float V = (float)(Math.PI * (int)Math.pow(radius, 3) * 4 / 3);

        System.out.printf("P is %.2f\nS is %.2f\nS_P is %.2f\nV is %.2f\n", P, S, S_P, V);
        */


        // Task 9
        /*
        int a = 0, b = 0, c = 0;
        do
        {
            System.out.printf("Enter first length: ");
            a = reader.nextInt();
        }
        while (a <= 0);
        do
        {
            System.out.printf("Enter second length: ");
            b = reader.nextInt();
        }
        while (b <= 0);
        do
        {
            System.out.printf("Enter third length: ");
            c = reader.nextInt();
        }
        while (c <= 0);

        if (a + b < c || a + c < b || b + c < a)
            System.out.printf("This threangle doesn't exist!");
        else
        {
            int p = (a + b + c) / 2;
            int S = (int)Math.sqrt(p * (p - a) * (p - b) * (p - c));

            System.out.printf("The Square of this threangele is %d", S);
        }
        */


        // Time bonus
        float time1 = 0;
        float time2 = 0;

        do
        {
            System.out.printf("Enter first time (for example 10.30): ");
            time1 = reader.nextFloat();
        }
        while (time1 < 0 || (int)time1 >= 24 || (time1 * 100 % 100) >= 60);

        do
        {
            System.out.printf("Enter second time (for example 6.30): ");
            time2 = reader.nextFloat();
        }
        while (time2 < 0 || (int)time2 >= 24 || (time2 * 100 % 100) >= 60);

        float result = time_difference(time1, time2);
        float secondResult = time_difference(24f, result);

        System.out.printf("Time difference is %d hours and %d minutes\n", (int)result, (int)(result * 100 % 100));
        System.out.printf("But it can be also %d hours and %d minutes", (int)secondResult, (int)(secondResult * 100 % 100));
    }


    // Functions
    public static float time_difference(float t1, float t2)
    {
        int hours = Math.abs((int)t1 - (int)t2);
        int minutes = t1 > t2 ? (int)(t1 * 100 % 100) - (int)(t2 * 100 % 100) : (int)(t2 * 100 % 100) - (int)(t1 * 100 % 100);

        if (minutes < 0) {
            --hours;
            minutes += 60;
        }

        return (hours * 100 + minutes) / 100f;
    }
}
