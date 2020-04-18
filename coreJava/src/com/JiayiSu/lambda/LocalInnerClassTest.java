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
public class LocalInnerClassTest {
   public static void main(String[] args) {
      var clock = new LocalTalkingClock(1000, true);
      clock.start();

      // keep program running until the user selects "OK"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * A clock that prints the time in regular intervals.
 */
class LocalTalkingClock {
   private int interval;
   private boolean beep;

   /**
    * Constructs a talking clock
    * @param interval the interval between messages (in milliseconds)
    * @param beep true if the clock should beep
    */
   public LocalTalkingClock(int interval, boolean beep) {
      this.interval = interval;
      this.beep = beep;
   }

   /**
    * Starts the clock.
    * Local classes are never declared with an access specifier (that is, public or private). Their
    * scope is always restricted to the block in which they are declared.
    * Local classes have one great advantage: They are completely hidden from the outside world—not
    * even other code in the TalkingClock class can access them. No method except start has any
    * knowledge of the TimePrinter class.
    */
   public void start() {
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
