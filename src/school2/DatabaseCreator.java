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

    Connection connection;
    Statement statement;

    public void create() throws Exception {

        File db = new File("database/school2.db");
        if (db.exists()) {

        } else {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            statement = connection.createStatement();

            //creating non-existing tables
            //creating course table
            statement.executeUpdate("create table course_table(course_title varchar(30),course_code varchar(5),course_unit integer(1),course_type varchar(5),course_lecturer varchar(30));");

            /* creating logo table       tis data base might be synced from the server and not necessarily be in the app
             statement.executeUpdate("create table logo_table(logo_id varchar(3),logo_school_name varchar(60),logo_file_path varchar(50), logo_site_url varchar(50));");
             */
        }
    }

}
