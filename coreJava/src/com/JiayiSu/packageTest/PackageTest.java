package com.JiayiSu.packageTest;

import com.JiayiSu.employees.*;
// the Employee class is defined in that package


/* "import static ..." permits the importing of static methods and fields, not just classes
* then you can use the static methods and fields of the System class

Note: The compiler does not check the directory structure when it compiles source files.
For example, suppose you have a source file that starts with the directive
Click here to view code image
    package com.mycompany;
You can compile the file even if it is not contained in a subdirectory com\mycompany. The
source file will compile without errors if it doesn’t depend on other packages. However,
the resulting program will not run unless you first move all class files to the right place. The
virtual machine won’t find the classes if the packages don’t match the directories.


* Features tagged as public can be used by any class. Private features can be used only by
the class that defines them. If you don’t specify either public or private, the feature
(that is, the class, method, or variable) can be accessed by all methods in the same package.

For classes, this is a reasonable default. However, for variables,
this was an unfortunate choice. Variables must explicitly be marked private, or they will default to
having package access. This, of course, breaks encapsulation.
*/
import static java.lang.System.*;

public class PackageTest
{
    public static void main(String[] args)
    {
        // because of the import statement, we don't have to use
        // com.JiayiSu.employees.Employee here
        var harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        // because of the static import statement, we don't have to use System.out here
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}
