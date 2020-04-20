package com.JiayiSu.collectionsFramework;

import java.util.*;

/**
 * This program demonstrates operations on linked lists.
 */
public class LinkedListTest {
   public static void main(String[] args) {
      var a = new LinkedList<String>();
      a.add("Amy");
      a.add("Carl");
      a.add("Erica");

      var b = new LinkedList<String>();
      b.add("Bob");
      b.add("Doug");
      b.add("Frances");
      b.add("Gloria");

      // merge the words from b into a

      ListIterator<String> aIter = a.listIterator();
      Iterator<String> bIter = b.iterator();

      while (bIter.hasNext()) {
         if (aIter.hasNext()) aIter.next();
         aIter.add(bIter.next());
      }

      System.out.println(a);

      // remove every second word from b

      bIter = b.iterator();
      while (bIter.hasNext()) {
         bIter.next(); // skip one element
         if (bIter.hasNext()) {
            bIter.next(); // skip next element
            bIter.remove(); // remove that element
         }
      }

      System.out.println(b);

      // bulk operation: remove all words in b from a

      a.removeAll(b);

      System.out.println(a);
   }
}

/* java.util.List<E>
ListIterator<E> listIterator()
   returns a list iterator for visiting the elements of the list.
ListIterator<E> listIterator(int index)
   returns a list iterator for visiting the elements of the list whose first call to next will return the
   element with the given index.
void add(int i, E element)
   adds an element at the specified position.
void addAll(int i, Collection<? extends E> elements)
   adds all elements from a collection to the specified position.
E remove(int i)
   removes and returns the element at the specified position.
E get(int i)
   gets the element at the specified position.
E set(int i, E element)
   replaces the element at the specified position with a new element and returns the old element.
int indexOf(Object element)
   returns the position of the first occurrence of an element equal to the specified element, or -1 if
   no matching element is found.
int lastIndexOf(Object element)
   returns the position of the last occurrence of an element equal to the specified element, or -1 if
   no matching element is found.

   java.util.ListIterator<E>
void add(E newElement)
   adds an element before the current position.
void set(E newElement)
   replaces the last element visited by next or previous with a new element. Throws an
   IllegalStateException if the list structure was modified since the last call to next or
   previous.
boolean hasPrevious()
   returns true if there is another element to visit when iterating backwards through the list.
E previous()
   returns the previous object. Throws a NoSuchElementException if the beginning of the
   list has been reached.
int nextIndex()
   returns the index of the element that would be returned by the next call to next.
int previousIndex()
   returns the index of the element that would be returned by the next call to previous.

   java.util.LinkedList<E>
LinkedList()
   constructs an empty linked list.
LinkedList(Collection<? extends E> elements)
   constructs a linked list and adds all elements from a collection.
void addFirst(E element)
void addLast(E element)
   adds an element to the beginning or the end of the list.
E getFirst()
E getLast()
   returns the element at the beginning or the end of the list.
E removeFirst()
E removeLast()
   removes and returns the element at the beginning or the end of the list.*/