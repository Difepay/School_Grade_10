package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Array tasks
        Scanner reader = new Scanner(System.in);

        // Task 1
        /*
        int[] height = new int[5];                              // Init array, name: height, length: 5, type: int
        int minValue = Integer.MAX_VALUE;                       // Init variable, name: minValue, type: int, value: pow(2, 31)
        int minIndex = -1;                                      // Init variable, name: minIndex, type: int, value: -1

        for (int i = 0, n = height.length; i < n; ++i)
        {
            do
            {
                System.out.printf("Enter %d height: ", i);      // Ask for enter height
                height[i] = reader.nextInt();                   // Set to current arr cell, console wrote value
            }
            while (height[i] < 0);                              // If height[i] is negative do it again

            if (height[i] < minValue)                           // If current arr cell is less than minValue (first iteration it will be true because value of minValue the max value of type int)
            {
                minValue = height[i];                           // Set minValue value to current arr cell
                minIndex = i;                                   // Set minValue value to current arr index
            }
        }

        System.out.printf("In this array: ");
        print_array(height);                                                                  // Print the array
        System.out.printf("%d is the minimal value by %d index\n", minValue, minIndex);       // Print min value in array and his index
        */


        // Task 2
        /*
        int[] arr = new int[5];                             // Init array, name: arr, length: 5, type: int

        for (int i = 0, n = arr.length; i < n; ++i)
        {
            System.out.printf("%d) Enter value: ", i);      // Ask for enter value
            arr[i] = reader.nextInt();                      // Set to current arr cell, console wrote value
        }

        System.out.print("Reversed array: [");              // Print reversed array
        for (int i = arr.length - 1; i >= 0; --i)           // Loop start from the max index of arr and end in the 0
        {
            if (i != 0)
                System.out.printf("%d, ", arr[i]);
            else                                            // If current index the last then
                System.out.printf("%d", arr[i]);            // Print without ", "
        }
        System.out.print("]");
        */


        // Task 3
        /*
        int[] arr = new int[5];                             // Init array, name: arr, length: 5, type: int

        for (int i = 0, n = arr.length; i < n; ++i)
        {
            System.out.printf("%d) Enter value: ", i);      // Ask for enter value
            arr[i] = reader.nextInt();                      // Set to current arr cell, console wrote value
        }

        System.out.printf("In this array: ");
        print_array(arr);                                                               // Print the array
        if (arr[0] == arr[arr.length - 1])                                              // If first and the last values are same
            System.out.printf("Yes, the first and the last values are same");           // Print this
        else                                                                            // Else
            System.out.printf("No, the first and the last values aren't same");         // Print this
        */


        // Task 4
        /*
        int[] valuesOfNum = new int[3];                         // Init array, name: valuesOfNum, length: 3, type: int
        int num = 0;                                            // Init variable, name: num, type: int, value: 0
        do
        {
            System.out.printf("Enter number: ", num);       // Ask for enter value
            num = reader.nextInt();                         // Set to num, console wrote value
        }
        while (num < 100 || num > 999);                     // If num is not between 100 and 999 do it again

        for (int i = 0, n = valuesOfNum.length; i < n; ++i)         // Loop with valuesOfNum.length - 1 iterations (start from 0, end at valuesOfNum.length - 1)
        {
            valuesOfNum[i] = num % 10;                              // Set to current arr cell last digit of num
            num /= 10;                                              // Remove the last digit from num
        }

        System.out.printf("Array: ");
        print_array(valuesOfNum);                           // Print array
        */


        // Task 5
        /*
        int[] arr = new int[5];                         // Init array, name: arr, length: 5, type: int
        int numberOfEven = 0;                           // Init variable, name: numberOfEven, type: int, value: 0

        for (int i = 0, n = arr.length; i < n; ++i)
        {
            System.out.printf("%d) Enter value: ", i);      // Ask for enter value
            arr[i] = reader.nextInt();                      // Set to current arr cell, console wrote value

            if (arr[i] % 2 == 0)                            // If current arr cell is even
                ++numberOfEven;                             // Add to value of numberOfEven 1
        }

        System.out.printf("In the array: ");
        print_array(arr);                                                   // Print array
        System.out.printf("%d count of even numbers", numberOfEven);        // Print number of evens in this array
        */


        // Task 6
        /*
        int[] arr = new int[7];                         // Init array, name: arr, length: 7, type: int
        int numberOfEven = 0;                           // Init variable, name: numberOfEven, type: int, value: 0
        int numberOfOdd = 0;                            // Init variable, name: numberOfOdd, type: int, value: 0

        for (int i = 0, n = arr.length; i < n; ++i)
        {
            System.out.printf("%d) Enter value: ", i);      // Ask for enter value
            arr[i] = reader.nextInt();                      // Set to current arr cell, console wrote value

            if (arr[i] % 2 == 0)                            // If current arr cell is even
                ++numberOfEven;                             // Add to value of numberOfEven 1
            else                                            // If current arr cell is odd
                ++numberOfOdd;                              // Add to value of numberOfOdd 1
        }

        System.out.printf("In the array: ");
        print_array(arr);                                                                           // Print array
        if (numberOfEven > numberOfOdd)                                                             // If count of evens bigger
            System.out.printf("More evens (%d), less odd (%d)", numberOfEven, numberOfOdd);         // Print this
        else                                                                                        // Else
            System.out.printf("More odd (%d), less evens (%d)", numberOfOdd, numberOfEven);         // Print this
        */


        // Task 7
        /*
        int num = 0;                                // Init variable, name: num, type: int, value: 0
        int digitsOfNum = 0;                        // Init variable, name: digitsOfNum, type: int, value: 0

        do
        {
            System.out.printf("Enter any positive integer: ");      // Ask to enter number
            num = reader.nextInt();                                 // Set to num, console wrote value
        }
        while (num < 0);                                            // If num is negative do it again

        int numCopy = num;                          // Init variable, name: numCopy, type: int, value: num

        while (num > 0)                             // Loop with digits of num iterations
        {
            ++digitsOfNum;                          // Every iteration to digitsOfNum will add 1
            num /= 10;                              // And will remove last digit of num
        }

        int[] reverseDigits = new int[digitsOfNum];             // Init array, name: reverseDigits, length: digitsOfNum, type: int

        for (int i = 0, n = reverseDigits.length; i < n; ++i)   // Loop with digitsOfNum iterations
        {
            reverseDigits[i] = numCopy % 10;                    // Every iteration set current arr cell value to the last digit in num
            numCopy /= 10;                                      // And remove the last digit
        }

        System.out.printf("Result array is: ");
        print_array(reverseDigits);                             // Print array reverseDigits
        */


        // Task 8
        int[] a = new int[5];                   // Init array, name: a, length: 5, type: int
        int[] b = new int[5];                   // Init array, name: b, length: 5, type: int

        for (int i = 0, n = a.length; i < n; ++i)
        {
            System.out.printf("a:%d) Enter value: ", i);        // Ask for enter value
            a[i] = reader.nextInt();                            // Set to current arr cell, console wrote value
        }

        for (int i = 0, n = b.length; i < n; ++i)
        {
            System.out.printf("b:%d) Enter value: ", i);        // Ask for enter value
            b[i] = reader.nextInt();                            // Set to current arr cell, console wrote value
        }

        if (compare_arrays(a, b))                               // If a and b are equal
            System.out.printf("The arrays are equal");          // Print this
        else                                                    // If a and b aren't equal
            System.out.printf("The arrays aren't equal");       // Print this
    }


    // Functions
    public static void print_array(int arr[])
    {
        System.out.print("[");
        for (int i = 0, n = arr.length; i < n; ++i)
        {
            if (i != n - 1)
                System.out.printf("%d, ", arr[i]);
            else
                System.out.printf("%d", arr[i]);
        }
        System.out.print("]\n");
    }

    public static boolean compare_arrays(int a[], int b[])
    {
        if (a.length != b.length)return false;

        for (int i = 0, n = a.length; i < n; ++i)
        {
            if (a[i] != b[i]) return false;
        }

        return true;
    }
}
