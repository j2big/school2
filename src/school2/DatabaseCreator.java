    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Joshua
 */
public class DatabaseCreator {

    Logger dbc = new Logger();
    Connection connection;
    Statement statement;

    public void create() throws Exception {
        File db = new File("database/school2.db");
        if (db.exists()) {
            dbc.log("Database Already Exists!!");
        } else {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            statement = connection.createStatement();

            //creating non-existing tables
            //creating course table
            statement.executeUpdate("create table course_table(course_title varchar(30),course_code varchar(5),course_unit integer(1),course_type varchar(5),course_lecturer varchar(30));");
            dbc.log("COURSE TABLE CREATED!!");
        }
    }

}
