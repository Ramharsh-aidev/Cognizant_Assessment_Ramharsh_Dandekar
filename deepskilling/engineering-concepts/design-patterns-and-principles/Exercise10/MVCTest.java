public class MVCTest {
    public static void main(String[] args) {
        System.out.println("Testing MVC Pattern\n");

        Student model = new Student("S158", "Ramharsh Dandekar", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        System.out.println("\nUpdating student details via Controller...");
        controller.setStudentName("Ramharsh Sanjay Dandekar");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}
