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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                        String firstName;
                        while (true) {
                            System.out.print("Enter first name: ");
                            firstName = scanner.nextLine();
                            if (firstName.matches("[a-zA-Z]+")) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a valid first name (alphabetic characters only).");
                            }
                        }
                        String lastName;
                        while (true) {
                            System.out.print("Enter last name: ");
                            lastName = scanner.nextLine();
                            if (lastName.matches("[a-zA-Z]+")) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a valid last name (alphabetic characters only).");
                            }
                        }
                        int studentId;
                        while (true) {
                            System.out.print("Enter student ID: ");
                            if (scanner.hasNextInt()) {
                                studentId = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a valid integer for the student ID.");
                                scanner.nextLine(); // Consume newline
                            }
                        }
                        studentList.add(new Student(firstName, lastName, studentId));
                        System.out.println("Student added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter last name to search: ");
                        String searchLastName = scanner.nextLine();
                        boolean found = false;
                        for (Student student : studentList) {
                            if (student.getFullName().endsWith(searchLastName)) {
                                System.out.println("Student found: " + student.getFullName());
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("No student found with the last name: " + searchLastName);
                        }
                        break;
                    case 3:
                        System.out.print("Enter full name to search: ");
                        String searchFullName = scanner.nextLine();
                        found = false;
                        for (Student student : studentList) {
                            if (student.getFullName().equals(searchFullName)) {
                                found = true;
                                String newFirstName;
                                while (true) {
                                    System.out.print("Enter new first name: ");
                                    newFirstName = scanner.nextLine();
                                    if (newFirstName.matches("[a-zA-Z]+")) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Please enter a valid first name (alphabetic characters only).");
                                    }
                                }
                                student.setFirstName(newFirstName);
                                String newLastName;
                                while (true) {
                                    System.out.print("Enter new last name: ");
                                    newLastName = scanner.nextLine();
                                    if (newLastName.matches("[a-zA-Z]+")) {
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Please enter a valid last name (alphabetic characters only).");
                                    }
                                }
                                student.setLastName(newLastName);
                                int newStudentId;
                                while (true) {
                                    System.out.print("Enter new student ID: ");
                                    if (scanner.hasNextInt()) {
                                        newStudentId = scanner.nextInt();
                                        scanner.nextLine(); // Consume newline
                                        break;
                                    } else {
                                        System.out.println("Invalid input. Please enter a valid integer for the new student ID.");
                                        scanner.nextLine(); // Consume newline
                                    }
                                }
                                student.setStudentId(newStudentId);
                                System.out.println("Student details updated!");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("No student found with the full name: " + searchFullName);
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
}
