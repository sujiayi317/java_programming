
class Student {
    String firstName;
    String lastName;
    int yearToGraduate;
    double gpa;
    String major;

    public Student(String firstName, String lastName, int yearToGraduate,
                   double gpa, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearToGraduate = yearToGraduate;
        this.gpa = gpa;
        this.major = major;
    }

    public int incrementExpectedGraduationYear() {
        return this.yearToGraduate++;
    }

}

public class StudentProfile {
    public static void main(String[] args) {
        Student studentA = new Student("Judie", "Dong",
                2, 3.98, "Computer Science");
        Student studentB = new Student("Bernard", "Dong",
                1, 3.70, "Computer Engineering");

        int years = studentA.incrementExpectedGraduationYear();
        System.out.println(studentA.firstName + " " + studentA.lastName + " in " +
                studentA.major + " has GPA of " + studentA.gpa + " needs " +
                years + " years to graduate.");

    }


}
