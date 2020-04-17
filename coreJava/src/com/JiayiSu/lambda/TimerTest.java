package com.JiayiSu.lambda;

/**
 After the timer is started, the program puts up
 a message dialog and waits for the user to click the OK button to stop. While the program waits for
 the user, the current time is displayed every second. (If you omit the dialog, the program would
 terminate as soon as the main method exits.)
*/

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;
/* The javax.swing package contains a Timer class that is useful if you want to be notified
whenever a time interval has elapsed. For example, if a part of your program contains a clock, you
can ask to be notified every second so that you can update the clock face.

When you construct a timer, you set the time interval and tell it what it should do whenever the time
interval has elapsed.

How do you tell the timer what it should do? In many programming languages, you supply the name of
a function that the timer should call periodically. However, the classes in the Java standard library
take an object-oriented approach. You pass an object of some class. The timer then calls one of the
methods on that object. Passing an object is more flexible than passing a function because the object
can carry additional information.

Of course, the timer needs to know what method to call. The timer requires that you specify an object
of a class that implements the ActionListener interface of the java.awt.event package.
Here is that interface:
public interface ActionListener {
   void actionPerformed(ActionEvent event);
}
The timer calls the actionPerformed method when the time interval has expired.
*/

public class TimerTest {
   public static void main(String[] args) {
      var listener = new TimePrinter();

      // construct a timer that calls the listener
      // once every second
      /* The first parameter of the Timer constructor is the time interval that must elapse between
notifications, measured in milliseconds. We want to be notified every second. The second parameter
is the listener object. */
      /* // Lambda expression:
      var timer = new Timer(1000, event -> {
         System.out.println("At the tone, the time is "
         + Instant.ofEpochMilli(event.getWhen()));
         Toolkit.getDefaultToolkit().beep();
      });*/
      var timer = new Timer(1000, listener);
      //  Finally, start the timer.
      timer.start();

      // keep program running until the user selects "OK"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}
/* Suppose you want to print a message “At the tone, the time is . . .”, followed by a beep, once every
second. You would define a class that implements the ActionListener interface. You would then
place whatever statements you want to have executed inside the actionPerformed method.

Note the ActionEvent parameter of the actionPerformed method. This parameter gives
information about the event, such as the time when the event happened. The call
event.getWhen() returns the event time, measured in milliseconds since the “epoch” (January 1,
1970). By passing it to the static Instant.ofEpochMilli method, we get a more readable
description.*/
class TimePrinter implements ActionListener {
   public void actionPerformed(ActionEvent event) {
      System.out.println("At the tone, the time is " 
         + Instant.ofEpochMilli(event.getWhen()));
      Toolkit.getDefaultToolkit().beep();
   }
}

/** javax.swing.JOptionPane---------------------
 static void showMessageDialog(Component parent, Object message)
    displays a dialog box with a message prompt and an OK button. The dialog is centered over the
    parent component. If parent is null, the dialog is centered on the screen.
 javax.swing.Timer------------------------------
 Timer(int interval, ActionListener listener)
   constructs a timer that notifies listener whenever interval milliseconds have elapsed.
 void start()
   starts the timer. Once started, the timer calls actionPerformed on its listeners.
 void stop()
   stops the timer. Once stopped, the timer no longer calls actionPerformed on its listeners.
 java.awt.Toolkit 1.0
 static Toolkit getDefaultToolkit()
   gets the default toolkit. A toolkit contains information about the GUI environment.
 void beep()
   emits a beep sound. */
