package com.pslin.algorithms.sort;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * While not sorted, swap two random numbers.
 *
 * @author plin
 */
public class BozoSort {

    public static void main(String[] args) {
        int length;
        if(args.length == 0) {
            length = 13;
        } else {
            length = Integer.parseInt(args[0]);
        }

        int[] numbers = ArrayUtils.createArray(length);
        ArrayUtils.shuffle(numbers);
        System.out.println(Arrays.toString(numbers));

        long count = 0;
        double start = System.currentTimeMillis();
        while(!ArrayUtils.isSorted(numbers)) {
            swapRandom(numbers);
            count++;
        }

        System.out.println("\n" + Arrays.toString(numbers));

        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        double time = System.currentTimeMillis() - start;
        System.out.println("Time: " + time + " ms");
        System.out.println(time / 1000 + " sec");
        System.out.println("Number of shuffles: " + decimalFormat.format(count));
        System.out.println("Expected average case: " + decimalFormat.format(CombinatoricsUtils.factorial(length)));

    }

    private static void swapRandom(int[] numbers) {
        Random random = new Random();
        int a = random.nextInt(numbers.length);
        int b = random.nextInt(numbers.length);

        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

}
