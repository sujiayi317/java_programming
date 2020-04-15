package com.JiayiSu.employees;

/* Many programmers prefer to put each class into its own source file.
For example, you can place the Employee class into a file Employee.java and the EmployeeTest
class into EmployeeTest.java.

If you like this arrangement, you have two choices for compiling the program. You can invoke the
Java compiler with a wildcard:
    javac Employee*.java
Then, all source files matching the wildcard will be compiled into class files. Or, you can type
    javac EmployeeTest.java
You may find it surprising that the second choice works even though the Employee.java file is
never explicitly compiled. However, when the Java compiler sees the Employee class being used
inside EmployeeTest.java, it will look for a file named Employee.class. If it does not
find that file, it automatically searches for Employee.java and compiles it. Moreover, if the
timestamp of the version of Employee.java that it finds is newer than that of the existing
Employee.class file, the Java compiler will automatically recompile the file. */

import java.text.NumberFormat;
import java.util.ArrayList;

import com.JiayiSu.inheritance.Manager;

class EmployeeTest {

    /* Note that you can call static methods without having any objects.
    For example, you never construct any objects of the Math class to call Math.pow.
    For the same reason, the main method is a static method.

    The main method does not operate on any objects.
    In fact, when a program starts, there aren’t any objects yet.
    The static main method executes, and constructs the objects that the program needs.*/
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // raise everyone's salary by 5%
        for (Employee e : staff)
        e.raiseSalary(5);

        // print out information about all Employee objects
        for (Employee e : staff)
        System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", hireDay="
        + e.getHireDay());

        double x = Employee.INTERESTRATE;

        /* Classes such as LocalDate and NumberFormat use static factory methods that
        construct objects.

        Why doesn’t the NumberFormat class use a constructor instead?
        1 You can’t give names to constructors. The constructor name is always the same as the class
        name. But we want two different names to get the currency instance and the percent instance.
        2 When you use a constructor, you can’t vary the type of the constructed object. But the factory
          methods actually return objects of the class DecimalFormat, a subclass that inherits from
          NumberFormat.*/
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        System.out.println(currencyFormatter.format(x)); // prints $2.14
        System.out.println(percentFormatter.format(x)); // prints 214%

        var stuff2 = new Employee[3];

        stuff2[0] = new Employee("Tom", 40000, 1991, 12, 15);
        stuff2[1] = new Employee("Dick", 60000, 1993, 12, 2);
        stuff2[2] = new Employee("Harry",75000, 1994, 3, 15);

        // print out information about all Employee objects
        for (Employee e : stuff2)
        {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
        }

        int n = Employee.getNextId(); // calls static method
        System.out.println("Next available id=" + n);

        Employee a = new Employee("Romeo", 50000, 2003, 3, 31);
        Employee b = new Employee("Jimmy", 60000, 2003, 3, 31);
        a.raiseSalary(10);

        /*
         * Test: Methods can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        Employee.swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

        /*  Before: a=Romeo
            Before: b=Jimmy
            After: a=Romeo
            After: b=Jimmy */


        /*
         * Test: Overloading occurs if several methods have the same name--Constructor in this case
         */
        var e = new Employee("Alice", 70000);
        System.out.println(e.getName() + " was hired on " + e.getHireDay() + " with salary of " + e.getSalary());
        e = new Employee("Linda");
        System.out.println(e.getName() + " was hired on " + e.getHireDay() + " with salary of " + e.getSalary());
        e = new Employee(67890);
        System.out.println(e.getName() + " was hired on " + e.getHireDay() + " with salary of " + e.getSalary());
        e = new Employee(50100);
        System.out.println(e.getName() + " was hired on " + e.getHireDay() + " with salary of " + e.getSalary());
        e = new Employee();
        System.out.println(e.getName() + " was hired on " + e.getHireDay() + " with salary of " + e.getSalary());
        var f = new Employee();
        System.out.println(e.getName() + " was hired on " + e.getHireDay() + " with salary of " + e.getSalary());
        System.out.println(e.equals(f));

        e = new Employee("Alice", 70000);
        var g = new Employee("Alice", 70000);
        System.out.println(g.equals(e));

        /*
         * Test: You can use a variable of type Object to refer to objects of any type
         */
        /*The Object class is the ultimate ancestor—every class in Java extends Object,
        only the values of primitive types (numbers, characters, and boolean values) are not objects.
        All array types, no matter whether they are arrays of objects or arrays of primitive types, are class
        types that extend the Object class.
        */
        Object obj = new Employee("Harry Hacker", 35000);
        obj = new Employee[10]; // OK
        System.out.println(obj.getClass());  //  class [Lcom.JiayiSu.employees.Employee;
        obj = new int[10]; // OK
        System.out.println(obj.getClass());  //  class [I

//        The following doesn't work. why???
//        obj = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//        for (int num : obj)
//            System.out.println(num);

        /*
         * Test: the equals, hashCode, and toString methods for the classes Employee and Manager
         */
        var alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var alice2 = alice1;
        var alice3 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        var bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));

        System.out.println("alice1 == alice3: " + (alice1 == alice3));

        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

        System.out.println("alice1.equals(bob): " + alice1.equals(bob));

        System.out.println("bob.toString(): " + bob);

        var carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        System.out.println("boss.toString(): " + boss); // boss is a Manager which extends ...inheritance.Employee!!
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());

        // fill the staff array list with three Employee objects
        var staff3 = new ArrayList<Employee>();

        staff3.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff3.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff3.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        // raise everyone's salary by 5%
        for (Employee e3 : staff3)
            e3.raiseSalary(5);

        // print out information about all Employee objects
        for (Employee e3 : staff3)
            System.out.println("name=" + e3.getName() + ",salary=" + e3.getSalary() + ",hireDay="
                    + e3.getHireDay());
    }
}

