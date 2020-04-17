package com.JiayiSu.miscellaneous;

import java.util.ArrayList;

/**java.lang.Integer
 int intValue()
    returns the value of this Integer object as an int (overrides the intValue method in the
    Number class).
 static String toString(int i)
    returns a new String object representing the number i in base 10.
 static String toString(int i, int radix)
    lets you return a representation of the number i in the base specified by the radix parameter.
 static int parseInt(String s)
 static int parseInt(String s, int radix)
    returns the integer whose digits are contained in the string s. The string must represent an
    integer in base 10 (for the first method) or in the base given by the radix parameter (for the
    second method).
 static Integer valueOf(String s)
 static Integer valueOf(String s, int radix)
    returns a new Integer object initialized to the integer whose digits are contained in the string
    s. The string must represent an integer in base 10 (for the first method) or in the base given by
    the radix parameter (for the second method).*/
class AutoboxingObjectWrapper {
    public static void main(String[]args) {
        var list = new ArrayList<Integer>();
        // the following statements have the same effect:
        list.add(3);
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf("5"));

        for (Integer x : list) {
            System.out.print(x);
            System.out.print(" ");
        }
        System.out.println();

        Integer a = 1000;
        Integer b = 1000;
        System.out.println("a is "+ a + ", and b is "+ b);
        System.out.println("a==b is "+ (a==b));
        // call the equals method when comparing wrapper objects:
        System.out.println("a.equals(b) is "+ (a.equals(b)));

        /* There are a couple of other subtleties about autoboxing.
        First off, since wrapper class references can be null, it is possible for autounboxing to
        throw a NullPointerException: */
        Integer n = null;
        try {
            System.out.println(2 * n);
        } catch (NullPointerException exc) {
            System.out.println(exc);
        }

        /* Also, if you mix Integer and Double types in a conditional expression, then the Integer value
        is unboxed, promoted to double, and boxed into a Double: */
        n = 1;
        Double x = 2.0;
        System.out.println(n);    // prints 1
        System.out.println(true ? n : x); // prints 1.0

        try {
            System.out.println("trying to run: \nint y = Integer.parseInt(\"3.14\");");
            int y = Integer.parseInt("3.14");
        } catch (NumberFormatException exc) {
            System.out.println(exc);
        } finally {
            int z = Integer.parseInt("3");
            /* This has nothing to do with Integer objects—parseInt is a static method. But the Integer
            class was a good place to put it. */
            System.out.println("The string should look like a 'int'. e.g., with "+ z + " inside.");
        }
        var PI = Double.parseDouble("3.14");
        System.out.println("PI is "+ PI);
    }
}
