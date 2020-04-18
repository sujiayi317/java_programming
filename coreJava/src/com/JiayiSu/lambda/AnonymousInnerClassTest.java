package com.JiayiSu.lambda;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;

/**
 * This program demonstrates anonymous inner classes.
 * When using local inner classes, you can often go a step further. If you want to make only a single
 * object of this class, you don’t even need to give the class a name. Such a class is called an
 * anonymous inner class.
 */
public class AnonymousInnerClassTest {
   public static void main(String[] args) {
      var clock = new TalkingClock3();
      clock.start(1000, true);

      // keep program running until the user selects "OK"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock3 {
   /**
    * Starts the clock.
    * @param interval the interval between messages (in milliseconds)
    * @param beep true if the clock should beep
    * Create a new object of a class that
    * implements the ActionListener interface, where the required method actionPerformed is
    * the one defined inside the braces { }.
    */
   public void start(int interval, boolean beep) {
      var listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
               System.out.println("At the tone, the time is " 
                  + Instant.ofEpochMilli(event.getWhen()));
               if (beep) Toolkit.getDefaultToolkit().beep();
            }
         };
      var timer = new Timer(interval, listener);
      timer.start();
   }
}

/* In general, the syntax is
new SuperType(construction parameters) {
   inner class methods and data
}
Here, SuperType can be an interface, such as ActionListener; then, the inner class implements
that interface. SuperType can also be a class; then, the inner class extends that class.

An anonymous inner class cannot have constructors because the name of a constructor must be the
same as the name of a class, and the class has no name. Instead, the construction parameters are given
to the superclass constructor. In particular, whenever an inner class implements an interface, it cannot
have any construction parameters. Nevertheless, you must supply a set of parentheses as in

new InterfaceType() {
   methods and data
}

You have to look carefully to see the difference between the construction of a new object of a class
and the construction of an object of an anonymous inner class extending that class.

var queen = new Person("Mary");
// a Person object
var count = new Person("Dracula") { . . . };
// an object of an inner class extending Person

If the closing parenthesis of the construction parameter list is followed by an opening brace, then an
anonymous inner class is being defined.


For many years, Java programmers routinely used anonymous inner classes for event listeners and
other callbacks. Nowadays, you are better off using a lambda expression. For example, the start
method from the beginning of this section can be written much more concisely with a lambda
expression like this:
public void start(int interval, boolean beep) {
   var timer = new Timer(interval, event -> {
      System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
      if (beep) Toolkit.getDefaultToolkit().beep();
   });
   timer.start();
}*/


/* Note: Even though an anonymous class cannot have constructors, you can provide an object
initialization block:
var count = new Person("Dracula") {
   { initialization }
   . . .
}; */

/** Tip:
 When you produce logging or debugging messages, you often want to include the name of the
 current class, such as

 System.err.println("Something awful happened in " + getClass());

 But that fails in a static method. After all, the call to getClass calls
 this.getClass(), and a static method has no this. Use the following expression
 instead:

 new Object(){}.getClass().getEnclosingClass() // gets class of static method

 Here, new Object(){} makes an anonymous object of an anonymous subclass of
 Object, and getEnclosingClass gets its enclosing class—that is, the class containing
 the static method. */