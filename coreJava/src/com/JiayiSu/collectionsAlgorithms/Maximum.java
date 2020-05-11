package com.JiayiSu.collectionsAlgorithms;

import java.util.*;


/**
 * This program demonstrates the use of a generic max function.
 *
 * Why Generic Algorithms?
 * Think of the minimal collection interface that you
 * need to efficiently carry out the algorithm. Random access with get and set comes higher in the
 * food chain than simple iteration. As in the computation of the maximum element in a
 * linked list, random access is not required for this task. Computing the maximum can be done simply
 * by iterating through the elements. Therefore, you can implement the max method to take any object
 * that implements the Collection interface.
 *
 * Generic collection interfaces have a great advantage—you only need to implement your algorithms
 * once.
 * Now you can compute the maximum of a linked list, an array list, or an array, with a single method.
 */
class   Maximum {
    public static <T extends Comparable> T max(Collection<T> c) {
        if (c.isEmpty()) throw new NoSuchElementException();
        Iterator<T> iter = c.iterator();
        T largest = iter.next();
        while (iter.hasNext()) {
            T next = iter.next();
            if (largest.compareTo(next) < 0)
                largest = next;
        }
        return largest;
    }

    public static void main(String[]args) {
        // ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        System.out.println(max(numbers));

        // LinkedList
        var numbers2 = new LinkedList<Integer>();
        numbers2.add(2);
        numbers2.add(4);
        numbers2.add(6);
        numbers2.add(8);
        System.out.println(max(numbers2));

        // array TODO: doesn't work
//        int[] numbers3 = new int[3];
//        numbers3[0] = 3;
//        numbers3[1] = 5;
//        numbers3[2] = 7;
//        System.out.println(max(numbers3));
    }
}
