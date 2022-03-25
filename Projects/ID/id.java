package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //int id = getId();
        int counter = 0;

        for (int i = 100000000; i < 1000000000; i++)
        {
            int id = i;
            boolean isLegal = isIdLegal(id);

            if (isLegal)
            {
                counter++;
            }
        }

        System.out.print(counter);

    }

    public static int getId()
    {
        Scanner reader = new Scanner(System.in);
        String str;

        do {
            System.out.printf("Enter id (9 digits): ");
            str = reader.nextLine();
        }
        while (str.length() != 9);

        return Integer.parseInt(str);
    }

    public static boolean isIdLegal(int id)
    {
        int summ = 0;
        byte[] idArr = convertToArr(id);

        for (int i = 0, n = (idArr.length - 1); i < n; i++)
            summ += addToSum(idArr[i], i);

        return 0 == (summ + idArr[idArr.length - 1]) % 10;
    }

    public static byte[] convertToArr(int id)
    {
        byte[] arr = new byte[9];

        for (int i = arr.length - 1; i >= 0; i--)
        {
            arr[i] = (byte)(id % 10);
            id /= 10;
        }

        return arr;
    }

    public static int addToSum(byte idNum, int index)
    {
        int comp = ((index % 2) + 1) * idNum;
        if (comp > 9)
            return (comp % 10) + (comp / 10);
        return comp;
    }
}
