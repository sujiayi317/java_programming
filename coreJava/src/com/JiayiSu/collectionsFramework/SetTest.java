package com.JiayiSu.collectionsFramework;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program uses a set to print all unique words in a text file.
 */
public class SetTest {
   public static void main(String[] args) throws FileNotFoundException {
      var words = new HashSet<String>(); 
      long totalTime = 0;
      File file = new File("E:\\OneDrive - University of Toronto\\java_programming\\coreJava\\" +
              "src\\com\\JiayiSu\\collectionsFramework\\alice30.txt");
      try (var in = new Scanner(file)) {

         while (in.hasNext()) {
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
         }
      }

      Iterator<String> iter = words.iterator();
      for (int i = 1; i <= 20 && iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(". . .");
      System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
   }
}
/* java.util.HashSet<E>
HashSet()
   constructs an empty hash set.
HashSet(Collection<? extends E> elements)
   constructs a hash set and adds all elements from a collection.
HashSet(int initialCapacity)
   constructs an empty hash set with the specified capacity (number of buckets).
HashSet(int initialCapacity, float loadFactor)
   constructs an empty hash set with the specified capacity and load factor (a number between 0.0
   and 1.0 that determines at what percentage of fullness the hash table will be rehashed into a
   larger one).

java.lang.Object
int hashCode()
   returns a hash code for this object. A hash code can be any integer, positive or negative. The
   definitions of equals and hashCode must be compatible: If x.equals(y) is true, then
   x.hashCode() must be the same value as y.hashCode(). */