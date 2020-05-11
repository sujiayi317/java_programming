package com.JiayiSu.collectionsAlgorithms;

import java.util.*;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * The program fills an array list with 49 Integer objects containing the numbers 1 through 49.
 * It then randomly shuffles the list and selects the first six values from the shuffled list.
 * Finally, it sorts the selected values and prints them.
 */
public class ShuffleSortTest {
   public static void main(String[] args) {
      var numbers = new ArrayList<Integer>();
      for (int i = 1; i <= 49; i++)
         numbers.add(i);
      Collections.shuffle(numbers);
      List<Integer> winningCombination = numbers.subList(0, 6);
      Collections.sort(winningCombination);
      System.out.println(winningCombination);
   }
}
/* The sort method in the Collections class sorts a collection that implements the Comparable interface.
If you want to sort the list in some other way, you can use the sort method of the List interface and pass a
Comparator object. Here is how you can sort a list of employees by salary:
staff.sort(Comparator.comparingDouble(Employee::getSalary));

If you want to sort a list in descending order, use the static convenience method
Comparator.reverseOrder(). It returns a comparator that returns b.compareTo(a). For example,
staff.sort(Comparator.reverseOrder())
sorts the elements in the list staff in reverse order, according to the ordering given by the
compareTo method of the element type. Similarly,
staff.sort(Comparator.comparingDouble(Employee::getSalary).reversed())
sorts by descending salary.

You may wonder how the sort method sorts a list. Typically, when you look at a sorting algorithm in
a book on algorithms, it is presented for arrays and uses random element access. However, random
access in a linked list is inefficient. You can actually sort linked lists efficiently by using a form of
merge sort. However, the implementation in the Java programming language does not do that. It
simply dumps all elements into an array, sorts the array, and then copies the sorted sequence back into
the list.
The sort algorithm used in the collections library is a bit slower than Quick-Sort, the traditional
choice for a general-purpose sorting algorithm. However, it has one major advantage: It is stable, that
is, it doesn’t switch equal elements. Why do you care about the order of equal elements? Here is a
common scenario. Suppose you have an employee list that you already sorted by name. Now you sort
by salary. What happens to employees with equal salary? With a stable sort, the ordering by name is
preserved. In other words, the outcome is a list that is sorted first by salary, then by name.
Collections need not implement all of their “optional” methods, so all methods that receive collection
parameters must describe when it is safe to pass a collection to an algorithm. For example, you
clearly cannot pass an unmodifiableList list to the sort algorithm. What kind of list can you
pass? According to the documentation, the list must be modifiable but need not be resizable.

The terms are defined as follows:
A list is modifiable if it supports the set method.
A list is resizable if it supports the add and remove operations.

The Collections class has an algorithm shuffle that does the opposite of sorting—it randomly
permutes the order of the elements in a list. For example:
ArrayList<Card> cards = . . .;
Collections.shuffle(cards);
If you supply a list that does not implement the RandomAccess interface, the shuffle method
copies the elements into an array, shuffles the array, and copies the shuffled elements back into the
list.*/


/* java.util.Collections 1.2
static <T extends Comparable<? super T>> void sort(List<T> elements)
   sorts the elements in the list, using a stable sort algorithm. The algorithm is guaranteed to run in
   O(n log n) time, where n is the length of the list.
static void shuffle(List<?> elements)
static void shuffle(List<?> elements, Random r)
   randomly shuffles the elements in the list. This algorithm runs in O(n a(n)) time, where n is the
   length of the list and a(n) is the average time to access an element.

java.util.List<E> 1.2
default void sort(Comparator<? super T> comparator) 8
   Sorts this list, using the given comparator.

java.util.Comparator<T> 1.2
static <T extends Comparable<? super T>> Comparator<T> reverseOrder() 8
   Yields a comparator that reverses the ordering provided by the Comparable interface.
default Comparator<T> reversed() 8
   Yields a comparator that reverses the ordering provided by this comparator. */