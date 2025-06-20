
import java.util.ArrayList;


public class Course {
    private String code;
    private int credit;
    private ArrayList<Student> enrrolledStudent; //quan he has

    public Course() {
        code = "PRO192";
        credit = 3;
        enrrolledStudent = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public ArrayList<Student> getEnrrolledStudent() {
        return enrrolledStudent;
    }
    public void setErrolledStudent(ArrayList<Student> enrrolledStudent) {
        this.enrrolledStudent = enrrolledStudent;
    }
    
    public Student findStudentById(int id) {
        for (Student s : enrrolledStudent) {
            if(s.getId() == id) {
                return s;
            }
        }
        return null;
    }
       
    
    //ham nay de them 1 sinh vien vao course
    //student enroll vao course
    
    public boolean enrolledStudent(Student stu) {
        int id = stu.getId();
        Student rs = findStudentById(id);
        if(rs != null) {
           return false; 
        }
        
        enrrolledStudent.add(stu);
        return true;
    }
    
    public void displayCourse() {
        System.out.println("Code: " + code);
        System.out.println("----------DANH SACH SINH VIEN ENRROLLED----------");
        for (Student s : enrrolledStudent) {
            System.out.println(s);
        }
    }
    
}
