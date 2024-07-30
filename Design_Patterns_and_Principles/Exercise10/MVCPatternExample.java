// Step 2: Define Model Class
class Student {
    private String name;
    private String id;
    private String grade;

    // Constructor
    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

// Step 3: Define View Class
class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student Details:");
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Grade: " + student.getGrade());
    }
}

// Step 4: Define Controller Class
class StudentController {
    private Student student;
    private StudentView view;

    // Constructor
    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    // Method to update student details
    public void setStudentName(String name) {
        student.setName(name);
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentId(String id) {
        student.setId(id);
    }

    public String getStudentId() {
        return student.getId();
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    // Method to update the view
    public void updateView() {
        view.displayStudentDetails(student);
    }
}

// Step 5: Test the MVC Implementation
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create a student object (Model)
        Student student = new Student("John Doe", "S12345", "A");

        // Create a view object (View)
        StudentView view = new StudentView();

        // Create a controller object (Controller)
        StudentController controller = new StudentController(student, view);

        // Display the initial student details
        controller.updateView();

        // Update student details using the controller
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B+");

        // Display the updated student details
        controller.updateView();
    }
}
