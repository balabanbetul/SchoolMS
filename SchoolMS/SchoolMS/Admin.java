package SchoolMS;

import java.io.IOException;
import java.util.Scanner;

import static SchoolMS.Main.*;
import static SchoolMS.myStudent.*;
// asödjföadkjfaösdkfjaöldkfjf

public class Admin extends Teacher {
    Scanner scanner = new Scanner(System.in);
    String userName;

    public void Student() throws IOException {
        System.out.println("Please enter the name of Student:");
        userName = scanner.nextLine();
        studentList.putIfAbsent(userName, new Student(userName));

        System.out.println("Do you want save the file? 1.Yes 2.No");
        if (scanner.nextLine().equals("1")) {
            log.saveStudent();

        }
    }

    public void teacher() throws IOException {
        System.out.println("Please enter the name of Teacher:");
        userName = scanner.nextLine();
        teacherList.putIfAbsent(userName, new Teacher(userName));

        System.out.println("Do you want save the file? 1.Yes 2.No");
        if (scanner.nextLine().equals("1")) {
            teacherLog.saveTeacher();
        }

    }
}
