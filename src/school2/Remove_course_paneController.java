/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class Remove_course_paneController implements Initializable {

    RemoveCourseDBHandler rcdb = new RemoveCourseDBHandler();

    private String ctitle, ccode, ctype, clecturer, cunitS;
    private int cunit;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private Statement statement;

    private ObservableList<String> coursesOList;
    private ArrayList<String> courseAList = new ArrayList<String>();

    /*
    
     * Initializes the controller class.
     */
    @FXML
    private ListView<String> coursesList;
    @FXML
    private Label course_title_label;
    @FXML
    private Label course_code_label;
    @FXML
    private Label course_unit_label;
    @FXML
    private Label course_type_label;
    @FXML
    private Label course_lecturer_label;
    @FXML
    private Button remove_course_button;
    public String selectedTitle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loadList();
        getSelectedItem();

    }

    @FXML
    private void removeCourseButtonClick(MouseEvent event) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            preparedStatement = connection.prepareStatement("delete from course_table where course_title = '" + selectedTitle + "';");
            preparedStatement.executeUpdate();

            connection.close();

        } catch (Exception updateEditError) {
            updateEditError.printStackTrace();
        }

    }

    public void loadList() {

        coursesOList = FXCollections.observableList(rcdb.getCourseTitles());
        coursesList.setItems(coursesOList);
    }

    public void refreshList() {
        coursesList.getItems().clear();
        loadList();
    }

    public void getSelectedItem() {
        coursesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                selectedTitle = newValue;

                getSelectedFromDB(selectedTitle);
                setTexts();
            }
        });
    }

    public void setTexts() {
        cunitS = "" + cunit;

        course_title_label.setText(ctitle);
        course_code_label.setText(ccode);
        course_unit_label.setText(cunitS);
        course_type_label.setText(ctype);
        course_lecturer_label.setText(clecturer);
    }

    public void getSelectedFromDB(String courseTitle) {

        String sql = "select * from course_table where course_title = '" + courseTitle + "';";

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            //preparedStatement = connection.prepareStatement(sql);

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ctitle = resultSet.getString("course_title");
                ccode = resultSet.getString("course_code");
                cunit = resultSet.getInt("course_unit");
                ctype = resultSet.getString("course_type");
                clecturer = resultSet.getString("course_lecturer");
            }

        } catch (Exception editCourseLoadError) {
            editCourseLoadError.printStackTrace();
        } finally {
            try {
                connection.close();
                resultSet.close();
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }

    }

}
