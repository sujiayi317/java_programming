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
import java.util.Arrays;
import java.util.Comparator;

//import com.JiayiSu.inheritance.Manager;

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

        var staff2 = new Employee[5];

        staff2[0] = new Employee("Tom", 78000, 1991, 12, 15);
        staff2[1] = new Employee("Dick", 60000, 1993, 12, 2);
        staff2[2] = new Employee("Harry",60000, 1994, 3, 15);
        staff2[3] = new Employee("Denny", 60000, 1982, 5, 2);
        staff2[4] = new Employee("David Liu",72000, 1985, 9, 25);

        Arrays.sort(staff2);  // use the Comparable interface.


        // print out information about all Employee objects
        System.out.println("Staff2 sorted according to the salary:-----------------------------------------");
        for (Employee e : staff2) {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
        }

        /* The Comparator interface has a number of convenient static methods for creating comparators.
        These methods are intended to be used with lambda expressions or method references.
        The static comparing method takes a “key extractor” function that maps a type T to a comparable
        type (such as String). The function is applied to the objects to be compared, and the comparison is
        then made on the returned keys.

        You can chain comparators with the thenComparing method for breaking ties.*/
        Arrays.sort(staff2, Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName));

        System.out.println("Staff2 sorted first according to the salary, then by name if the salary ties:-----------");
        for (Employee ep : staff2) {
            ep.setId();
            System.out.println("name=" + ep.getName() + ",id=" + ep.getId() + ",salary="
                    + ep.getSalary());
        }

        /* There are a few variations of these methods. You can specify a comparator to be used for the keys that
        the comparing and thenComparing methods extract. For example, here we sort people by the
        length of their names: */
        Arrays.sort(staff2, Comparator.comparing(Employee::getName,
                (s, t) -> Integer.compare(s.length(), t.length())));
        System.out.println("Staff2 sorted according to the length of the name:-----------");
        for (Employee ep : staff2) {
            ep.setId();
            System.out.println("name=" + ep.getName() + ",id=" + ep.getId() + ",salary="
                    + ep.getSalary());
        }

        /* Moreover, both the comparing and thenComparing methods have variants that avoid boxing of
        int, long, or double values. An easier way of producing the preceding operation would be
        */
        Arrays.sort(staff2, Comparator.comparingInt(p -> p.getName().length()));
        System.out.println("Staff2 sorted again according to the length of the name:-----------");
        for (Employee ep : staff2) {
            ep.setId();
            System.out.println("name=" + ep.getName() + ",id=" + ep.getId() + ",salary="
                    + ep.getSalary());
        }


        /* If your key function can return null, you will like the nullsFirst and nullsLast adapters.
        These static methods take an existing comparator and modify it so that it doesn’t throw an exception
        when encountering null values but ranks them as smaller or larger than regular values. For example,
        suppose getMiddleName returns a null when a person has no middle name. Then you can use
        Comparator.comparing(Person::getMiddleName(),
        Comparator.nullsFirst(. . .)).
        The nullsFirst method needs a comparator—in this case, one that compares two strings. The
        naturalOrder method makes a comparator for any class implementing Comparable. A
        Comparator.<String>naturalOrder() is what we need.
        Use a static import of java.util.Comparator.*, to make the expression more legible.
        Note that the type for naturalOrder is inferred.

        Arrays.sort(people, comparing;(Person::getMiddleName, nullsFirst(naturalOrder()))); */

        /* The static reverseOrder method gives the reverse of the natural order. To reverse any
        comparator, use the reversed instance method. For example,
        naturalOrder().reversed() is the same as reverseOrder(). */
        Arrays.sort(staff2, Comparator.comparing(Employee::getSalary).reversed());
        System.out.println("Staff2 sorted a third time according to the salary reversed:-----------");
        for (Employee ep : staff2) {
            ep.setId();
            System.out.println("name=" + ep.getName() + ",id=" + ep.getId() + ",salary="
                    + ep.getSalary());
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


        /*
         * Test: Use an ArrayList to store employees. Note the following changes:
            You don’t have to specify the array size.
            You use add to add as many elements as you like.
            You use size() instead of length to count the number of elements.
            You use a.get(i) instead of a[i] to access an element.

        java.util.ArrayList<E>  ---------------------------------
        E set(int index, E obj)
            puts the value obj in the array list at the specified index, returning the previous contents.
        E get(int index)
            gets the value stored at a specified index.
        void add(int index, E obj)
            shifts up elements to insert obj at the specified index.
        E remove(int index)
            removes the element at the given index and shifts down all elements above it. The removed
            element is returned.
        */

        // fill the staff array list with three Employee objects
        ArrayList<Employee> staff3;
        staff3 = new ArrayList<Employee>();

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
        System.out.println("\nWe can also traverse the contents of an ArrayList this way: ");
        for (int i = 0; i < staff3.size(); i++) {
            Employee loop_emp = staff3.get(i);
            System.out.println(loop_emp.getName());
        }

        /* You can sometimes get the best of both worlds—flexible growth and convenient element access of an ArrayList
         * 1 First, make an array list and add all the elements (did above)
         * 2 When you are done, use the toArray method to copy the elements into an array: */
        var arrayStaff3 = new Employee[staff3.size()];
        staff3.toArray(arrayStaff3);  // copy the elements from the ArrayList into an array
        System.out.println("arrayStaff3[0] is "+ arrayStaff3[0]);  // an array can use convenient element access :)
        System.out.println("arrayStaff3[0] is "+ staff3.get(0));   // an ArrayList must use the get() method to access

        /* Sometimes, you need to add elements in the middle of an array list. Use the add method with an
        index parameter: */
        int insertIndex = staff3.size() / 2;
        staff3.add(insertIndex, new Employee("Middle Tester", 40000, 1990, 3, 15));
        /* The elements at locations insertIndex and above are shifted up to make room for the new entry. If the new size
        of the array list after the insertion exceeds the capacity, the array list reallocates its storage array. */
        System.out.println("now the size of staff3 is " + staff3.size() + ". The elements are: ");
        for (Employee e3 : staff3)
            System.out.println("name=" + e3.getName() + ",salary=" + e3.getSalary() + ",hireDay="
                    + e3.getHireDay());

        /* Similarly, you can remove an element from the middle of an array list: */
        Employee removed_emp = staff3.remove(insertIndex);   // remove the just inserted employee
        System.out.println("the removed employee is " + removed_emp);



        var original = new Employee("John Q. Public", 50000);

//        use instanceof to check whether an object implements an interface:
        if (original instanceof Comparable) System.out.println("original instanceof Comparable");


        System.out.println("original=" + original);
        Employee copy = null;
        try {
            copy = original.clone();
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
        }
        original.decreaseHireDay(20L);
        System.out.println("original's HireDay decrements 20 days");
        copy.raiseSalary(10);
        copy.decreaseHireDay(3L);
        System.out.println("copy's HireDay decrements 3 days and raises salary by 10 percent");
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);

        System.out.println("\nAfter setting Hire Day for both: ");
        original.setHireDay(2015, 1, 1);
        copy.setHireDay(2016, 12, 31);
        System.out.println("original=" + original);
        System.out.println("copy=" + copy);
    }
}

