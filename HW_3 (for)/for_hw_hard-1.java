package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        // Task 1
        //for (int i=1; i<=100; i++) System.out.printf("%d\n",i);

        // Task 2
        //for (int i=100; i>=1; i--) System.out.printf("%d\n",i);

        // Task 3
        //for (int i=1; i<=100; i++) if (i%2==0) System.out.printf("%d\n",i);else continue;

        // Task 4
        //for (int i=1; i<=100; i++) if (i%2!=0) System.out.printf("%d\n",i);else continue;

        // Task 5
        //for (int i=1; i <= 100; i++) if (i%3==0) System.out.printf("%d\n",i);else continue;

        // Task 6
        //for (int i=1; i <= 100; i++) if (i%2==0 && i%3==0) System.out.printf("%d\n",i);else continue;

        // Task 7
        /*int num = reader.nextInt();
        for (int i=num-1; i>0; i--) System.out.printf("%d\n",i);*/

        // Task 8
        /*int num = reader.nextInt();
        for (int i=num-1; i>0; i--) if (i%2==0) System.out.printf("%d\n",i);else continue;*/

        // Task 9
        /*int num = reader.nextInt();
        for (int i=num-1; i>0; i--) if (i%2!=0) System.out.printf("%d\n",i);else continue;*/

        // Task 10
        /*int[] arr = new int[10];
        for (int i=0, n=arr.length; i<n; i++) arr[i]=reader.nextInt();
        for (int i:arr) if (i>50) System.out.printf("%d\n",i);*/

        // Task 11
        /*int[] arr = new int[10];
        for (int i=0, n=arr.length; i<n; i++) arr[i]=reader.nextInt();
        for (int i:arr) if (i>50 && i<100) System.out.printf("%d\n",i);*/

        // Task 12
        /*int[] arr = new int[10];
        for (int i=0, n=arr.length; i<n; i++) arr[i]=reader.nextInt();
        for (int i:arr) if (i>50 && i<100 &&i%2==0) System.out.printf("%d\n",i);*/

        // Task 13
        /*int[] arr = new int[10]; int counter = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]>20) counter++;else continue;}
        System.out.printf("\n%d numbers are bigger than 20\n", counter);*/

        // Task 14
        /*int[] arr = new int[10]; int counter = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]<20) counter++;else continue;}
        System.out.printf("\n%d numbers are less than 20\n", counter);*/

        // Task 15
        /*int[] arr = new int[10]; int counter = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]>10 && arr[i]<20) counter++;else continue;}
        System.out.printf("\n%d numbers are less than 20 are less than 20 and bigger than 10\n", counter);*/

        // Task 16
        /*int[] arr = new int[10]; int counter = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]>10 && arr[i]<40 && arr[i]%2==0) counter++;else continue;}
        System.out.printf("\n%d numbers are less than 40, bigger than 10 and even\n", counter);*/

        // Task 17
        /*int[] arr = new int[5]; int summ = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); summ+=arr[i];}
        System.out.printf("\n%d - summ of numbers\n",summ);*/

        // Task 18
        /*int[] arr = new int[10]; int summ = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]>20) summ+=arr[i];else continue;}
        System.out.printf("\n%d - summ of number are bigger than 20\n",summ);*/

        // Task 19
        /*int[] arr = new int[10]; int summ = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]<20) summ+=arr[i];else continue;}
        System.out.printf("\n%d - summ of number are less than 20\n",summ);*/

        // Task 20
        /*int[] arr = new int[10]; int summ = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]>10 && arr[i]<30) summ+=arr[i];else continue;}
        System.out.printf("\n%d - summ of number are less than 30 and bigger than 10\n",summ);*/

        // Task 21
        /*int[] arr = new int[10]; int summ = 0;
        for (int i=0, n=arr.length; i<n; i++) {arr[i]=reader.nextInt(); if (arr[i]>10 && arr[i]<30 && arr[i]%2==0) summ+=arr[i];else continue;}
        System.out.printf("\n%d - summ of number are less than 30, bigger than 10 and even\n",summ);*/

        // Task 22
        /*int[] arr = new int[10]; int maxNumber = arr[0];
        for (int i=0, n=arr.length; i<n; i++) {arr[i] = reader.nextInt(); if (arr[i]>maxNumber) maxNumber=arr[i]; else continue;}
        System.out.printf("\n%d - the max number",maxNumber);*/

        // Task 23
        /*int[] arr = new int[10]; int minNumber = arr[0];
        for (int i=0, n=arr.length; i<n; i++) {arr[i] = reader.nextInt(); if (arr[i]<minNumber) minNumber=arr[i]; else continue;}
        System.out.printf("\n%d - the min number",minNumber);*/

        // Task 24
        /*int[] weights = new int[5]; int maxWeight = 0; int maxIndex = -1;
        for (int i=0, n=weights.length; i<n; i++) {weights[i] = reader.nextInt(); if (weights[i]<50 && weights[i]>maxWeight) {maxWeight = weights[i]; maxIndex = i;}}
        System.out.printf(maxIndex==-1 ? "All guys are really fat" : "The fattest guy which weight is under than 50kg weight - %d, and his index - %d", maxWeight, maxIndex);*/

        // Task 25
        /*char chr = reader.next().charAt(0);
        for (int i=0; i<10; i++) System.out.printf("%c\n", chr);*/

        // Task 26
        String str = reader.nextLine(); str = str.split("")[0]; int it = str.matches("-?\\d+(\\.\\d+)?") ? 20 : str.toLowerCase() == str ? 5 : 10;
        for (int i=0; i<it; i++) System.out.printf("%s\n", str);
    }
}
