package org.application.schooldiary.database.tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTable {
    private final  String DB_URL = "jdbc:mysql://localhost/SCHOOLDIARYDB?useSSL=false";
    private Statement statement;
    private Connection connection;

    public void createStudentTable(String username, String password) {

        try {
            connection = DriverManager.getConnection(DB_URL, username, password);
            statement = connection.createStatement();

            String sql = "CREATE TABLE STUDENT ("
                    + "ID INT(64) NOT NULL AUTO_INCREMENT,"
                    + "NAME VARCHAR(40) NOT NULL,"
                    + "USER_NAME VARCHAR(40) NOT NULL,"
                    + "PASSWORD VARCHAR(40) NOT NULL,"
                    + "EMAIL VARCHAR(40) NOT NULL,"
                    +  "PRIMARY KEY(ID))";

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
