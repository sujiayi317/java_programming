package com.JiayiSu.lambda;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/* Both examples(TimerTest.java, ArraysSortComparator.java)
have something in common. A block of code was passed to someone—a timer, or a
sort method. That code block was called at some later time.
Up to now, giving someone a block of code hasn’t been easy in Java. You couldn’t just pass code
blocks around. Java is an object-oriented language, so you had to construct an object belonging to a
class that has a method with the desired code. */

/**
 * This program demonstrates the use of lambda expressions.

 One form of lambda expressions in Java: parameters, the -> arrow, and an expression.

 If the code carries out a computation that doesn’t fit in a single expression, write it
 exactly like you would have written a method: enclosed in {} and with explicit return statements.

 (String first, String second) -> {
    if (first.length() < second.length()) return -1;
    else if (first.length() > second.length()) return 1;
    else return 0;
 }

 If a lambda expression has no parameters, you still supply empty parentheses, just as with a
 parameterless method:
 () -> { for (int i = 100; i >= 0; i--) System.out.println(i); }

 If the parameter types of a lambda expression can be inferred, you can omit them. For example,
 Comparator<String> comp
   = (first, second) // same as (String first, String second)
      -> first.length() - second.length();
 Here, the compiler can deduce that first and second must be strings because the lambda
 expression is assigned to a string comparator.

 If a method has a single parameter with inferred type, you can even omit the parentheses:
 ActionListener listener = event ->
   System.out.println("The time is " + Instant.ofEpochMilli(event.getWhen()));
   // instead of (event) -> . . . or (ActionEvent event) -> . . .

 You never specify the result type of a lambda expression. It is always inferred from context. For
 example, the expression
 (String first, String second) -> first.length() - second.length()
 can be used in a context where a result of type int is expected.

 * Note:
 * It is illegal for a lambda expression to return a value in some branches but not in others. For
 * example, (int x) -> { if (x >= 0) return 1; } is invalid.
 *
 There are many existing interfaces in Java that encapsulate blocks of code, such as
 ActionListener or Comparator. Lambdas are compatible with these interfaces.
 You can supply a lambda expression whenever an object of an interface with a single abstract method
 is expected. Such an interface is called a functional interface.
 */
public class LambdaTest {
   public static void main(String[] args) {
      var planets = new String[] { "Mercury", "Venus", "Earth", "Mars", 
         "Jupiter", "Saturn", "Uranus", "Neptune" };
      System.out.println(Arrays.toString(planets));
      System.out.println("Sorted in dictionary order:");
      Arrays.sort(planets);
      System.out.println(Arrays.toString(planets));
      System.out.println("Sorted by length:");
      Arrays.sort(planets, (first, second) -> first.length() - second.length());
      System.out.println(Arrays.toString(planets));

      /*
      var timer = new Timer(1000, event -> {
         System.out.println("At the tone, the time is "
         + Instant.ofEpochMilli(event.getWhen()));
         Toolkit.getDefaultToolkit().beep();
      });*/
      var timer = new Timer(1000, event ->
         System.out.println("The time is " + new Date()));
      timer.start();   
         
      // keep program running until user selects "OK"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);         
   }
}
