package com.JiayiSu.employees;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.Random;

public class Employee implements Comparable<Employee>, Cloneable{
    // instance fields
    /* Strongly recommend to make all instance fields private. Because having public data fields
     would allow any part of the program to read and modify the instance fields,
     completely ruining encapsulation.*/

    /*The name and hireDay fields are references to String and LocalDate objects*/
    /*When you define a class, it is a good idea to be clear about which fields can be null.
    We don’t want the name or hireDay field to be null. (We don’t have to worry about the
    salary field. It has primitive type and can never be null.)
    The hireDay field is guaranteed to be non-null because it is initialized with a new
    LocalDate object.
    But name will be null if the constructor is called with a null argument for n.

    The “tough love” approach is preferred if you are NOT intend to model values
    that can be present or absent:

    public Employee(String n, double s, int year, int month, int day) {
        Objects.requireNonNull(n, "The name cannot be null");
        name = n;
        . . .
    }

    If someone constructs an Employee object with a null name, then a NullPointerException
    occurs. At first glance, that may not seem a useful remedy. But there are two advantages:
    1. The exception report has a description of the problem.
    2. The exception report pinpoints the location of the problem. Otherwise, a
        NullPointerException would have occurred elsewhere, with no easy way of tracing it
        back to the faulty constructor argument.

java.util.Objects
static <T> void requireNonNull(T obj)
static <T> void requireNonNull(T obj, String message)
static <T> void requireNonNull(T obj, Supplier<String> messageSupplier)
If obj is null, these methods throw a NullPointerException with no message or the
given message.

static <T> T requireNonNullElse(T obj, T defaultObj)
static <T> T requireNonNullElseGet(T obj, Supplier<T> defaultSupplier)
Returns obj if it is not null, or the default object if obj is null.
    */

    /*final--you must guarantee that the field value has been set after the end of every
     constructor. Afterwards, the field may not be modified again

     The final modifier is particularly useful for fields whose type is primitive or
     an immutable class. (A class is immutable if none of its methods ever mutate
     its objects. For example, the String class is immutable.)*/
    private String name = "";
    private double salary;
    private LocalDate hireDay;

    /*Every Employee object now has its own id field, but there is only one nextId field that is shared
among all instances of the class. i.e., If there are 1,000 objects of the Employee
class, then there are 1,000 instance fields id, one for each object. But there is a single static field
nextId. Even if there are no Employee objects, the static field nextId is present. It belongs to
the class, not to any individual object.*/
    public static final double INTERESTRATE = 2.14;
    private static int nextId;
    //        nextId = 1;
    private int id;

    // static initialization block
    // The initialization block runs first, and then the body of the constructor is executed.
    /* To initialize a static field, either supply an initial value or use a static initialization block */
    static {
        var generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    // object initialization block
    {
        id = nextId;
        nextId++;
    }

    // five overloaded constructor
    /*A constructor has the same name as the class.
     A class can have more than one constructor.
     A constructor can take zero, one, or more parameters.
     A constructor has no return value.
     A constructor is always called with the new operator.*/
    public Employee(String n, double s, int year, int month, int day) {
        Objects.requireNonNull(name, "The name cannot be null");
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public Employee(String aName, double aSalary) {
        Objects.requireNonNull(name, "The name cannot be null");
        name = aName;
        salary = aSalary;
        hireDay = LocalDate.of(2000, 1, 1);
    }

    public Employee(String name) { // parameter variables shadow instance fields with the same name.
        Objects.requireNonNull(name, "The name cannot be null");
        this.name = name;  // "this" denotes the implicit parameter i.e., the object being constructed
        this.salary = 0.0;
        this.hireDay = LocalDate.of(2000, 1, 1); // LocalDate is immutable
    }

    /* If the first statement of a constructor has the form this(. . .), then the constructor calls
    another constructor of the same class. */
    public Employee(double s) { // calls Employee(String, double) constructor
        this("Employee #" + nextId, s);
        Objects.requireNonNull(name, "The name cannot be null");
        nextId++;
    }
    public Employee() {
        this("Employee #" + nextId, 0.0);
        nextId++;
    }

    /*field accessors--getName, getSalary, and getHireDay methods*/
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    /* Be careful not to write accessor methods that return references to mutable objects.
    LocalDate class has no mutator methods.
    Date class has a mutator method, setTime*/
    public LocalDate getHireDay() {
        return hireDay;
    }

    /*The raiseSalary method has two parameters. The first parameter, called the implicit parameter,
    is the object of type Employee that appears before the method name. The second parameter, the
    number inside the parentheses after the method name, is an explicit parameter.
    (the implicit parameter a.k.a. the target or receiver of the method call)    */


    /**
     * Change the hire day to several days later.
     * @param days the decrement days of the hire day
     */
    public void decreaseHireDay(long days) {
        // example of instance field mutation
        hireDay = hireDay.plusDays(days);
    }

    public void setHireDay(int year, int month, int day) {
//        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        LocalDate newHireDay = LocalDate.of(year, month, day);
        // example of instance field mutation
        hireDay = newHireDay;
    }


    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /* Buggy!!! This method declares the explicit parameter type as Employee. As a result, it does not
    *override the equals method of the Object class but defines a completely unrelated method.

     public boolean equals(Employee other) {
        return other != null
        && getClass() == other.getClass()
        && Objects.equals(name, other.name)
        && salary == other.salary
        && Objects.equals(hireDay, other.hireDay);
    }

    *You can protect yourself against this type of error by tagging methods that are intended to
    *override superclass methods with @Override:

    @Override
    public boolean equals(Object other) {    // Note: if Employee instead of Object:
        // An error is reported because this method doesn’t override any method from the Object superclass.
        if (other != null) return name.equals(other.name);
        return false;
    }
    *
    */

    // A detailed usage of equals please refer to the file: "com.JiayiSu.inheritance.Manager.java"
    public boolean equals(Object otherObject)
    {
        // a quick test to see if the objects are identical
        if (this == otherObject) return true;
        // must return false if the explicit parameter is null
        if (otherObject == null) return false;
        // if the classes don't match, they can't be equal
        if (getClass() != otherObject.getClass())
            return false;
        // now we know otherObject is a non-null Employee
        Employee other = (Employee) otherObject;
        // test whether the fields have identical values
        return name.equals(other.name)           // use the Objects.equals method
                && salary == other.salary
                && hireDay.equals(other.hireDay);
    }


    /**Your definitions of equals and hashCode must be compatible: If x.equals(y) is true, then
     x.hashCode() must return the same value as y.hashCode(). For example, if you define
     Employee.equals to compare employee IDs, then the hashCode method needs to hash the IDs,
     not employee names or memory addresses.

    *Tip: If you have fields of an array type, you can use the static Arrays.hashCode method to
            compute a hash code composed of the hash codes of the array elements.
     ****************************************************************************************
     java.lang.Object
     ------------     int hashCode()
     returns a hash code for this object. A hash code can be any integer, positive or negative. Equal
     objects need to return identical hash codes.

     java.util.Objects
     -----------     static int hash(Object... objects)
     returns a hash code that is combined from the hash codes of all supplied objects.
     -----------      static int hashCode(Object a)
     returns 0 if a is null or a.hashCode() otherwise.

     java.lang.(Integer|Long|Short|Byte|Double|Float|Character|Boolean)
     ------------   static int hashCode(xxx value)
     returns the hash code of the given value. Here xxx is the primitive type corresponding to the
     given wrapper type.

     java.util.Arrays
     -----------      static int hashCode(xxx[] a)
     computes the hash code of the array a. The component type xxx of the array can be Object,
     int, long, short, char, byte, boolean, float, or double.
     ****************************************************************************************

     Here is a hashCode method for the Employee class:

    public int hashCode() {
        return 7 * name.hashCode()
            + 11 * new Double(salary).hashCode()
            + 13 * hireDay.hashCode();
    }

     However, you can do better.
     1, use the null-safe method Objects.hashCode. It returns 0 if its
     argument is null and the result of calling hashCode on the argument otherwise.
     2, use the static Double.hashCode method to avoid creating a Double object:
     Click here to view code image

     public int hashCode() {
        return 7 * Objects.hashCode(name)
            + 11 * Double.hashCode(salary)
            + 13 * Objects.hashCode(hireDay);
     }

     Even better, when you need to combine multiple hash values, call Objects.hash with all of them.
     It will call Objects.hashCode for each argument and combine the values. Then the
     Employee.hashCode method is simply as follows: */
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    /* A static method of the Employee class cannot access the id instance field because it does not
    operate on an object. However, a static method can access a static field.

    Use static methods in two situations:
    1. When a method doesn’t need to access the object state because all needed parameters are
    supplied as explicit parameters (example: Math.pow).
    2. When a method only needs to access static fields of the class (example:
    Employee.getNextId).

    Note: It is legal to use an object to call a static method. For example, if harry is an Employee
    object, then you can call harry.getNextId() instead of Employee.getNextId().
    However, we find that notation confusing. The getNextId method doesn’t look at harry
    at all to compute the result.*/
    public static int getNextId() {
        return nextId; // returns static field
    }
    // var a = Employee.getNextId();

    public void setId() {
        id = nextId;
        nextId++;
    }

    /* Java programming language does not use call by reference for objects.
    Instead, object references are passed by value.
    Here is a summary of what you can and cannot do with method parameters in Java:
        A method cannot modify a parameter of a primitive type (that is, numbers or boolean values).
        A method can change the state of an object parameter.
        A method cannot make an object parameter refer to a new object.
    If Java used call by reference for objects, this method would work: */
    public static void swap(Employee x, Employee y) { // !!!doesn't work!!!
        Employee temp = x;
        x = y;
        y = temp;
    }

    public int getId() {
        return id;
    }

    /* Every class can have a main method. That is a handy trick for unit testing of classes.
    For example, you can add a main method to the Employee class: */
    public static void main(String[] args) { // unit test
        Employee a = new Employee("Romeo", 50000, 2003, 3, 31);
        Employee b = new Employee("Jimmy", 60000, 2003, 3, 31);
        a.raiseSalary(10);

        /*
         * Test: Methods can't attach new objects to object parameters
         */
        System.out.println("\nTesting swap:");
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());

        // Or use this test:
        System.out.println(a.getName() + " " + a.getSalary());  // Romeo 55000.0
        swap(a, b);   // !!!doesn't work!!!
        System.out.println(a.getName() + " " + a.getSalary());  // Romeo 55000.0 still!!!

        var e = new Employee("Alice", 70000);
        System.out.println(e.name + " was hired on " + e.hireDay + " with salary of " + e.salary);
        e = new Employee("Linda");
        System.out.println(e.name + " was hired on " + e.hireDay + " with salary of " + e.salary);
        e = new Employee(67890);
        System.out.println(e.name + " was hired on " + e.hireDay + " with salary of " + e.salary);
        e = new Employee(50100);
        System.out.println(e.name + " was hired on " + e.hireDay + " with salary of " + e.salary);
        e = new Employee();
        System.out.println(e.name + " was hired on " + e.hireDay + " with salary of " + e.salary);
        var f = new Employee();
        System.out.println(e.name + " was hired on " + e.hireDay + " with salary of " + e.salary);
        System.out.println(e.equals(f));

        e = new Employee("Alice", 70000);
        var g = new Employee("Alice", 70000);
        System.out.println(g.equals(e));
    }
    /* If you want to test the Employee class in isolation, simply execute
        java Employee
    If the Employee class is a part of a larger application, you start the application with
        java Application
    and the main method of the Employee class is never executed. */

    /**** java.lang.Object      ********************************
     ---    Class getClass() ------------
    returns a class object that contains information about the object.
    Java has a runtime representation for classes that is encapsulated in the Class class.
     ---    boolean equals(Object otherObject) ------------
    compares two objects for equality; returns true if the objects point to the same area of
    memory, and false otherwise. You should override this method in your own classes.
     ---    String toString() ------------
    returns a string that represents the value of this object. You should override this method in your
    own classes.

     ***** java.lang.Class      ********************************
     ---    String getName() ------------
    returns the name of this class.
     ---    Class getSuperclass() ------------
    returns the superclass of this class as a Class object.

     The getClass() method in the Object class returns an instance of Class type.
     If the class is in a package, the package name is part of the class name:

     var generator = new Random();
     Class cl = generator.getClass();
     String name = cl.getName(); // name is set to "java.util.Random"

     You can obtain a Class object corresponding to a class name by using the static forName method.
     String className = "java.util.Random";
     Class cl = Class.forName(className);
     Use this method if the class name is stored in a string that varies at runtime. This works if
     className is the name of a class or interface. Otherwise, the forName method throws a checked
     exception.

     A third method for obtaining an object of type Class is a convenient shorthand. If T is any Java type
     (or the void keyword), then T.class is the matching class object. For example:
     Class cl1 = Random.class; // if you import java.util.*;
     Class cl2 = int.class;
     Class cl3 = Double[].class;
     Note that a Class object really describes a type, which may or may not be a class. For example,
     int is not a class, but int.class is nevertheless an object of type Class.

     The Class class is actually a generic class. For example, Employee.class is of type Class<Employee>.

     The virtual machine manages a unique Class object for each type. Therefore, you can use the ==
     operator to compare class objects. For example:
     if (e.getClass() == Employee.class) . . .
     This test passes if e is an instance of Employee. Unlike the condition e instanceof

     Caution
     For historical reasons, the getName method returns somewhat strange names for array types:
     Double[].class.getName()   returns "[Ljava.lang.Double;".
     int[].class.getName()   returns "[I".


     If you have an object of type Class, you can use it to construct instances of the class. Call the
     getConstructor method to get an object of type Constructor, then use the newInstance
     method to construct an instance. For example:
     var className = "java.util.Random"; // or any other name of a class with a no-arg constructor
     Class cl = Class.forName(className);
     Object obj = cl.getConstructor().newInstance();
     If the class doesn’t have a constructor without arguments, the getConstructor method throws an
     exception.
    */
    public String toString() {
        return getClass().getName() + "[name=" + name + ", salary=" + salary +
                ", hireDay="+ hireDay + "]";
    }

    /* Caution:
    In the interface declaration, the compareTo method was not declared public because all
    methods in an interface are automatically public. However, when implementing the interface,
    you must declare the method as public. Otherwise, the compiler assumes that the method
    has package access—the default for a class. The compiler then complains that you’re trying
    to supply a more restrictive access privilege.

    Tip:
    The compareTo method of the Comparable interface returns an integer. If the objects are
    not equal, it does not matter what negative or positive value you return. This flexibility can
    be useful when you are comparing integer fields. For example, suppose each employee has a
    unique integer id and you want to sort by the employee ID number. Then you can simply
    return id - other.id. That value will be some negative value if the first ID number is
    less than the other, 0 if they are the same ID, and some positive value otherwise. However,
    there is one caveat: The range of the integers must be small enough so that the subtraction
    does not overflow. If you know that the IDs are not negative or that their absolute value is at
    most (Integer.MAX_VALUE - 1) / 2, you are safe. Otherwise, call the static
    Integer.compare method.
    Of course, the subtraction trick doesn’t work for floating-point numbers. The difference
    salary - other.salary can round to 0 if the salaries are close together but not
    identical. The call Double.compare(x, y) simply returns -1 if x < y or 1 if x >
    y.

    Note:
    The documentation of the Comparable interface suggests that the compareTo method
    should be compatible with the equals method. That is, x.compareTo(y) should be
    zero exactly when x.equals(y). Most classes in the Java API that implement
    Comparable follow this advice. A notable exception is BigDecimal. Consider x =
    new BigDecimal("1.0") and y = new BigDecimal("1.00"). Then
    x.equals(y) is false because the numbers differ in precision. But
    x.compareTo(y) is zero. Ideally, it shouldn’t be, but there was no obvious way of
    deciding which one should come first.

    Q: why can’t the Employee class simply provide a compareTo method without
    implementing the Comparable interface?
    A: The reason for interfaces is that the Java programming language is strongly typed. When making a
    method call, the compiler needs to be able to check that the method actually exists. Somewhere in the
    sort method will be statements like this:
    if (a[i].compareTo(a[j]) > 0) {
        // rearrange a[i] and a[j]
        . . .
    }
    The compiler must know that a[i] actually has a compareTo method. If a is an array of
    Comparable objects, then the existence of the method is assured because every class that
    implements the Comparable interface must supply the method.


    java.lang.Comparable<T> -----------------------------------------
    int compareTo(T other)
        compares this object with other and returns a negative integer if this object is less than
        other, zero if they are equal, and a positive integer otherwise.
    java.util.Arrays  -----------------------------------------
    static void sort(Object[] a)
        sorts the elements in the array a. All elements in the array must belong to classes that implement
        the Comparable interface, and they must all be comparable to each other.
    java.lang.Integer  -----------------------------------------
    static int compare(int x, int y)
        returns a negative integer if x < y, zero if x and y are equal, and a positive integer otherwise.
    java.lang.Double  -----------------------------------------
    static int compare(double x, double y)
        returns a negative integer if x < y, zero if x and y are equal, and a positive integer otherwise.
    */
    /**
     * Compares employees by salary, this and other should be in the same class
     * @param other another Employee object
     * @return a negative value if this employee has a lower salary than
     * otherObject, 0 if the salaries are the same, a positive value otherwise
     */
    public int compareTo(Employee other) {
        int result = 0;
        // a quick test to see if the objects are identical
        if (this != other) {
            if (other == null) throw new NullPointerException();
            if (getClass() != other.getClass())
                throw new ClassCastException(); // if the classes don't match, they can't compare
            result = Double.compare(salary, other.salary); // now, compare their salaries
        }
        return result;
    }

    /*
    var original = new Employee("John Public", 50000);
    Employee copy = original;
    copy.raiseSalary(10); // oops--also changed original

    If you would like copy to be a new object that begins its life being identical to original but
    whose state can diverge over time, use the clone method.

    Employee copy = original.clone();
    copy.raiseSalary(10); // OK--original unchanged

    But it isn’t quite so simple. The clone method is a protected method of Object, which means
    that your code cannot simply call it. Only the Employee class can clone Employee objects. There
    is a reason for this restriction. Think about the way in which the Object class can implement
    clone. It knows nothing about the object at all, so it can make only a field-by-field copy. If all data
    fields in the object are numbers or other basic types, copying the fields is just fine. But if the object
    contains references to subobjects, then copying the field gives you another reference to the same
    subobject, so the original and the cloned objects still share some information.

    The default cloning operation is “shallow”—it doesn’t clone objects that are
    referenced inside other objects.

    Quite frequently, however, subobjects are mutable, and you must redefine the clone method to make
    a deep copy that clones the subobjects as well. In our example, the hireDay field is a Date, which
    is mutable, so it too must be cloned.

    For every class, you need to decide whether
    1. The default clone method is good enough;
    2. The default clone method can be patched up by calling clone on the mutable subobjects; or
    3. clone should not be attempted.
    The third option is actually the default. To choose either the first or the second option, a class must
    1. Implement the Cloneable interface; and
    2. Redefine the clone method with the public access modifier.

    In this case, the appearance of the Cloneable interface has nothing to do with the normal use of
    interfaces. In particular, it does not specify the clone method—that method is inherited from the
    Object class. The interface merely serves as a tag, indicating that the class designer understands the
    cloning process. Objects are so paranoid about cloning that they generate a checked exception if an
    object requests cloning but does not implement that interface.
    Note

    Note:
    The Cloneable interface is one of a handful of tagging interfaces that Java provides.
    (Some programmers call them marker interfaces.) Recall that the usual purpose of an
    interface such as Comparable is to ensure that a class implements a particular method or
    set of methods. A tagging interface has no methods; its only purpose is to allow the use of
    instanceof in a type inquiry:
        if (obj instanceof Cloneable) . . .
    We recommend that you do not use tagging interfaces in your own programs. */
    // public access, change return type
    public Employee clone() throws CloneNotSupportedException
    {
        // call Object.clone()
        Employee cloned = (Employee) super.clone();

        // clone mutable fields
//        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }
}