package homework;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student;

    @Before
    public void setUp() {
        Double[] examScores = {80.0, 90.0, 95.0};
        student = new Student("Leon", "Hunter", examScores);
    }

    @Test
    public void testGetExamScores() {
        String expected = "Exam scores:\n" +
                "\tExam 1 -> 80.0\n" +
                "\tExam 2 -> 90.0\n" +
                "\tExam 3 -> 95.0\n";
        assertEquals(expected, student.getExamScores());
    }

    @Test
    public void testAddExamScore() {
        student.addExamScore(40.0);
        String expected = "Exam scores:\n" +
                "\tExam 1 -> 80.0\n" +
                "\tExam 2 -> 90.0\n" +
                "\tExam 3 -> 95.0\n" +
                "\tExam 4 -> 40.0\n";
        assertEquals(expected, student.getExamScores());
    }

    @Test
    public void testSetExamScore() {
        student.setExamScore(2, 75.0);
        String expected = "Exam scores:\n" +
                "\tExam 1 -> 80.0\n" +
                "\tExam 2 -> 75.0\n" +
                "\tExam 3 -> 95.0\n";
        assertEquals(expected, student.getExamScores());
    }


    @Test
    public void testGetAverageExamScore() {
        double numbers = (80.0 + 90.0 + 95.0) / 3;
        double expected = Double.parseDouble(String.format("%.2f", numbers));
        assertEquals(expected, student.getAverageExamScore(), 0.00);
    }


}