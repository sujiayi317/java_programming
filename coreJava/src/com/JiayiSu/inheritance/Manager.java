package com.JiayiSu.inheritance;

import java.util.Objects;

public class Manager extends Employee
{
   private double bonus;

   /**
    * @param name the employee's name
    * @param salary the salary
    * @param year the hire year
    * @param month the hire month
    * @param day the hire day
    */
   public Manager(String name, double salary, int year, int month, int day)
   {
      super(name, salary, year, month, day);
      bonus = 0;
   }

   public double getSalary()
   {
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
   }

   public boolean equals(Object otherObject) {
//      if (!(otherObject instanceof Employee)) return false;
// bad: equals method must be willing to compare itself to
// any Employee, without taking manager-specific information into account!
      if (!super.equals(otherObject)) return false;
      // super.equals checked that this and otherObject belong to the same class
      Manager other = (Manager) otherObject;
      return bonus == other.bonus;
   }
/* The standard Java library contains over 150 implementations of equals methods, with a mishmash of
using instanceof, calling getClass, catching a ClassCastException, or doing nothing at all.

A recipe for writing the perfect equals method:
1. Name the explicit parameter otherObject—later, you will need to cast it to another variable
   that you should call other.
2. Test whether this happens to be identical to otherObject:
   if (this == otherObject) return true;
   This statement is just an optimization. In practice, this is a common case. It is much cheaper to
3. Test whether otherObject is null and return false if it is. This test is required.
   if (otherObject == null) return false;
4. Compare the classes of this and otherObject. If the semantics of equals can change in
   subclasses, use the getClass test:
   if (getClass() != otherObject.getClass()) return false;
   If the same semantics holds for all subclasses, you can use an instanceof test:
   if (!(otherObject instanceof ClassName)) return false;
5. Cast otherObject to a variable of your class type:
   ClassName other = (ClassName) otherObject
6. Now compare the fields, as required by your notion of equality. Use == for primitive type fields,
   Objects.equals for object fields. Return true if all fields match, false otherwise.
   return field1 == other.field1
   && Objects.equals(field2, other.field2)
   && . . .;
   If you redefine equals in a subclass, include a call to super.equals(other).

   If you have fields of array type, you can use the static Arrays.equals method to check
that the corresponding array elements are equal.
*/

   public int hashCode() {
//      return Objects.hash(this.getName(), this.getSalary(), this.getHireDay(), bonus);
//      better:
      return java.util.Objects.hash(super.hashCode(), bonus);
   }

   public void setBonus(double b)
   {
      bonus = b;
   }
   /*When you define the equals method for a subclass, first call equals on the superclass. If that test
   doesn’t pass, then the objects can’t be equal.   If the superclass fields are equal, you are ready to
   compare the instance fields of the subclass.

   equals method has the following properties:
1. It is reflexive: For any non-null reference x, x.equals(x) should return true.
2. It is symmetric: For any references x and y, x.equals(y) should return true if and only if
y.equals(x) returns true.
3. It is transitive: For any references x, y, and z, if x.equals(y) returns true and
y.equals(z) returns true, then x.equals(z) should return true.
4. It is consistent: If the objects to which x and y refer haven’t changed, then repeated calls to
x.equals(y) return the same value.
5. For any non-null reference x, x.equals(null) should return false.
   */

   public String toString() {
      return super.toString() + "[bonus=" + bonus + "]";
   }
}

