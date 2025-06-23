import java.util.Scanner;


public class Tester {
    public static void main(String[] args) {
        FAP system = new FAP();
        int choice = 0;
        do {
            System.out.println("1. Add student from keyboard"); //done
            System.out.println("2. Print student from keyboard"); //done
            System.out.println("3. Find student by id"); //done
            System.out.println("4. Find student by name"); //done
            System.out.println("5. Update (name, major) by id"); //done
            System.out.println("6. Remove student by id"); //done
            System.out.println("7. Display student by major"); //done
            System.out.println("8. Sort student by (id, name): "); //done
            System.out.println("9. add course from keyboard");//done
            System.out.println("10. Print courses");//done
            System.out.println("11. Enroll Student to the course");//done
            System.out.println("12. In ra mon hoc co nhieu sv dk nhat");
            System.out.println("13. in ra sv dk nhieu mon hoc nhat");
            System.out.println("14. in ra tong so tin chi cua moi sv");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    system.addStudentFromKeyboard();
                    break;
                case 2:
                    system.printStudent();
                    break;
                case 3:
                    system.displayStudentById();
                    break;
                case 4:
                    system.displayStudentByName();
                    break;
                case 5:
                    system.updateStudentById();
                    break;
                case 6:
                    system.removeStudentById();
                    break;
                case 7:
                    system.displayStudentByMajor();
                    break;
                case 8:
                    System.out.println("Sort Student");
                    System.out.print("Enter choice(1. name, 2. id): ");
                    int choice_2 = sc.nextInt();
                    switch(choice_2) {
                        case 1:
                            system.sortStudentByName();
                            break;
                        case 2:
                            system.sortStudetnByIdFAP();
                            break;
                    }
                    break;
                case 9:
                    system.addCourseFromKeyboard();
                    break;
                case 10:
                    system.printCourse();
                    break;
                case 11:
                    system.printEnrollInformation();
                    break;
               
                    
            }
        }while(choice != 0);
    }
}
