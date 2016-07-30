package com.pslin.algorithms.sort;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * While not sorted, shuffle array.
 *
 * @author plin
 */
public class BogoSort {

    public static void main(String[] args) {
        int length;
        if(args.length == 0) {
            length = 12;
        } else {
            length = Integer.parseInt(args[0]);
        }

        int[] numbers = createArray(length);
        shuffle(numbers);

        System.out.println(Arrays.toString(numbers));

        long count = 0;
        double start = System.currentTimeMillis();
        while(!isSorted(numbers)) {
            shuffle(numbers);
            count++;
        }

        System.out.println("\n" + Arrays.toString(numbers));

        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        System.out.println("Number of shuffles: " + decimalFormat.format(count));
        double time = System.currentTimeMillis() - start;
        System.out.println("Time: " + time + " ms");
        System.out.println(time / 1000 + " sec");
    }

    private static int[] createArray(int length) {
        int[] numbers = new int[length];
        for(int i=0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        return numbers;
    }

    private static void shuffle(int[] numbers) {
        Random rnd = new Random();
        for (int i = numbers.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          int a = numbers[index];
          numbers[index] = numbers[i];
          numbers[i] = a;
        }
    }

    private static boolean isSorted(int[] numbers) {
        for(int i=0; i < numbers.length-1; i++) {
            if(numbers[i] > numbers[i+1]) {
                return false;
            }
        }

        return true;
    }
}
