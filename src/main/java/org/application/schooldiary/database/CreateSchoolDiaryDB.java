package org.application.schooldiary.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.sql.*;

public class CreateSchoolDiaryDB {
    // JDBC driver name and database URL
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    private static final String DBName = "SCHOOLDIARYDB";
    private static final String USER = "admin";
    private static final String PASS = "admin";


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement= null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            connection= DriverManager.getConnection(DB_URL, USER, PASS);

            if(checkDBExixt(connection) == false) {
                //Execute a query
                System.out.println("Creating database...");
                statement = connection.createStatement();

                String sql = "CREATE DATABASE IF NOT EXISTS SCHOOLDIARYDB";
                statement.executeUpdate(sql);
                System.out.println("Database created successfully...");
            }
            else {
                System.out.println("Database already exist");
            }

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //Close resources
            try{
                if(statement != null)
                    statement.close();
            }catch(SQLException se2){ }
            try{
                if(connection != null)
                    connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public static boolean checkDBExixt(Connection connection) {
        boolean flag = false;

        try {
            ResultSet resultSet =  connection.getMetaData().getCatalogs();

            while(resultSet.next()) {
                String database = resultSet.getString(1);
                if(database.equalsIgnoreCase(DBName)) {
                    flag = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(flag);
        return flag;
    }
}
