package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.lang.Character;
import java.lang.String;

public class Main
{
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        // Task 1
        /*int i = 1;
        while (i<=100) {System.out.println(i); i++;}*/

        // Task 2
        /*int i = 100;
        while (i>=1) {System.out.println(i); i--;}*/

        // Task 3
        /*int i = 1;
        while (i<=100) {if (i%2==0) {System.out.println(i);} i++;}*/

        // Task 4
        /*int i = 1;
        while (i<=100) {if (i%2!=0) {System.out.println(i);} i++;}*/

        // Task 5
        /*int i = 1;
        while (i<=100) {if (i%3==0) {System.out.println(i);} i++;}*/

        // Task 6
        /*int i = 1;
        while (i<=100) {if (i%2==0 && i%3==0) {System.out.println(i);} i++;}*/

        // Task 7
        /*int i = reader.nextInt()-1;
        while (i>0) {System.out.println(i); i--;}*/

        // Task 8
        /*int i = reader.nextInt()-1;
        while (i>0) {if(i%2==0) {System.out.println(i);} i--;}*/

        // Task 9
        /*int i = reader.nextInt()-1;
        while (i>0) {if(i%2!=0) {System.out.println(i);} i--;}*/

        // Task 10
        /*while (true) {int i = reader.nextInt(); if (i == 999) break; else if (i>50) System.out.println(i);}*/

        // Task 11
        /*while (true) {int i = reader.nextInt(); if (i == 999) break; else if (i>50 && i<100) System.out.println(i);}*/

        // Task 12
        /*while (true) {int i = reader.nextInt(); if (i == 999) break; else if (i>50 && i<100 && i%2==0) System.out.println(i);}*/

        // Task 13
        /*int counter = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(counter); break;} else if (i>20) counter++;}*/

        // Task 14
        /*int counter = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(counter); break;} else if (i<20) counter++;}*/

        // Task 15
        /*int counter = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(counter); break;} else if (i<20 && i>10) counter++;}*/

        // Task 16
        /*int counter = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(counter); break;} else if (i<40 && i>10 && i%2!=0) counter++;}*/

        // Task 17
        /*int summ = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(summ); break;} else summ+=i;}*/

        // Task 18
        /*int summ = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(summ); break;} else if (i>20) summ+=i;}*/

        // Task 19
        /*int summ = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(summ); break;} else if (i<20) summ+=i;}*/

        // Task 20
        /*int summ = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(summ); break;} else if (i>30 && i<20) summ+=i;}*/

        // Task 21
        /*int summ = 0;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(summ); break;} else if (i>30 && i<20 && i%2==0) summ+=i;}*/

        // Task 22
        /*int maxNum=-999;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(maxNum); break;} else if (maxNum<i) maxNum = i;}*/

        // Task 23
        /*int minNum=999;
        while (true) {int i = reader.nextInt(); if (i == 999) {System.out.println(minNum); break;} else if (minNum>i) minNum = i;}*/

        // Task 24
        /*int[] weights = new int[40]; int i=0, maxWeight=-1;
        while (i<weights.length) {do {System.out.printf("%d) Students weight: ",i+1); weights[i]=reader.nextInt();} while(weights[i]<0); if (maxWeight<weights[i] && weights[i]<50) {maxWeight=weights[i];}i++;}
        System.out.printf(maxWeight==-1?"All guys are really fat":"The fattest guy which weight is under than 50kg weight - %dkg", maxWeight);*/

        // Task 25
        /*char chr = reader.next().charAt(0); int i=0;
        while (i<10) {System.out.printf("%c\n", chr); i++;}*/

        // Task 26
        String str = reader.nextLine(); str = str.split("")[0]; int it = str.matches("-?\\d+(\\.\\d+)?") ? 20 : str.toLowerCase() == str ? 5 : 10; int i = 0;
        while (i<it) {System.out.printf("%s\n", str); i++;}
    }
}
