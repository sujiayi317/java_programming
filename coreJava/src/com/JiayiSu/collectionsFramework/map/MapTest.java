package com.JiayiSu.collectionsFramework.map;

import java.util.*;

/**
 * This program demonstrates the use of a map with key type String and value type Employee.
 */
public class MapTest {
   public static void main(String[] args) {
      var staff = new HashMap<String, Employee>();
      staff.put("144-25-5464", new Employee("Amy Lee"));
      staff.put("567-24-2546", new Employee("Harry Hacker"));
      staff.put("157-62-7935", new Employee("Gary Cooper"));
      staff.put("456-62-5527", new Employee("Francesca Cruz"));

      // print all entries

      System.out.println(staff);

      // remove an entry

      staff.remove("567-24-2546");

      // replace an entry

      staff.put("456-62-5527", new Employee("Francesca Miller"));

      // look up a value

      System.out.println(staff.get("157-62-7935"));

      // iterate through all entries

      staff.forEach((k, v) -> 
         System.out.println("key=" + k + ", value=" + v));
   }
}

/* java.util.Map<K, V> 1.2
V get(Object key)
   gets the value associated with the key; returns the object associated with the key, or null if the
   key is not found in the map. Implementing classes may forbid null keys.
default V getOrDefault(Object key, V defaultValue)
   gets the value associated with the key; returns the object associated with the key, or
   defaultValue if the key is not found in the map.
V put(K key, V value)
   puts the association of a key and a value into the map. If the key is already present, the new
   object replaces the old one previously associated with the key. This method returns the old
   value of the key, or null if the key was not previously present. Implementing classes may
   forbid null keys or values.
void putAll(Map<? extends K, ? extends V> entries)
   adds all entries from the specified map to this map.
boolean containsKey(Object key)
   returns true if the key is present in the map.
boolean containsValue(Object value)
   returns true if the value is present in the map.
default void forEach(BiConsumer<? super K,? super V> action) 8
   applies the action to all key/value pairs of this map.

java.util.HashMap<K, V> 1.2
HashMap()
HashMap(int initialCapacity)
HashMap(int initialCapacity, float loadFactor)
   constructs an empty hash map with the specified capacity and load factor (a number between
   0.0 and 1.0 that determines at what percentage of fullness the hash table will be rehashed into
   a larger one). The default load factor is 0.75.

java.util.TreeMap<K,V> 1.2
TreeMap()
   constructs an empty tree map for keys that implement the Comparable interface.
TreeMap(Comparator<? super K> c)
   constructs a tree map and uses the specified comparator for sorting its keys.
TreeMap(Map<? extends K, ? extends V> entries)
   constructs a tree map and adds all entries from a map.
TreeMap(SortedMap<? extends K, ? extends V> entries)
   constructs a tree map, adds all entries from a sorted map, and uses the same element comparator
   as the given sorted map.

java.util.SortedMap<K, V> 1.2
Comparator<? super K> comparator()
   returns the comparator used for sorting the keys, or null if the keys are compared with the
   compareTo method of the Comparable interface.
K firstKey()
K lastKey()
   returns the smallest or largest key in the map.*/