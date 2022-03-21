package SchoolMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static SchoolMS.myStudent.*;

class UserLogin implements ActionListener, Runnable {

    private static JLabel userLabel;
    private static JLabel passLabel;
    private static JLabel success, warning;
    private static JFrame frame;
    private static JPanel panel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private HashMap<String, Student> guiList;


    @Override
    public void actionPerformed(ActionEvent e) {

        String user = userText.getText();
        String password = passwordText.getText();
        //System.out.println(user + ", " + password);
        System.out.println();
        checkList(user, password);
    }



    void checkList(String user, String password) {

        if (studentList.containsKey(user) && passwordCheck(user, password)) {
            timeDelaySeconds(1);
            frame.dispose();
            new Menu(user);
            //myStudent.run(user, password);
        } else {

            warning.setBounds(140, 110, 300, 25);
            warning.setText("Wrong input! Please try again!");
            passwordText.setText("");
            timeDelaySeconds(1);
        }
    }

    boolean passwordCheck(String user, String password) {
        String password1 = myStudent.studentList.get(user).password;
        if (password1.isEmpty()) {
            System.out.println("Please create a password:");
            password1 = scanner.nextLine();
            myStudent.studentList.get(user).password = password1;
            System.out.println("Password is created!");
            run();
            return false;
        } else return password1.equals(password);
    }

    void timeDelaySeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ignored) {
        }
    }

    void timeDelayMilliSeconds(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException ignored) {
        }
    }

    @Override
    public void run() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setTitle("Login!");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel.setLayout(null);

        //User
        userLabel = new JLabel("User : ");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        //Password
        passLabel = new JLabel("Password :");
        passLabel.setBounds(10, 50, 80, 25);
        panel.add(passLabel);

        //Password field
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        //Login button
        button = new JButton("Login");
        button.setBounds(184, 80, 80, 25);
        button.addActionListener(new UserLogin());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(184, 110, 300, 25);
        panel.add(success);

        warning = new JLabel("");
        panel.add(warning);

        frame.add(panel);
        frame.setVisible(true);

    }
}

public class Menu implements ActionListener {

    JFrame frame;
    JPanel panel;
    JButton profile, lecturePlan, grades, exit;
    JTextPane textPane;
    JLabel imageLabel;
    String user;

    public Menu(String user) {
        this.user = user;
        panel = new JPanel();
        frame = new JFrame();
        Font myFont = new Font("verdana", Font.PLAIN, 15);
        frame.setTitle("Menu " + this.user);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        {
            panel.setLayout(null);

            profile = new JButton("Profile");
            profile.setBounds(10, 10, 100, 40);
            profile.addActionListener(this);
            profile.setFocusable(false);
            panel.add(profile);

            lecturePlan = new JButton("Lecture Plan");
            lecturePlan.setBounds(120, 10, 150, 40);
            lecturePlan.addActionListener(this);
            lecturePlan.setFocusable(false);
            panel.add(lecturePlan);

            grades = new JButton("Grades");
            grades.setBounds(280, 10, 100, 40);
            grades.addActionListener(this);
            grades.setFocusable(false);
            panel.add(grades);

            exit = new JButton("Exit");
            exit.setBounds(390, 10, 80, 40);
            exit.addActionListener(this);
            exit.setFocusable(false);
            panel.add(exit);

            textPane = new JTextPane();
            textPane.setBounds(10, 60, 465, 390);

            textPane.setEditable(false);
            textPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            textPane.setFont(myFont);
            panel.add(textPane);

        }

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profile) {
            String text = "" +
                    "First name: " + studentList.get(this.user).firstName + "\n" +
                    "Family name: " + studentList.get(this.user).familyName + "\n" +
                    "Date of Birth: " + studentList.get(this.user).dateOfBirth + "\n" +
                    "Age: " + studentList.get(this.user).age + "\n" +
                    "School number: " + studentList.get(this.user).schoolNumber + "\n" +
                    "Class Teacher: " + studentList.get(this.user).classTeacher + "\n" +
                    "Home Address: " + studentList.get(this.user).homeAddress + "\n" +
                    "School fee: " + studentList.get(this.user).schoolFee + "\n";
            String stars = "NumberOfStars: " + studentList.get(this.user).numberOfStar + "\n";
            textPane.setText(text);


        }
        if (e.getSource() == lecturePlan) {
            textPane.setText("");

        }
        if (e.getSource() == grades) {
            textPane.setText("");

        }
        if (e.getSource() == exit) {
            textPane.setText("");
            frame.dispose();

        }
    }
}
