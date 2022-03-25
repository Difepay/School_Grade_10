package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int matrixLen = 0;

        do {
            System.out.printf("Enter the in the multiplication table: ");
            matrixLen = reader.nextInt();
        }
        while (matrixLen < 0);

         int[][] matrix = new int[matrixLen][matrixLen];


         for (int i = 0; i < matrixLen; ++i) {
             for (int j = 0; j < matrixLen; ++j) {
                 matrix[i][j] = (i + 1) * (j + 1);
             }
         }

        for (int i = 0; i < matrixLen; ++i) {
            for (int j = 0; j < matrixLen; ++j) {
                System.out.printf("%d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
