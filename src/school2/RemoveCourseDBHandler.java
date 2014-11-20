/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jafolabi
 */
public class RemoveCourseDBHandler {

    private String ctitle, ccode, cunit, ctype, clecturer;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    String sql = "";
    ArrayList<String> coursesList = new ArrayList();
   

    /* public RemoveCourseDBHandler(String c_title, String c_code, String c_unit, String c_type, String c_lecturer) {
     rc.log("Database entered");
     ctitle = c_title;
     ccode = c_code;
     cunit = c_unit;
     ctype = c_type;
     clecturer = c_lecturer;
     }*/
    public ArrayList<String> getCourseTitles() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            preparedStatement = connection.prepareStatement(sql);

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select course_title from course_table ");

            while (resultSet.next()) {
                ctitle = resultSet.getString("course_title");
                coursesList.add(ctitle);
            }

        } catch (Exception er) {
            er.printStackTrace();
        } finally {
            try {
                connection.close();
                resultSet.close();
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }

        return getCourseList();

    }

    public ArrayList<String> getCourseList() {
        return coursesList;
    }

}
