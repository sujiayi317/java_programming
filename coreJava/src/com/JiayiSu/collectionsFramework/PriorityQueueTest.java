package com.JiayiSu.collectionsFramework;

import java.util.*;
import java.time.*;

/**
 * This program demonstrates the use of a priority queue.
 * Unlike iteration in a TreeSet, the iteration here does not visit the elements in sorted order.
 * However, removal always yields the smallest remaining element.
 *
 */
public class PriorityQueueTest {
   public static void main(String[] args) {
      var pq = new PriorityQueue<LocalDate>();
      pq.add(LocalDate.of(1906, 12, 9)); // G. Hopper
      pq.add(LocalDate.of(1815, 12, 10)); // A. Lovelace
      pq.add(LocalDate.of(1903, 12, 3)); // J. von Neumann
      pq.add(LocalDate.of(1910, 6, 22)); // K. Zuse

      System.out.println("Iterating over elements . . .");
      for (LocalDate date : pq)
         System.out.println(date);
      System.out.println("Removing elements . . .");
      while (!pq.isEmpty())
         System.out.println(pq.remove());
   }
}

/*  java.util.PriorityQueue
 PriorityQueue()
 PriorityQueue(int initialCapacity)
   constructs a priority queue for storing Comparable objects.
 PriorityQueue(int initialCapacity, Comparator<? super E> c)
   constructs a priority queue and uses the specified comparator for sorting its elements. */