import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: searchStudent(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
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

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new Age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter new Course: ");
                s.setCourse(sc.nextLine());
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
