package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Connection connection = DBHandler.connect();

        int classid;
        int userid;
        int presentall;

        String classname;
        int studentcount;

        String username;
        String password;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Info do you want to add? ( 1 for attendanceinfo, 2 for classinfo , 3 for userinfo");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter classid");
            classid = scanner.nextInt();
            System.out.println("Enter userid");
            userid = scanner.nextInt();
            System.out.println("Are all present (0 for no / 1 for Yes");
            presentall = scanner.nextInt();

            DBHandler.addAttendanceInfo(classid, userid, presentall);
        } else if(choice == 2) {
            System.out.println("Enter Classname");
            classname = scanner.nextLine();
            System.out.println("Enter the Student count of the class");
            studentcount = scanner.nextInt();
            DBHandler.addClassInfo(classname,studentcount);
        } else if(choice == 3 ){
            System.out.println("Enter Username");
            username = scanner.nextLine();
            System.out.println("Enter password");
            password = scanner.nextLine();
            DBHandler.addUserInfo(username, password);

        } else{
            System.out.println("Chalena babu");
        }
    }
}

