 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingalgorithms;

/**
 *
 * @author SARAH
 */
import java.util.Random;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int[] sizes = {100, 10000, 1000000};

        for (int n : sizes) {
            System.out.println("\n===============================");
            System.out.println("Array Size: " + n);
            System.out.println("===============================");

            int[] sorted = generateSorted(n);
            int[] reversed = generateReversed(n);
            int[] random = generateRandom(n);
            int[] almost = generateAlmostSorted(n);

            compareAlgorithms("Sorted", sorted);
            compareAlgorithms("Reverse", reversed);
            compareAlgorithms("Random", random);
            compareAlgorithms("Almost Sorted", almost); 
        }
    }

    public static void compareAlgorithms(String type, int[] arr) {
        System.out.println("\n--- " + type + " Input ---");

        // Quick Sort
        int[] qArr = arr.clone();
        QuickSort.count = 0;
        long start = System.nanoTime();
        QuickSort.quickSort(qArr, 0, qArr.length - 1);
        long end = System.nanoTime();
        System.out.println("Quick Sort: Time=" + (end - start) + "ns, Operations=" + QuickSort.count);

        // Insertion Sort
        int[] iArr = arr.clone();
        InsertionSort.count = 0;
        start = System.nanoTime();
        InsertionSort.insertionSort(iArr);
        end = System.nanoTime();
        System.out.println("Insertion Sort: Time=" + (end - start) + "ns, Operations=" + InsertionSort.count);

        // Bubble Sort
        int[] bArr = arr.clone();
        BubbleSort.count = 0;
        start = System.nanoTime();
        BubbleSort.bubbleSort(bArr);
        end = System.nanoTime();
        System.out.println("Bubble Sort: Time=" + (end - start) + "ns, Operations=" + BubbleSort.count);
    }

    public static int[] generateSorted(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        return arr;
    }

    public static int[] generateReversed(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        return arr;
    }

    public static int[] generateRandom(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt();
        return arr;
    }

    public static int[] generateAlmostSorted(int n) {
        int[] arr = generateSorted(n);
        int swaps = Math.max(1, n / 20);
        Random rand = new Random();

        for (int i = 0; i < swaps; i++) {
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        return arr; 
    }
}
