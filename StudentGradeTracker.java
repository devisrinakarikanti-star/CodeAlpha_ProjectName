import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 80)
            return "B";
        else if (marks >= 70)
            return "C";
        else if (marks >= 60)
            return "D";
        else
            return "F";
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10.2f %-5s",
                id, name, marks, getGrade());
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println(" STUDENT GRADE TRACKER SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Statistics Report");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateMarks();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    generateReport();
                    break;
                case 7:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));

        System.out.println("Student Added Successfully!");
    }

    static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        System.out.println("\n------------------------------------------------");
        System.out.printf("%-5s %-15s %-10s %-5s\n",
                "ID", "NAME", "MARKS", "GRADE");
        System.out.println("------------------------------------------------");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("\nStudent Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void updateMarks() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {

                System.out.print("Enter New Marks: ");
                double marks = sc.nextDouble();

                s.setMarks(marks);

                System.out.println("Marks Updated!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student Deleted!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    static void generateReport() {

        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }

        double total = 0;
        double highest = students.get(0).getMarks();
        double lowest = students.get(0).getMarks();

        String topStudent = students.get(0).getName();
        String lowStudent = students.get(0).getName();

        for (Student s : students) {

            total += s.getMarks();

            if (s.getMarks() > highest) {
                highest = s.getMarks();
                topStudent = s.getName();
            }

            if (s.getMarks() < lowest) {
                lowest = s.getMarks();
                lowStudent = s.getName();
            }
        }

        double average = total / students.size();

        System.out.println("\n========== REPORT ==========");
        System.out.printf("Total Students : %d\n", students.size());
        System.out.printf("Average Marks  : %.2f\n", average);
        System.out.printf("Highest Marks  : %.2f (%s)\n",
                highest, topStudent);
        System.out.printf("Lowest Marks   : %.2f (%s)\n",
                lowest, lowStudent);
        System.out.println("============================");
    }
}