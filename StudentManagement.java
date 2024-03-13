import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private int studentId;

    public Student(String firstName, String lastName, int studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Enter Student List");
            System.out.println("2. Find Students by Last Name");
            System.out.println("3. Find and Edit Students by Full Name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume newline
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    studentList.add(new Student(firstName, lastName, studentId));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter last name to search: ");
                    String searchLastName = scanner.nextLine();
                    for (Student student : studentList) {
                        if (student.getFullName().endsWith(searchLastName)) {
                            System.out.println("Student found: " + student.getFullName());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter full name to search: ");
                    String searchFullName = scanner.nextLine();
                    for (Student student : studentList) {
                        if (student.getFullName().equals(searchFullName)) {
                            System.out.print("Enter new student ID: ");
                            int newStudentId = scanner.nextInt();
                            student.setStudentId(newStudentId);
                            System.out.println("Student details updated!");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
