package com.JiayiSu.abstractClasses;

/**Student class extends the abstract Person class and implements the getDescription method.
 * None of the methods of the Student class are abstract, so it does not need to be declared as
 * an abstract class.
 */
public class Student extends Person
{
   private String major;

   /**
    * @param name the student's name
    * @param major the student's major
    */
   public Student(String name, String major)
   {
      // pass name to superclass constructor
      super(name);
      this.major = major;
   }

   public String getDescription()
   {
      return "a student majoring in " + major;
   }
}
