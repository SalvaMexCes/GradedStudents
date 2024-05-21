package homework;
import java.util.*;

public class Classroom {

    //Part 2.1
    //Declare an instance variable for each of the Classroom properties
    private Student[] students;


    //Part 2.2
    //Define a Classroom constructor whose parameters are used to initialize its instance variable. The class Classroom should support 3 different ways of being constructed.
    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }


    //Part 2.3
    //Define a getter which returns the composite students object.
    public Student[] getStudents() {
        return students;
    }

    //Define a getter which returns the sum of all exam averages divided by the number of students.
    public double getAverageExamScore() {
        double sum = 0;
        int count = 0;
        for (Student student : students) {
            if (student != null) {
                sum += student.getAverageExamScore();
                count++;
            }
        }
        if (count > 0) {
            return sum / count;
        } else {
            return 0;
        }
    }

    //Define a method which uses a Student parameter to add a Student object to the composite students list.
    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
    }

    //Define a method which uses a firstName and lastName parameter to identify and remove the respective student from composite students object.
    //Ensure the array is re-ordered after the removal; Null values should be located in the final indices of the array.
    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getFirstName().equals(firstName)
                    && students[i].getLastName().equals(lastName)) {
                students[i] = null;
                // Re-order the array
                for (int j = i; j < students.length - 1; j++) {
                    students[j] = students[j + 1];
                    students[j + 1] = null;
                }
                return;
            }
        }
    }

    //Define a method getStudentsByScore() which returns an array representation of Student objects sorted in descending order by score.
    //If two students have the same class average, order them lexicographically.
    public Student[] getStudentsByScore() {
        List<Student> studentList = Arrays.asList(students);
        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.getAverageExamScore(), s1.getAverageExamScore());
            if (compare == 0) {
                compare = s1.getLastName().compareTo(s2.getLastName());
                if (compare == 0) {
                    compare = s1.getFirstName().compareTo(s2.getFirstName());
                }
            }
            return compare;
        });
        return studentList.toArray(new Student[0]);
    }

    @Override
    public String toString() {
        return "Students in classroom:\n" + Arrays.toString(students);
    }
}

