
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Huynh Khoa
 */
public class CourseList extends ArrayList<Course>{
    public void displayAll() {
        for (Course cs : this) {
            cs.displayCourse();
        }
    }    
    public Course findCode(String code) {
        for (Course cs : this) {
            if(cs.getCode().equals(code)) {
                return cs;
            }
        }
        return null;
    }   
}
