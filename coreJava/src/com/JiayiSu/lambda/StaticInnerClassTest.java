package com.JiayiSu.lambda;

/**
 * This program demonstrates the use of static inner classes.
 * task: computing the minimum and maximum value in an array.
 */
/* Of course, you write one method to compute the minimum
and another method to compute the maximum. When you call both methods, the array is traversed
twice. It would be more efficient to traverse the array only once, computing both the minimum and the
maximum simultaneously. However, the method must return two numbers. We can achieve that by defining a class
"Pair" that holds two values. The minmax method can then return an object of type Pair.

However, the name Pair is an exceedingly common name, and in a large project, it is quite possible
that some other programmer had the same bright idea—but made a Pair class that contains a pair of
strings. We can solve this potential name clash by making Pair a public inner class inside
ArrayAlg. Then the class will be known to the public as ArrayAlg.Pair:

ArrayAlg.Pair p = ArrayAlg.minmax(d);

However, unlike the inner classes that we used in previous examples, we do not want to have a
reference to any other object inside a Pair object. That reference can be suppressed by declaring the
inner class static:

class ArrayAlg {
   public static class Pair {
      . . .
   }
   . . .
}
Of course, only inner classes can be declared static. A static inner class is exactly like any other inner
class, except that an object of a static inner class does not have a reference to the outer class object
that generated it.

In our example, we must use a static inner class because the inner class object is
constructed inside a static method*/
public class StaticInnerClassTest {
   public static void main(String[] args) {
      var values = new double[20];
      for (int i = 0; i < values.length; i++)
         values[i] = 100 * Math.random();
      ArrayAlg.Pair p = ArrayAlg.minmax(values);
      System.out.println("min = " + p.getFirst());
      System.out.println("max = " + p.getSecond());
   }
}

class ArrayAlg {
   /**
    * A pair of floating-point numbers
    */
   public static class Pair {
      private double first;
      private double second;

      /**
       * Constructs a pair from two floating-point numbers
       * @param f the first number
       * @param s the second number
       */
      public Pair(double f, double s) {
         first = f;
         second = s;
      }

      /**
       * Returns the first number of the pair
       * @return the first number
       */
      public double getFirst()
      {
         return first;
      }

      /**
       * Returns the second number of the pair
       * @return the second number
       */
      public double getSecond()
      {
         return second;
      }
   }

   /**
    * Computes both the minimum and the maximum of an array
    * @param values an array of floating-point numbers
    * @return a pair whose first element is the minimum and whose second element
    * is the maximum
    */
   public static Pair minmax(double[] values) {
      double min = Double.POSITIVE_INFINITY;
      double max = Double.NEGATIVE_INFINITY;
      for (double v : values) {
         if (min > v) min = v;
         if (max < v) max = v;
      }
      return new Pair(min, max);
   }
}
