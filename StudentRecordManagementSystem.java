import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String department;
    private double grade;

    public Student(int id, String name, String department, double grade) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.grade = grade;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setGrade(double grade) { this.grade = grade; }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + department + ", Grade: " + grade);
    }
}

public class StudentRecordManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();

        students.add(new Student(id, name, dept, grade));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt(); scanner.nextLine();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                s.setName(scanner.nextLine());
                System.out.print("Enter new department: ");
                s.setDepartment(scanner.nextLine());
                System.out.print("Enter new grade: ");
                s.setGrade(scanner.nextDouble());
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
