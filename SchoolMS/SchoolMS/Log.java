package SchoolMS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Log extends myStudent {
    Log() throws FileNotFoundException {
        Scanner getStudent = new Scanner(new File("C:/Users/volka/IdeaProjects/Projects/src/SchoolMS/StudentLog.txt"));

        String userName;
        Student student = new Student();
        while (getStudent.hasNextLine()) {
            String text = getStudent.nextLine();
            String value;
            value = text.substring(text.indexOf(" ") + 1);
            if (text.contains("userName:")) {
                userName = text.substring(text.indexOf(" ") + 1);
                studentList.put(userName, new Student());
                student = studentList.get(userName);
                student.userName = userName;
                student.firstName = userName.substring(0, userName.indexOf(" "));
                student.familyName = userName.substring(userName.indexOf(" "));

            }
            else if (text.contains("password")) student.password = value;
            else if (text.contains("gender")) student.gender = value;
            else if (text.contains("age")) student.age = value;
            else if (text.contains("birthdate")) student.dateOfBirth = value;
            else if (text.contains("homeAddress")) student.homeAddress = value;
            else if (text.contains("schoolNumber")) student.schoolNumber = value;
            else if (text.contains("classTeacher")) student.classTeacher = value;
            else if (text.contains("NumberOfStars")) student.numberOfStar = value;
            else if (text.contains("schoolfee")) student.schoolFee = "true".equals(value);
            else if (text.contains("Mathematics:")) student.mathematics = value;
            else if (text.contains("Physic:")) student.physic = value;
            else if (text.contains("Biology:")) student.biology = value;
            else if (text.contains("Chemistry:")) student.chemistry = value;
            else if (text.contains("English:")) student.english = value;

        }
        //for (String user : studentList.keySet()) {
        //    System.out.println(user);
        //}
    }

    void saveStudent() throws IOException {


        String infoStudent = "";
        for (String userName : studentList.keySet()) {
            Student student = studentList.get(userName);
            infoStudent = infoStudent.concat("" + "userName: " + student.userName + "\n" + "password: " + student.password + "\n" + "gender: " + student.gender + "\n" + "age: " + student.age + "\n" + "birthdate: " + student.dateOfBirth + "\n" + "homeAddress: " + student.homeAddress + "\n" + "schoolNumber: " + student.schoolNumber + "\n" + "classTeacher: " + student.classTeacher + "\n" + "NumberOfStars: " + student.numberOfStar + "\n" + "schoolfee: " + student.schoolFee + "\n" + "\n" + "Mathematics: " + student.mathematics + "\n" + "Physic: " + student.physic + "\n" + "Biology: " + student.biology + "\n" + "Chemistry: " + student.chemistry + "\n" + "English: " + student.english + "\n" + "-------------------------\n\n");
        }
        FileWriter studentWrite = new FileWriter("C:/Users/volka/IdeaProjects/Projects/src/SchoolMS/StudentLog.txt");
        studentWrite.write(infoStudent);
        studentWrite.close();
    }

    void eraseStudent() throws IOException {
        System.out.println("Which student do you want to erase from log?");
        String studentName = scanner.nextLine();

        if (studentList.containsKey(studentName)) {
            studentList.remove(studentName);
        } else {
            System.out.println("Student couldn't find!");
            System.out.println("1. Try again 2. Cancel");
            if (scanner.nextLine().equals("1")) {
                eraseStudent();
            }
        }
        saveStudent();
    }
}

class TeacherLog extends myStudent {
    TeacherLog() throws FileNotFoundException {
        Scanner getTeacher = new Scanner(new File("C:/Users/volka/IdeaProjects/Projects/src/SchoolMS/TeacherLog.txt"));

        String userName = "";
        while (getTeacher.hasNextLine()) {
            String text = getTeacher.nextLine();
            if (text.contains("userName:")) {
                userName = text.substring(text.indexOf(" ") + 1);
                teacherList.put(userName, new Teacher());
                teacherList.get(userName).userName = userName;
                teacherList.get(userName).firstName = userName.substring(0, userName.indexOf(" "));
                teacherList.get(userName).familyName = userName.substring(userName.indexOf(" "));

            } else if (text.contains("password"))
                teacherList.get(userName).password = text.substring(text.indexOf(" ") + 1);
            else if (text.contains("gender")) teacherList.get(userName).gender = text.substring(text.indexOf(" ") + 1);
            else if (text.contains("age")) teacherList.get(userName).age = text.substring(text.indexOf(" ") + 1);
            else if (text.contains("birthdate"))
                teacherList.get(userName).dateOfBirth = text.substring(text.indexOf(" ") + 1);
            else if (text.contains("homeAddress"))
                teacherList.get(userName).homeAddress = text.substring(text.indexOf(" ") + 1);
            else if (text.contains("Which_class:"))
                teacherList.get(userName).whichClassTeacher = text.substring(text.indexOf(" ") + 1);
            else if (text.contains("Branch")) teacherList.get(userName).branch = text.substring(text.indexOf(" ") + 1);
            else if (text.contains("NumberOfStars"))
                teacherList.get(userName).numberOfStar = text.substring(text.indexOf(" ") + 1);
        }
        for (String user : teacherList.keySet()) {
            System.out.println(user);
        }
    }

    void saveTeacher() {
        try {
            String infoTeacher = "";
            for (String userName : teacherList.keySet()) {
                infoTeacher = infoTeacher.concat("" + "userName: " + teacherList.get(userName).userName + "\n" + "password: " + teacherList.get(userName).password + "\n" + "gender: " + teacherList.get(userName).gender + "\n" + "age: " + teacherList.get(userName).age + "\n" + "birthdate: " + teacherList.get(userName).dateOfBirth + "\n" + "homeAddress: " + teacherList.get(userName).homeAddress + "\n" + "Which_class: " + teacherList.get(userName).whichClassTeacher + "\n" + "Branch: " + teacherList.get(userName).branch + "\n" + "NumberOfStars: " + teacherList.get(userName).numberOfStar + "\n" +

                        "\n" + "-------------------------\n\n");
            }
            FileWriter teacherWrite = new FileWriter("C:/Users/volka/IdeaProjects/Projects/src/SchoolMS/TeacherLog.txt");
            teacherWrite.write(infoTeacher);
            teacherWrite.close();
        } catch (IOException ignored) {
        }
    }

    void eraseTeacher() throws IOException {
        System.out.println("Which student do you want to erase from log?");
        String teacherName = scanner.nextLine();

        if (studentList.containsKey(teacherName)) {
            studentList.remove(teacherName);
        } else {
            System.out.println("Teacher couldn't find!");
            System.out.println("1. Try again 2. Cancel");
            if (scanner.nextLine().equals("1")) {
                eraseTeacher();
            }
        }
        saveTeacher();
    }
}