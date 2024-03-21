import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentListToXML {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", 20, 3.8));
        studentList.add(new Student("Bob", 21, 3.5));
        studentList.add(new Student("Charlie", 19, 3.9));

        // Xuất danh sách sinh viên dưới dạng file XML
        try {
            FileWriter writer = new FileWriter("student_list.xml");
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<students>\n");
            for (Student student : studentList) {
                writer.write("<student>\n");
                writer.write("    <name>" + student.getName() + "</name>\n");
                writer.write("    <age>" + student.getAge() + "</age>\n");
                writer.write("    <gpa>" + student.getGpa() + "</gpa>\n");
                writer.write("</student>\n");
            }
            writer.write("</students>");
            writer.close();
            System.out.println("Đã tạo file XML thành công.");
        } catch (IOException e) {
            System.out.println("Không thể tạo file XML.");
        }
    }
}

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}
