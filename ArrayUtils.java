package com.pslin.algorithms.sort;

import java.util.Random;

/**
 * @author plin
 */
public class ArrayUtils {

    public static int[] createArray(int length) {
        int[] numbers = new int[length];
        for(int i=0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        return numbers;
    }

    public static void shuffle(int[] numbers) {
        Random rnd = new Random();
        for (int i = numbers.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          int a = numbers[index];
          numbers[index] = numbers[i];
          numbers[i] = a;
        }
    }

    public static boolean isSorted(int[] numbers) {
        for(int i=0; i < numbers.length-1; i++) {
            if(numbers[i] > numbers[i+1]) {
                return false;
            }
        }

        return true;
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
