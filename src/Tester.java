import java.util.Scanner;


public class Tester {
    public static void main(String[] args) {
        FAP system = new FAP();
        int choice = 0;
        do {
            System.out.println("1. Add student from keyboard");
            System.out.println("2. Print student from keyboard");
            System.out.println("3. Find student by id");
            System.out.println("4. Find student by name");
            System.out.println("5. Update (name, major) by id");
            System.out.println("6. Remove student by id");
            System.out.println("7. Display student by major");
            System.out.println("8. Sort student by (id, name): ");
            System.out.println("------------------------------");
            System.out.println("9. Enroll course");
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
                    break;
                case 9:
                    system.displayEnrroledStudent();
                    break;
            }
        }while(choice <= 9);
    }
}
