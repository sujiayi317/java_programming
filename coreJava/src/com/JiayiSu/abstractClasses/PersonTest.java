package com.JiayiSu.abstractClasses;

/**
 * This program demonstrates abstract classes.
 * Could you have omitted the abstract method altogether from the Person super-class, simply defining
 * the getDescription methods in the Employee and Student sub-classes? --- If you did that, you
 * wouldn’t have been able to invoke the getDescription method on the variable p. The compiler
 * ensures that you invoke only methods that are declared in the class.
 *
 * A Side Note---protected:
 * fields in a class are best tagged as "private", and methods are usually tagged as
 * "public". Any features declared private won’t be accessible in other classes.
 * This is also true for subclasses: A subclass cannot access the private fields of its superclass.
 *
 * Java are accessible to all subclasses as well as to all other classes in the same package.
 *
 * In practice, use protected fields with caution. Suppose your class is used by other programmers and
 * you designed it with protected fields. Unknown to you, other programmers may inherit classes from
 * your class and start accessing your protected fields. In this case, you can no longer change the
 * implementation of your class without upsetting those programmers. That is against the spirit of OOP,
 * which encourages data encapsulation.
 * Protected methods make more sense. A class may declare a method as protected if it is tricky to
 * use. This indicates that the subclasses (which, presumably, know their ancestor well) can be trusted
 * to use the method correctly, but other classes cannot.
 */
public class PersonTest
{
   public static void main(String[] args)
   {
      var people = new Person[2];

      // fill the people array with Student and Employee objects
      people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      people[1] = new Student("Maria Morris", "computer science");

      // print out names and descriptions of all Person objects
      /*    p.getDescription()
       Isn’t this a call to an undefined method? Keep in mind that the variable p never refers to a Person
       object because it is impossible to construct an object of the abstract Person class. The variable p
       always refers to an object of a concrete subclass such as Employee or Student. For these
       objects, the getDescription method is defined.*/
      for (Person p : people)
         System.out.println(p.getName() + ", " + p.getDescription());
   }
}
