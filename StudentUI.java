import java.util.Scanner;

public class StudentUI {
    private Scanner sc = new Scanner(System.in);
    private StudentService service = new StudentService();

    public void start() {
        int choice;
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudentUI(); break;
                case 2: service.viewStudents(); break;
                case 3: updateStudentUI(); break;
                case 4: deleteStudentUI(); break;
                case 5: searchStudentUI(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private void addStudentUI() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student s = new Student(id, name, age, course);
        service.addStudent(s);
    }

    private void updateStudentUI() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new Course: ");
        String course = sc.nextLine();

        service.updateStudent(id, name, age, course);
    }

    private void deleteStudentUI() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        service.deleteStudent(id);
    }

    private void searchStudentUI() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        service.searchStudent(id);
    }
}
