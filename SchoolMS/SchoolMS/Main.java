package SchoolMS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends myStudent{

    static Log log;
    static TeacherLog teacherLog;
    static Library library;
    static Admin admin;
    static Teacher teacher;

    public static void main(String[] args) throws IOException, InterruptedException {

        Thread userLogin = new Thread(new UserLogin());
        userLogin.start();
        log = new Log();
        teacherLog = new TeacherLog();
        library = new Library();

        teacherList.get("Nurdan Töre").infoTeacher("Nurdan Töre");
        log.saveStudent();


        //library.showBookList();
        //library.getDeleteBook();
        //library.getAddBook();
        //new Admin().Student();
        //log.eraseStudent();
        //userLogin.start();



    }
}

class myStudent {
    static HashMap<String, Student> studentList = new HashMap<>();
    static HashMap<String, Teacher> teacherList = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    static void run(String userName, String password) {

        studentList.get(userName).infoStudent(userName, password);

    }

}

// Homework Document
//Student info system