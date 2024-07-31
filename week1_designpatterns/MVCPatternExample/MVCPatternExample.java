public class MVCPatternExample {
    public static void main(String[] args) {
        
        Student model = retrieveStudentFromDatabase();

      
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

     
        controller.setStudentName("theo savio");
        controller.setStudentGrade("A");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setId("1");
        student.setName("rabinson");
        student.setGrade("B");
        return student;
    }
}
