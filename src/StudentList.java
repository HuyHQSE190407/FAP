
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class StudentList extends ArrayList<Student> {

    public void displayAll() {
        //way 1
//        for (int i = 0; i < this.size(); i++) {
//            Student s = this.get(i);
//            System.out.println(s.toString());
//        }
        //way 2
//        for (Student s : this) {
//            System.out.println(s.toString());
//        }
        //way 3
        Iterator<Student> it = this.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s);
        }
    }

    public Student findStudentById(int id) {
        for (Student s : this) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : this) {
            if (s.getName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }

    public Student updateStudentById(int id, String name, String major) {
        for (Student stu : this) {
            if (stu.getId() == id) {
                stu.setName(name);
                stu.setMajor(major);
            }
        }
        return null;
    }

    public ArrayList<Student> displayStudentByMajor(String major) {
        ArrayList<Student> rs = new ArrayList<>();
        for (Student stu : this) {
            if (stu.getMajor().equalsIgnoreCase(major)) {
                rs.add(stu);
            }
        }
        return rs;
    }

    public Comparator<Student> sortStudentByNameFunction() {
        return (Student o1, Student o2) -> {
            String[] nameParts1 = o1.getName().trim().split("\\s+");
            String[] nameParts2 = o2.getName().trim().split("\\s+");

            String lastName1 = nameParts1[nameParts1.length - 1];
            String lastName2 = nameParts2[nameParts2.length - 1];

            int result = lastName1.compareToIgnoreCase(lastName2);
            if (result == 0) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
            return result;
        };
    }

    public Comparator<Student> sortStudentById() {
        return (s1, s2) -> Integer.compare(s1.getId(), s2.getId());
    }
}
