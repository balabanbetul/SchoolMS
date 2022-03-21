package SchoolMS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static SchoolMS.myStudent.studentList;

public class Teacher extends Student{
    Scanner scanner = new Scanner(System.in);
    String userName, password = "";
    String firstName, familyName;
    String gender, age;
    String dateOfBirth, homeAddress;
    String whichClassTeacher;
    String branch;
    String numberOfStar;

    Teacher(){}

    Teacher(String userName) throws IOException {
        this.userName = userName;
        this.firstName = userName.substring(0, userName.indexOf(" "));
        this.familyName = userName.substring(userName.indexOf(" "));
        //System.out.println("Gender: ");
        //this.gender = scanner.nextLine();
        //System.out.println("Age: ");
        //this.age = scanner.nextLine();
        //System.out.println("Date of Birth : ");
        //this.dateOfBirth = scanner.nextLine();
        //System.out.println("Home Address : ");
        //this.homeAddress = scanner.nextLine();
        //System.out.println("Which class : ");
        //this.whichClassTeacher= scanner.nextLine();
        //System.out.println("Branch : ");
        //this.branch= scanner.nextLine();
        //System.out.println("Number of stars: ");
        //this.numberOfStar = scanner.nextLine();
    }

    // TEACHER
    void infoTeacher(String userName/*, String password*/) {

        run();
    }

    void run() {
        boolean running = true;
        while (running) {
            System.out.println(this.userName.toUpperCase());
            System.out.println("1. Profile\n2. Lecture Plan\n3. Enter Grade\n4. Exit");
            switch (scanner.nextLine()) {
                case "1":
                    profile();
                    break;
                case "2":
                    lecturePlan();
                    break;
                case "3":
                    addGrade();
                    break;
                case "4":
                    System.out.println("exiting...");
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }


    void profile() {
        System.out.println(userName.toUpperCase());
        System.out.println("Gender : " + gender);
        System.out.println("Age : " + age);
        System.out.println("Birth date: " + dateOfBirth);
        System.out.println("Home address: " + homeAddress);
        System.out.println("Which class: " + whichClassTeacher);
        System.out.println("Branch: " + branch);
        System.out.println("Discipline points: " + numberOfStar);
        System.out.println();
    }

    void lecturePlan() {
        System.out.println("Monday    Tuesday    Wednesday    Thursday    Friday");
        System.out.println();


    }

    void addGrade(){
        ArrayList<Student> list = new ArrayList<>();
        for (String user : studentList.keySet()) {
            int count = Integer.parseInt(String.valueOf(studentList.get(user).schoolNumber.charAt(3)));
            list.add(count-1, studentList.get(user));
        }
        int count = 1;
        for (Student user: list){
            System.out.println(count++ + ". " + user.schoolNumber + " " + user.userName);
        }

        System.out.println("Choose a student?");
        String input = scanner.nextLine();
        for (int i = 1; i <= list.size(); i++){
            if (input.equals(String.valueOf(i))){
                studentList.get(list.get(i-1).userName).grades(this.branch);
            }
        }

            //grades(this.branch);

    }
}
























