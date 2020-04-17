package com.JiayiSu.lambda;

/* You can sort an array of strings since the String class implements
Comparable<String>, and the String.compareTo method compares strings in dictionary
order.

Now suppose we want to sort strings by increasing length, not in dictionary order,
we can’t have the String class implement the compareTo method in two ways—and at any rate,
the String class isn’t ours to modify.

To deal with this situation, there is a second version of the Arrays.sort method whose
parameters are an array and a comparator—an instance of a class that implements the Comparator
interface.
public interface Comparator<T> {
    int compare(T first, T second);
}
*/
import java.util.Arrays;
import java.util.Comparator;

class ArraysSortComparator {
    public static void main(String[]args){
        String[] friends = { "Peter", "Paul", "Mary" };
        /* Note: Even though the LengthComparator object has no state, you still need to make an
instance of it. You need the instance to call the compare method—it is not a static method. */
        var comp = new LengthComparator();
        // The compare method is called on the comparator object, not the string itself.
        if (comp.compare(friends[0], friends[1]) > 0) System.out.println("Yes");
        if (friends[0].compareTo(friends[1]) > 0) System.out.println("Oops"); //e>a
        // If you want to sort strings by length instead of the
        //default dictionary order, you can pass a Comparator object to the sort method:
        Arrays.sort(friends, new LengthComparator());
        /* The compare method isn’t called right away. Instead, the sort method keeps calling the compare
method, rearranging the elements if they are out of order, until the array is sorted. You give the sort
method a snippet of code needed to compare elements, and that code is integrated into the rest of the
sorting logic, which you’d probably not care to reimplement. */
        for (String f: friends) {
            System.out.println(f);
        }
    }
}

class LengthComparator implements Comparator<String> {
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}