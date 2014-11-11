/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Joshua
 */
public class AddCourseDBHandler {

    Logger ac = new Logger();

    private String ctitle, ccode, cunit, ctype, clecturer;
    private Connection connection;
    private PreparedStatement preparedStatement;

    public AddCourseDBHandler(String c_title, String c_code, String c_unit, String c_type, String c_lecturer) {
        ac.log("Database entered");
        ctitle = c_title;
        ccode = c_code;
        cunit = c_unit;
        ctype = c_type;
        clecturer = c_lecturer;
        try {
            connectDb();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void connectDb() throws Exception {
        ac.log("Connecting to Database");
        String sql = "insert into course_table values(?,?,?,?,?);";

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, ctitle);
        preparedStatement.setString(2, ccode);
        preparedStatement.setString(3, cunit);
        preparedStatement.setString(4, ctype);
        preparedStatement.setString(5, clecturer);

        preparedStatement.executeUpdate();
        ac.log("Course: " + ctitle + " added");

        connection.close();

    }

}
