package com.JiayiSu.lambda;

/* If you look carefully at the code of the TalkingClock example, you will find that you need the
name of the type TimePrinter only once: when you create an object of that type in the start
method.
In a situation like this, you can define the class locally in a single method.
Click here */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * This program demonstrates the use of local inner classes.
 */
public class LocalInnerClassTest2 {
   public static void main(String[] args) {
      var clock = new LocalTalkingClock2();
      clock.start(1000, true);

      // keep program running until the user selects "OK"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * A clock that prints the time in regular intervals.
 */
class LocalTalkingClock2 {
   /**
    * Starts the clock.
    * Note that the TalkingClock class no longer needs to store a beep instance field. It simply refers
    * to the beep parameter variable of the start method.
    * Maybe this should not be so surprising. The line
    * if (beep) . . .
    * is, after all, ultimately inside the start method, so why shouldn’t it have access to the value of the
    * beep variable?
    *
    * To see why there is a subtle issue here, let’s consider the flow of control more closely.
    * 1. The start method is called.
    * 2. The object variable listener is initialized by a call to the constructor of the inner class
    * TimePrinter.
    * 3. The listener reference is passed to the Timer constructor, the timer is started, and the
    * start method exits. At this point, the beep parameter variable of the start method no
    * longer exists.
    * 4. A second later, the actionPerformed method executes if (beep) . . .
    *
    * For the code in the actionPerformed method to work, the TimePrinter class must have
    * copied the beep field as a local variable of the start method, before the beep parameter value
    * went away. That is indeed exactly what happens. In our example, the compiler synthesizes the name
    * TalkingClock$1TimePrinter for the local inner class.
    */
   public void start(int interval, boolean beep) {
      class TimePrinter implements ActionListener {
         public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is "
                    + Instant.ofEpochMilli(event.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
//         if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
         }
      }
      ActionListener listener = new TimePrinter();
//      TimePrinter listener = new TimePrinter();
//      ActionListener listener = this.new TimePrinter();


      var timer = new Timer(interval, listener);
      timer.start();
   }
}
