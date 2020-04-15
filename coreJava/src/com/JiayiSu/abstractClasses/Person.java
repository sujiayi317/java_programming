package com.JiayiSu.abstractClasses;

/**
 * For added clarity, a class with one or more abstract methods must itself be declared abstract.
 *
 * Abstract classes can have concrete methods.
 * You should always move common fields and methods (whether abstract or not) to the superclass
 * (whether abstract or not).
 *
 * Abstract methods act as placeholders for methods that are implemented in the subclasses. When you
 * extend an abstract class, you have two choices. You can leave some or all of the abstract methods
 * undefined; then you must tag the subclass as abstract as well. Or you can define all methods, and the
 * subclass is no longer abstract.
 *
 * Abstract classes cannot be instantiated. That is, if a class is declared as abstract, no objects of
 * that class can be created. For example, the expression
 *    new Person("Vince Vu")
 * is an error. However, you can create objects of concrete subclasses.
 * Note that you can still create object variables of an abstract class, but such a variable must refer to an
 * object of a nonabstract subclass. For example:
 *    Person p = new Student("Vince Vu", "Economics");
 * Here p is a variable of the abstract type Person that refers to an instance of the nonabstract subclass
 * Student.
 * */
public abstract class Person
{
   public abstract String getDescription(); // no implementation required
   private String name;

   public Person(String name)
   {
      this.name = name;
   }

   public String getName()
   {
      return name;
   }
}
