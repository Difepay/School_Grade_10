/***********************
*      Theme: OOP      *
*      Task: Virus     *
************************/

package com.company;

import java.util.Scanner;

public class Main {

    // Main
    public static void main(String[] args) {
        Virus userVirus = new Virus(getVirusName(-1), getVirusCode());

        int virusesCount = getVirusesCount();
        Virus[] viruses = new Virus[virusesCount];

        for (int i = 0; i < virusesCount; i++)
            viruses[i] = new Virus(getVirusName(i), getVirusCode());

        findVirusFriend(viruses, userVirus.getCode());

    }

    // Functions
    public static int getVirusesCount()
    {
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter count of viruses to compare: ");
            int virusesCount = reader.nextInt();

            if (virusesCount > 0)
                return virusesCount;
        }
    }


    public static String getVirusName(int i)
    {
        Scanner reader = new Scanner(System.in);

        System.out.printf(i == -1 ? "Enter your virus name: " : "\nEnter virus %d name: ", i);
        return reader.next();
    }


    public static int getVirusCode()
    {
        Scanner reader = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter 3 digit virus code: ");
            int code = reader.nextInt();

            if (code >= 100 && code < 1000)
                return code;
        }
    }


    public static void findVirusFriend(Virus[] arr, int code)
    {
        int[] codeArr = {code / 100, code / 10 % 10, code % 10};

        System.out.println("\n\nHere is the list of your virus \"friends\"");
        for (Virus virus : arr)
        {
            int currCode = virus.getCode();
            int[] currArr = {currCode / 100, currCode / 10 % 10, currCode % 10};

            if (isFriend(codeArr, currArr))
                virus.printVirus();
        }
    }

    public static boolean isFriend(int[] arr1, int[] arr2)
    {
        int count = 0;

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (arr1[i] == arr2[j])
                    count++;
                if (count == 2)
                    return true;
            }
        }
        return false;
    }
}
