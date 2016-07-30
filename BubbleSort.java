package com.pslin.algorithms.sort;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author plin
 */
public class BubbleSort {

    public static void main(String[] args) {
        int length;
        if(args.length == 0) {
            length = 1000;
        } else {
            length = Integer.parseInt(args[0]);
        }

        int[] numbers = ArrayUtils.createArray(length);
        ArrayUtils.shuffle(numbers);

        System.out.println(Arrays.toString(numbers));

        double start = System.currentTimeMillis();
        int count = bubblesort(numbers);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Number of swaps: " + df.format(count));
    }

    private static int bubblesort(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int x = 1; x < numbers.length - i; x++) {
                if (numbers[x - 1] > numbers[x]) {
                    int temp = numbers[x - 1];
                    numbers[x - 1] = numbers[x];
                    numbers[x] = temp;
                    count++;
                }
            }
        }

        return count;
    }
}
