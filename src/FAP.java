
import java.util.ArrayList;
import java.util.Scanner;

public class FAP {

    StudentList listStudents;
    CourseList listCourse;

    public FAP() {
        listStudents = new StudentList();
        listCourse = new CourseList();
    }
//hihi

    public void addStudentFromKeyboard() {
        String count = "N";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter major: ");
            String major = sc.nextLine();
            Student stu = new Student(id, name, major);
            listStudents.add(stu);
            System.out.println("Done");
            System.out.print("add any more? (Y/N): ");
            count = sc.nextLine();

        } while (count.equalsIgnoreCase("Y"));
    }

    public void addCourseFromKeyboard() {
        String count = "N";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter code: ");
            String code = sc.nextLine();
            System.out.print("Enter credit: ");
            int credit = sc.nextInt();
            sc.nextLine();
            Course c = new Course();
            c.setCode(code);
            c.setCredit(credit);
            listCourse.add(c);
            System.out.println("Done");
            System.out.print("add any more? (Y/N): ");
            count = sc.nextLine();

        } while (count.equalsIgnoreCase("Y"));
    }

    public void printCourse() {
        System.out.println("SO MON HOC CUA TRUONG");
        listCourse.displayAll();
    }

    public void printStudent() {
        if (listStudents.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            System.out.println("----------THONG TIN SINH VIEN----------");
            listStudents.displayAll();
        }
    }

    public void displayStudentById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id to find: ");
        int id = sc.nextInt();
        Student rs = listStudents.findStudentById(id);
        if (rs == null) {
            System.out.println("Not found student with id: " + id);
        } else {
            System.out.println("----------THONG TIN SINH VIEN CAN TIM----------");
            System.out.println(rs);
        }
    }

    public void displayStudentByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to find: ");
        String name = sc.nextLine();
        ArrayList<Student> rs = listStudents.findStudentByName(name);
        if (rs != null && !rs.isEmpty()) {
            for (Student s : rs) {
                System.out.println("----------DANH SACH SINH VIEN TIM THAY----------");
                System.out.println(s);
                System.out.println("--------");
            }
        } else {
            System.out.println("Not found student with name: " + name);
        }
    }

    public void updateStudentById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student'Id to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student stu = listStudents.findStudentById(id);
        if (stu == null) {
            System.out.println("Not found student with id: " + id + " to update");
        } else {
            System.out.println("----------THONG TIN SINH VIEN CU----------");
            System.out.println(stu);
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new major: ");
            String major = sc.nextLine();
            listStudents.updateStudentById(id, name, major);
            System.out.println("Updated student successfully");
        }
    }

//    public void displayEnrroledStudent() {
//        System.out.println("----------DANH SACH SINH VIEN----------");
//        listStudents.displayAll();
//        System.out.println("Enter student'Id to enroll: ");
//        Scanner sc = new Scanner(System.in);
//        int id = sc.nextInt();
//        Student stu = listStudents.findStudentById(id);
//        if (stu == null) {
//            System.out.println("Not found student with id: " + id);
//        } else {
//            if (courseList.enrolledStudent(stu) == true) {
//                System.out.println("Enroll successfully in course: " + courseList.getCode());
//                courseList.displayCourse();
//            } else {
//                System.out.println("Student already exist");
//            }
//        }
//    }
    public void removeStudentById() {
        System.out.println("----------DANH SACH SINH VIEN----------");
        listStudents.displayAll();
        System.out.print("Enter student'Id to delete: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Student stu = listStudents.findStudentById(id);
        if (stu != null) {
            listStudents.remove(listStudents.findStudentById(id));
            System.out.println("Removed student successfully");
        }
    }

    public void displayStudentByMajor() {
        System.out.println("----------DANH SACH SINH VIEN CUNG NGANH----------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter list of student with the same major: ");
        String major = sc.nextLine();
        for (Student stu : listStudents.displayStudentByMajor(major)) {
            System.out.println(stu);
        }
    }

    public void sortStudentByName() {
        listStudents.sort(listStudents.sortStudentByNameFunction());
        System.out.println("DANH SACH DA SAP XEP");
        for (Student stu : listStudents) {
            System.out.println(stu);
        }
    }

    public void sortStudetnByIdFAP() {
        listStudents.sort(listStudents.sortStudentById());
        System.out.println("DANH SACH DA SAP XEP");
        for (Student stu : listStudents) {
            System.out.println(stu);
        }
    }

    /*ham nay enroll student bat ki vao course
    - tim student dua vao id
    - tim course dua vao code
    - neu tim thay sv, course thi enroll sv tim duoc vao course
     */
    public void printEnrollInformation() {
        Scanner sc = new Scanner(System.in);
        printStudent();
        System.out.print("Enter student id: ");
        int id = sc.nextInt();
        sc.nextLine();
        Student findStudent = listStudents.findStudentById(id);
        if (findStudent != null) {
            printCourse();
            System.out.print("Enter code: ");
            String code = sc.nextLine();
            Course findCourse = listCourse.findCode(code);

            if (findCourse != null) {
                if(findCourse.enrolledStudent(findStudent)) {
                    System.out.println("Enrolled!!!");
                    findCourse.displayCourse();
                } else {
                    System.out.println("Student already exist");
                }
            } else {
                System.out.println("Course with code: " + code + " not found");
            }
        } else {
            System.out.println("student with id: " + id + " not found");
        }

    }

}
