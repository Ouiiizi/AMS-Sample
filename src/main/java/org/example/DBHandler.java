package org.example;

import org.example.models.modelClass;
import org.example.models.modelUsers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DBHandler {
    //TABLENAMES
    public static final String TABLE_CLASS = "class";
    public static final String TABLE_USERS = "users";
    public static final String TABLE_ATTENDANCE = "attendance";

    //COLUMNNAMES
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_CLASSNAME = "classname";
    public static final String COLUMN_STUDENTCOUNT = "studentcount";
    public static final String COLUMN_classid = "classid";
    public static final String COLUMN_userid = "userid";
    public static final String COLUMN_PRESENTALL = "presentall";
    public static final String COLUMN_PASSWORD = "password";


    public static Connection connect() {
        Connection connect = null;
        String url = "jdbc:sqlite:src/main/resources/database/AMS.db";
        try {
            connect = DriverManager.getConnection(url);
            System.out.println("Connection done");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }
    //connection


    public List<modelUsers> getAllUsers(Connection connection, String username) {
        String query = "SELECT * FROM" + TABLE_USERS + "WHERE" + COLUMN_USERNAME + "=" + username;
        List<modelUsers> modelUsers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt(COLUMN_ID);
                username = resultSet.getString(COLUMN_USERNAME);
                String password = resultSet.getString(COLUMN_PASSWORD);


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return modelUsers;
    }

    public List<modelClass> getAllClasses(Connection connection, String classname) {
        String query = "SELECT * FROM" + TABLE_CLASS + "WHERE" + COLUMN_CLASSNAME + "=" + classname;
        List<modelClass> modelClass = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(COLUMN_ID);
                classname = resultSet.getString(COLUMN_CLASSNAME);
                String password = resultSet.getString(COLUMN_PASSWORD);


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return modelClass;
    }

//    public static void addAttendanceInfo(modelAttendance modelattendance , Connection connection){
//        String sql = "INSERT INTO" + TABLE_ATTENDANCE + "(" + COLUMN_classid + "," + COLUMN_userid + "," + COLUMN_PRESENTALL + ")" + "VALUES(?,?,?)";
//    try{
//        PreparedStatement pstmnt = connection.prepareStatement(sql);
//
//        pstmnt.setInt(1,modelattendance.getClassid());
//        pstmnt.setInt(2,modelattendance.getUserid());
//        pstmnt.setInt(3,modelattendance.getPresentall());
//        pstmnt.executeUpdate();
//
//        pstmnt.close();
//    }
//    catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//    }
//         public List<modelAttendance> getAllAttendancez(Connection connection, int classid, int userid , int presentall) {
//            String query = "SELECT * FROM" + TABLE_ATTENDANCE + "WHERE" + COLUMN_classid + "=" + classid;
//            String query2 = "SELECT * FROM" + TABLE_ATTENDANCE + "WHERE" + COLUMN_userid + "=" + userid;
//            String query3 = "SELECT * FROM" + TABLE_ATTENDANCE + "WHERE" + COLUMN_PRESENTALL + "=" + presentall;
//
//            List<modelAttendance> modelAttendances = new ArrayList<>();
//            try {
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//                ResultSet resultSet2 = statement.executeQuery(query2);
//                ResultSet resultSet3 = statement.executeQuery(query3);
//
//                while(resultSet.next()){
//                    int id = resultSet.getInt(COLUMN_ID);
//                    classid = resultSet.getInt(COLUMN_classid);
//                    userid = resultSet2.getInt(COLUMN_userid);
//                    presentall = resultSet3.getInt(COLUMN_PRESENTALL);
//
//
//                }
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//            return modelAttendances;
//
//        }
public static void addAttendanceInfo(int classid, int userid, int presentAll) {
    String query = "INSERT INTO attendance (classid, userid, presentall) VALUES (?, ?, ?)";
    try (Connection connection = connect();
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, classid);
        statement.setInt(2, userid);
        statement.setInt(3, presentAll);
        statement.executeUpdate();
        System.out.println("Attendance info added successfully");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    public static void addClassInfo(String classname, int studentcount) {
        String query = "INSERT INTO class(classname, studentcount) VALUES (?, ?)";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, classname);
            statement.setInt(2, studentcount);
            statement.executeUpdate();
            System.out.println("Class info added successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void addUserInfo(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
            System.out.println("Userinfo added successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}

