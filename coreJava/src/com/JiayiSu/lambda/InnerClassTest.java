package com.JiayiSu.lambda;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

import javax.swing.*;

/**
 * This program demonstrates the use of inner classes.
 */
public class InnerClassTest {
   public static void main(String[] args) {
      var clock = new LocalTalkingClock(1000, true);
      clock.start();

      /* However, it is also possible to set the outer class reference to
      another object by explicitly naming it. For example, since TimePrinter is a public inner class,
      you can construct a TimePrinter for any talking clock:
      var jabberer = new TalkingClock(1000, true);
      TalkingClock.TimePrinter listener = jabberer.new TimePrinter();
      Note that you refer to an inner class as
      OuterClass.InnerClass
      when it occurs outside the scope of the outer class. */
//      var jabberer = new TalkingClock(1000, true);
//      TalkingClock.TimePrinter listener = jabberer.new TimePrinter();
//      var timer = new timer(1000, listener);       TODO: It doesn't work
//      timer.start();

      // keep program running until the user selects "OK"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock {
   private int interval;
   private boolean beep;

   /**
    * Constructs a talking clock
    * @param interval the interval between messages (in milliseconds)
    * @param beep true if the clock should beep
    */
   public TalkingClock(int interval, boolean beep) {
      this.interval = interval;
      this.beep = beep;
   }

   /**
    * Starts the clock.
    */
   public void start() {

      ActionListener listener = new TimePrinter();
//      TimePrinter listener = new TimePrinter();
//      ActionListener listener = this.new TimePrinter();


      var timer = new Timer(interval, listener);
      timer.start();
   }

   public class TimePrinter implements ActionListener {
      public void actionPerformed(ActionEvent event) {
         System.out.println("At the tone, the time is " 
            + Instant.ofEpochMilli(event.getWhen()));
         if (beep) Toolkit.getDefaultToolkit().beep();
//         if (TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
      }
   }
}
