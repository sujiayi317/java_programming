package com.JiayiSu.collectionsFramework.treeSet;

import java.util.*;

/**
 * This program builds two tree sets of Item objects. The first one is sorted by part
 * number, the default sort order of Item objects. The second set is sorted by description, using a
 * custom comparator.
 */

public class TreeSetTest {
   public static void main(String[] args) {
      var parts = new TreeSet<Item>();
      parts.add(new Item("Toaster", 1234));
      parts.add(new Item("Widget", 4562));
      parts.add(new Item("Modem", 9912));
      System.out.println(parts);

      var sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));

      sortByDescription.addAll(parts);
      System.out.println(sortByDescription);
   }
}

/* java.util.TreeSet<E>
TreeSet()
TreeSet(Comparator<? super E> comparator)
   constructs an empty tree set.
TreeSet(Collection<? extends E> elements)
TreeSet(SortedSet<E> s)
   constructs a tree set and adds all elements from a collection or sorted set (in the latter case,
   using the same ordering).

java.util.SortedSet<E>
Comparator<? super E> comparator()
   returns the comparator used for sorting the elements, or null if the elements are compared with
   the compareTo method of the Comparable interface.
E first()
E last()
   returns the smallest or largest element in the sorted set.

java.util.NavigableSet<E>
E higher(E value)
E lower(E value)
   returns the least element > value or the largest element < value, or null if there is no such
   element.
E ceiling(E value)
E floor(E value)
   returns the least element ≥ value or the largest element ≤ value, or null if there is no such
   element.
E pollFirst()
E pollLast()
   removes and returns the smallest or largest element in this set, or null if the set is empty.
Iterator<E> descendingIterator()
   returns an iterator that traverses this set in descending direction. */
