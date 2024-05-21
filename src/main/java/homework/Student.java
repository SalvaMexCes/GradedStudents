package homework;
import java.util.*;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder result = new StringBuilder();
        result.append("Exam scores:\n");
        int examNumber = 1;
        for (Double score : examScores) {
            result.append("\tExam ").append(examNumber).append(" -> ").append(score).append("\n");
            examNumber++;
        }
        return result.toString();
    }

    public void addExamScore(double newScore) {
        examScores.add(newScore);
    }

    public double getAverageExamScore() {
        double x = 0;
        for (Double score : examScores) {
            x += score;
        }
        double avg = x / examScores.size();
        return Double.parseDouble(String.format("%.2f", avg));

    }

    public void setExamScore(int examNumber, double newScore) {
        if (examNumber > 0 && examNumber <= examScores.size()) {
            examScores.set(examNumber - 1, newScore);
        } else {
            throw new IndexOutOfBoundsException("Invalid exam number");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tStudent Name: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("\tAverage Score: ").append(getAverageExamScore()).append("\n");
        sb.append("\tExam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("    Exam ").append(i + 1).append(" -> ").append(examScores.get(i)).append("\n");
        }
        return sb.toString();
    }

}
