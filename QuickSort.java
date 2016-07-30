package com.pslin.algorithms.sort;

import java.util.Arrays;

/**
 * @author plin
 */
public class QuickSort {

    public static void main(String[] args) {
        int length;
        if(args.length == 0 ) {
            length = 10000;
        } else {
            length = Integer.parseInt(args[0]);
        }

        int[] numbers = ArrayUtils.createArray(length);
        ArrayUtils.shuffle(numbers);

        System.out.println(Arrays.toString(numbers));

        long start = System.currentTimeMillis();
        quicksort(numbers, 0, numbers.length - 1);
        long totalTime = System.currentTimeMillis() - start;

        System.out.println(Arrays.toString(numbers));
        System.out.println("Time: " + totalTime + " ms");
    }

    private static void quicksort(int[] numbers, int pivot, int range) {
        if (pivot < range) {
            int q = partition(numbers, pivot, range);
            quicksort(numbers, pivot, q);
            quicksort(numbers, q + 1, range);
        }
    }

    private static int partition(int[] a, int pivot, int range) {

        int x = a[pivot];
        int i = pivot - 1;
        int j = range + 1;

        while (true) {
            i++;
            while (i < range && a[i] < x)
                i++;
            j--;
            while (j > pivot && a[j] > x)
                j--;

            if (i < j)
                ArrayUtils.swap(a, i, j);
            else
                return j;
        }
    }
}
