/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import static javafx.beans.binding.Bindings.select;

/**
 *
 * @author bozhidar
 */
public class user {

    private static int user_ID;
    private static String username;
    private static String  password;
    private static double balance;
    private static final String USERNAME = "b4a0b236938a80";
    private static final String PASSWORD = "f0e9b6fd";
    private static final String str = "jdbc:mysql://eu-cdbr-azure-north-d.cloudapp.net:3306/b.tashev?zeroDateTimeBehavior=convertToNull";
    private static Statement stmt = null;
    private static Connection conn = null;
    //private static final String query = "SELECT * FROM user";
    private static String query;    

    public user() {
        
        //this.user_ID = user_ID;
        //this.username = username;
        //this.password = password;
        //this.balance = balance;

    }

    public static void makeConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(str,USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ARRR");
        }
    }
    public static void getAllUsersDetails() throws SQLException{
        System.out.println("Getting all users....");
        //String getAllUser = "SELECT * FROM user";
        conn = DriverManager.getConnection(str,USERNAME, PASSWORD);
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(user.query);
            while(rs.next()){
                user_ID = rs.getInt("user_ID");
                username = rs.getString("username");
                password = rs.getString("password");
                balance = rs.getDouble("balance");
                System.out.println("USername is "+username);
                System.out.println("User password is "+password);
                System.out.println("User balance is "+balance);
            }
            
        }catch (Exception e){
                e.printStackTrace();
                System.out.println("ARRR");
            } finally {
        if (stmt != null) { stmt.close(); }
    
            
        }
    }
    public int getUser_ID() {
        return user_ID;
    }

    public static String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static double getBalance() {
        return balance;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void removeBalance(double balance) {
        this.balance -= balance;
    }
    
    public static String getConnectionUsername(){
        return USERNAME;
    }
    
    public static String getConnectionPassword(){
        return PASSWORD;
    }
    
    public static String getConnectionURL(){
        return str;
    }

    public  String validateUSer(String username1, String password1) throws SQLException {
        this.query = "SELECT * FROM user where username = 'name1' AND password = 'password1'";
        user.getAllUsersDetails();
       // if (this.username.matches(username1) & this.password.matches(password1)) {
       if (this.username.compareTo(username1) == 0 && this.password.compareTo(password1) == 0) {
            System.out.println("User validated");            
            return "User validated";
//        } else if (this.user_ID != userID) {
//            System.out.println("user id doesnt exist");
//            return false;
        } else if (this.username.compareTo(username1) !=0) {
            System.out.println("Username invalid");
             return "Username invalid";
        } else if (this.password.compareTo(password1) != 0) {
            System.out.println("Invalid password");
            return "Invalid password";
        } else {
            System.out.println("OMG SOMETHINGS IS REALLY WRONG");
            return "OMG SOMETHINGS IS REALLY WRONG";
        }        
    }

}
