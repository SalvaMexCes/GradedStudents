package homework;

public class Main {
    public static void main(String[] args) {

        //Given
        Student student = new Student("Leon", "Kennedy", new Double[]{80.0, 90.0, 95.0});
        Student student2 = new Student("Cesar", "Machado", new Double[]{100.0, 100.0, 100.0});
        Student student3 = new Student("John", "Snow", new Double[]{70.0, 77.0, 90.0});
        Classroom classroom  = new Classroom();
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);


        //When
        student.addExamScore(44.0);
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        //Then
        System.out.println(student);
        System.out.println(classroom);



    }
}
