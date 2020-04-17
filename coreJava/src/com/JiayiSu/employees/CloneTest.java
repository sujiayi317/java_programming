package com.JiayiSu.employees;

/**
 * This program demonstrates cloning.
 */
public class CloneTest
{
   public static void main(String[] args) throws CloneNotSupportedException
   {
      var original = new Employee("John Q. Public", 50000);
      System.out.println("original=" + original);

//      Employee copy = original.clone();
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
