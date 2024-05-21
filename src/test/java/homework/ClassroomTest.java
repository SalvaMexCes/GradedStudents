package homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {

    private Classroom classroom;
    private Student student;
    private Student student2;
    private Student student3;
    private Student student4;

    @BeforeEach
    void setUp() {
        student = new Student("Leon", "Kennedy", new Double[]{80.0, 90.0, 95.0});
        student2 = new Student("Cesar", "Machado", new Double[]{100.0, 100.0, 100.0});
        student3 = new Student("John", "Snow", new Double[]{70.0, 77.0, 90.0});
        classroom = new Classroom(new Student[]{student, student2, student3});
    }

    @Test
    void testGetAverageExamScore() {
        double expectedAverage = (student.getAverageExamScore() + student2.getAverageExamScore() + student3.getAverageExamScore()) / 3;
        assertEquals(expectedAverage, classroom.getAverageExamScore());
    }

    @Test
    void testAddStudent() {
        student4 = new Student("Steve", "Jobs", new Double[]{90.0, 93.0, 99.0});
        classroom.addStudent(student4);
        Student[] expectedStudents = new Student[]{student, student2, student3};
        assertArrayEquals(expectedStudents, classroom.getStudents());
    }

    @Test
    void testRemoveStudent() {
        classroom.removeStudent("Cesar", "Machado");
        Student[] expectedStudents = new Student[]{student, student3, null};
        assertArrayEquals(expectedStudents, classroom.getStudents());
    }
}