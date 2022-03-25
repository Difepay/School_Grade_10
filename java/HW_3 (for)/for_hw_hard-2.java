package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Anouther tasks

        
        // Task 1
        /*
        System.out.print("Write all buyed disks il: ");
        int countIl=reader.nextInt();
        System.out.print("Write all buyed disks en: ");
        int countEn=reader.nextInt();countIl=(500*countIl)/(countEn+countIl);countEn=500-countIl;
        System.out.print("\nWrite price for one disk il ($): ");
        float priceIl = reader.nextFloat()*countIl;
        System.out.print("Write price for one disk en ($): ");
        float priceEn = reader.nextFloat()*countEn;

        System.out.printf("\nFrom the 500 disks %d are Israel's and all their price is - %.2f$",countIl,Math.round(priceIl*100.0)/100.0);
        System.out.printf("\nFrom the 500 disks %d are other countrie's and all their price is - %.2f$\n\n",countEn,Math.round(priceEn*100.0)/100.0);
        System.out.printf(Math.round(priceIl*100.0)/100.0>Math.round(priceEn*100.0)/100.0 ? "Israel disks are more profitable":"Other countries disks are more profitable");
        */


        // Task 2
        /*
        int[] grades = new int[30];
        int averageHighGrade = 0, countHighGrade = 0;
        int maxLowGrade = 0, indexLowGrade = -1;

        for (int i = 0, n = grades.length; i < n; i += 2) {
            do {System.out.printf("\n%d) Lesson average grade: ",(i/2)+1);grades[i] = reader.nextInt();} while (grades[i] < 0 || grades[i] > 100);
            do {System.out.printf("Lesson complexity (3,4 or 5): ");grades[i + 1] = reader.nextInt();} while (grades[i + 1] < 3 || grades[i + 1] > 5);
        }
        for (int i = 1, n = grades.length; i < n; i += 2) {
            if (grades[i]==4 || grades[i]==5) {averageHighGrade += grades[i-1];countHighGrade++;}
            else {if (maxLowGrade < grades[i-1]) {maxLowGrade = grades[i-1];indexLowGrade = 0;}}
        }
        System.out.printf(averageHighGrade / countHighGrade > 85 ? "\nYou will get certificate of appreciation (%d)\n":"\nYour grade is too small to get certificate of appreciation (%d)\n",averageHighGrade/countHighGrade);
        System.out.printf(indexLowGrade != -1 ? "The max grade (3 complexity) is - %d": "All your lessons complexities are 4 and 5!",maxLowGrade);
        */


        // Task 3
        /*
        int[] trips = new int[100];
        int[] parties = new int[100];
        int[] films = new int[100];

        int countStudentPartAll = 0, countStudentPartTwo = 0, countStudentPartThird = 0, countStudentPartTravel = 0;

        for (int i = 0,n = trips.length; i < n; i++) {
            System.out.printf("Student %d:\n", i+1);
            do {System.out.printf("\tCount of trips: ");trips[i] = reader.nextInt();} while (trips[i]<0);
            do {System.out.printf("\tCount of parties: ");parties[i] = reader.nextInt();} while (parties[i]<0);
            do {System.out.printf("\tCount of films: ");films[i] = reader.nextInt();} while (films[i]<0);
        }
        for (int i = 0,n = trips.length; i < n; i++) {if (trips[i]>0 && parties[i]>0 && films[i]>0) countStudentPartAll++;else if ((trips[i]>0 && parties[i]>0) || (trips[i]>0 && films[i]>0) || (parties[i]>0 && films[i]>0)) countStudentPartTwo++;}
        for (int i = 0,n = trips.length; i < n; i++) if (trips[i]>3 || parties[i]>3 || films[i]>3) countStudentPartThird++;
        for (int i = 0,n = trips.length; i < n; i++) if (trips[i] > parties[i]) countStudentPartTravel++;

        System.out.printf("\n%d - count of students that also traveled in trips, also danced at parties and also watched films\n", countStudentPartAll);
        System.out.printf("%d - count of students that participated 2 things from 3\n", countStudentPartTwo);
        System.out.printf("%d - count of students that participated at least 1 thing more than 3 times\n", countStudentPartThird);
        System.out.printf("%d - count of students that traveled in trips more than danced in parties\n", countStudentPartTravel);
        */


        // Task 4
        /*
        System.out.printf("Number of people that passed the exam: ");
        int peopleCount = reader.nextInt(), peopleFailed = 0;

        int[] mistakes = new int[peopleCount*2];
        for (int i = 0, n = mistakes.length; i<n; i+=2) {
            System.out.printf("%d) Human:\n",(i/2)+1);
            do {System.out.printf("\tCount of road sign mistakes: ");mistakes[i]=reader.nextInt();} while(mistakes[i] < 0);
            do {System.out.printf("\tCount of other mistakes: ");mistakes[i+1]=reader.nextInt();} while(mistakes[i+1] < 0);
            if (mistakes[i]>0 || mistakes[i+1]>3) peopleFailed++;
        }
        System.out.printf("\n%d - count of people who failed", peopleFailed);
        */


        // Task 5
        /*
        int[] familyBoys = new int[25];
        int[] familyGirls = new int[25];

        int balancedFamily = 0, girlsFamily = 0;

        for (int i = 0, n = familyBoys.length; i < n; i++) {
            System.out.printf("%d) Family:\n", i+1);
            do{System.out.printf("\tCount boys: "); familyBoys[i] = reader.nextInt();} while(familyBoys[i]<0);
            do{System.out.printf("\tCount girls: "); familyGirls[i] = reader.nextInt();} while(familyGirls[i]<0);

            if (familyBoys[i] == familyGirls[i] && familyBoys[i] != 0) balancedFamily++;
            else if (familyBoys[i] == 0 && familyGirls[i] > 0) girlsFamily++;
        }

        System.out.printf("\n%d - count of balanced families\n", balancedFamily);
        System.out.printf("%d - count of families with only girls\n", girlsFamily);
        */


        // Task 6
        String listOfExcellentNames = "", listOfNames = "";
        int countOfExcellent = 0;

        for (int i = 0; i < 500; i++) {
            Scanner in = new Scanner(System.in);

            System.out.printf("Write student name: ");
            String currentName = in.nextLine();

            int summ = 0, count = 0, currentGrade, average;

            while (true) {
                System.out.printf("\tWrite %s's grade (1-100): ", currentName);
                currentGrade = reader.nextInt();

                if (currentGrade == 999) break;
                else {count++;summ += currentGrade;}
            }

            average = Math.round(summ / count);

            if (average > 93) {
                listOfExcellentNames += (currentName + " : " + average + "\n");
                countOfExcellent++;
            }

            listOfNames += (currentName + " : " + average + "\n");
        }

        System.out.printf("List of the all students:\n%s\n", listOfNames);
        System.out.printf("List of the excellent students:\n%s\n", listOfExcellentNames);
        System.out.printf("College spent %d ils for the prizes\n", countOfExcellent * 1000);
    }
}
