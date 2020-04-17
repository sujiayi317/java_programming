package com.JiayiSu.methodReferences;

import java.awt.event.ActionEvent;
import java.time.Instant;
import javax.swing.*;

class Greeter {
    public void greet(ActionEvent event) {
        System.out.println("Hello, the time is "
                + Instant.ofEpochMilli(event.getWhen()));
    }
}

public class RepeatedGreeter extends Greeter {
    public void greet(ActionEvent event) {
        var timer = new Timer(1000, super::greet);  // uses super as the target and
        // invokes the superclass version of the given method.
        timer.start();
    }
}
/* When the RepeatedGreeter.greet method starts, a Timer is constructed that executes the
super::greet method on every timer tick. */
class RepeatedReferences {
    public static void main(String[] args) {
        var repeat = new RepeatedGreeter();
        var timer = new Timer(1000, repeat::greet);
        timer.start();

        // keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

