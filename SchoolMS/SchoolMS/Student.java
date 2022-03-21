package SchoolMS;

import java.util.HashMap;
import java.util.Scanner;

public class Student {
    HashMap<String, Integer> grades = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    String userName, password = "";
    String firstName, familyName;
    String gender,age, schoolNumber;
    String dateOfBirth, homeAddress;
    String classTeacher;
    boolean schoolFee;
    String numberOfStar;

    String mathematics = null, physic = null, biology = null, chemistry= null, english = null;

    Student(){}

    // ADMIN
    Student(String userName){
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
       //System.out.println("School Number : ");
       //this.schoolNumber = scanner.nextLine();
       //System.out.println("Class Teacher : ");

       //this.classTeacher = scanner.nextLine();
       //this.numberOfStar = 5;
       //System.out.println("Is School fee payed by parents?");
       //schoolFee = scanner.nextBoolean();
       //scanner.nextLine();

        run();

    }


    // STUDENT
    void infoStudent(String userName, String password){

        run();
    }

    void run(){
        boolean running=true;
        while (running){
            System.out.println(this.userName.toUpperCase());
            System.out.println("1. Profile\n2. Lecture Plan\n3. Grades\n4. Exit");
            switch (scanner.nextLine()){
                case "1":
                    profile();
                    break;
                case "2":
                    lecturePlan();
                    break;
                case "3":
                    showGrades();
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

    void profile(){
        System.out.println(userName.toUpperCase());
        System.out.println("Gender : " + gender);
        System.out.println("Age : "+ age);
        System.out.println("Birth date: " + dateOfBirth);
        System.out.println("SchoolNumber = " + schoolNumber);
        System.out.println("Home address: " + homeAddress);
        System.out.println("Class Teacher: " + classTeacher);
        System.out.println("Discipline points: " + numberOfStar);
        System.out.println("School fee: " + schoolFee);
    }

    void lecturePlan(){
        System.out.println("Monday    Tuesday    Wednesday    Thursday    Friday");
        System.out.println();


    }

    void showGrades(){
        System.out.println(this.mathematics);
        System.out.println(this.physic);
        System.out.println(this.biology);
        System.out.println(this.english);

    }

    protected void grades(String lecture){
        System.out.println();
        switch (lecture.toLowerCase()){
            case "mathematics":
                System.out.println("Please enter the note: ");
                this.mathematics = scanner.nextLine();
                System.out.println(this.userName + "Mathematics: " + mathematics);
                break;
            case "physic":
                System.out.println("Please enter the note: ");
                this.physic = scanner.nextLine();
                System.out.println(this.userName + "Physic: " + physic);
                break;
            case "biology":
                System.out.println("Please enter the note: ");
                this.biology = scanner.nextLine();
                System.out.println(this.userName + "Biology: " + biology);
                break;
            case "chemistry":
                System.out.println("Please enter the note: ");
                this.chemistry = scanner.nextLine();
                System.out.println(this.userName + "Chemistry: " + chemistry);
                break;
            case "english":
                System.out.println("Please enter the note: ");
                this.english = scanner.nextLine();
                System.out.println(this.userName + "English: " + english);
                break;
            default:
                System.out.println("Teacher branch is not on the list!");
        }
    }
}
