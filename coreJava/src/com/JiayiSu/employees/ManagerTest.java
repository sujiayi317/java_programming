package com.JiayiSu.employees;

import java.util.Arrays;

/**
 * This program demonstrates inheritance.
 * Manager is a subclass of Employee
 *
 * The fact that an object variable (such as the variable e) can refer to multiple actual types is called
 * "polymorphism". Automatically selecting the appropriate method at runtime is called "dynamic binding".
 *
 * Object variables are polymorphic. A variable of type Employee
 * can refer to an object of type Employee or to an object of any subclass of the Employee class
 * (such as Manager, Executive, Secretary, and so on).
 */
public class ManagerTest
{
   public static void main(String[] args)
   {
      // construct a Manager object
      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
      boss.setBonus(5000);

      Manager boss2 = new Manager("Young Cracker", 78000, 2005, 12, 3);
      boss2.setBonus(6000);

      var staff = new Employee[4];

      // fill the staff array with Manager and Employee objects

      staff[0] = boss;  // the variables staff[0] and boss refer to the same object
      /* However, staff[0] is considered to be only an Employee object by the compiler!!!
      That means you can call:
         boss.setBonus(5000); // OK
      but you can’t call:
         staff[0].setBonus(5000); // ERROR
      The declared type of staff[0] is Employee, and the setBonus method is not a method of the Employee class.*/
      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
      staff[3] = boss2;  // the variables staff[0] and boss2 refer to the same object

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());

      System.out.println(staff[0].getClass().getName());
//      (The following won't work.
//      Exception in thread "main" java.lang.ClassCastException:
//      class com.JiayiSu.inheritance.Employee cannot be cast to class com.JiayiSu.inheritance.Manager)
//      Manager bo = (Manager) staff[1];
//      System.out.println(bo.getName());

      System.out.println("The hash code for the manager boss is " + boss.hashCode());

      var leaders = new Manager[2];
      leaders[0] = boss;
      leaders[1] = boss2;

      Arrays.sort(leaders);
      System.out.println("leaders sorted according to the salary:-----------------------------------------");
      for (Employee e : leaders) {
         e.setId();
         System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                 + e.getSalary());
      }
   }
}
