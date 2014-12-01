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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class Edit_course_paneController implements Initializable {

    private String ctitle, ccode, ctype, clecturer, cunitS;
    private int cunit;
    @FXML
    private ListView<String> coursesList;
    @FXML
    private Button edit_course_button;
    @FXML
    private TextField course_title_edit;
    @FXML
    private TextField course_code_edit;
    @FXML
    private TextField course_unit_edit;
    @FXML
    private TextField course_type_edit;
    @FXML
    private TextField course_lecturer_edit;
    public String selectedTitle;

    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private Statement statement;

    EditCourseDBHandler edb = new EditCourseDBHandler();
    private ObservableList<String> coursesOList;
    private ArrayList<String> courseAList = new ArrayList<String>();

    @FXML
    private Button save_course_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        save_course_button.setDisable(true);
        loadList();
        getSelectedItem();
    }

    public void loadList() {

        coursesOList = FXCollections.observableList(edb.getCourseTitles());
        coursesList.setItems(coursesOList);
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

    @FXML
    private void editCourseButtonClick(MouseEvent event) {
        edit_course_button.setDisable(true);
        save_course_button.setDisable(false);

        setEnabled();
    }

    public void setEnabled() {
        course_title_edit.setEditable(false);
        course_code_edit.setEditable(true);
        course_unit_edit.setEditable(true);
        course_type_edit.setEditable(true);
        course_lecturer_edit.setEditable(true);
    }

    public void setDisabled() {
        course_title_edit.setEditable(false);
        course_code_edit.setEditable(false);
        course_unit_edit.setEditable(false);
        course_type_edit.setEditable(false);
        course_lecturer_edit.setEditable(false);
    }

    public void setTexts() {

        cunitS = "" + cunit;

        course_title_edit.setText(ctitle);
        course_code_edit.setText(ccode);
        course_unit_edit.setText(cunitS);
        course_type_edit.setText(ctype);
        course_lecturer_edit.setText(clecturer);
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

    public String getCourseUnit() {
        return course_unit_edit.getText();
    }

    public String getCourseTitle() {
        return course_title_edit.getText();
    }

    public String getCourseCode() {
        return course_code_edit.getText();
    }

    public String getCourseType() {
        return course_type_edit.getText();
    }

    public String getCourseLecturer() {
        return course_lecturer_edit.getText();
    }

    @FXML
    private void savebuttonClick(MouseEvent event) {
        save_course_button.setDisable(true);
        edit_course_button.setDisable(false);
        setDisabled();

        updateDatabase(getCourseTitle(), getCourseCode(), getCourseUnit(), getCourseType(), getCourseLecturer());
    }

    public void updateDatabase(String c_title, String c_code, String c_unit, String c_type, String c_lecturer) {
        String updatesql = "update course_table set course_unit='" + c_unit + "',course_code='" + c_code + "',course_type='" + c_type + "',course_lecturer='" + c_lecturer + "' where course_title='" + c_title + "'";

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            preparedStatement = connection.prepareStatement(updatesql);
            preparedStatement.executeUpdate();

            connection.close();
            preparedStatement.close();
        } catch (Exception updateEditError) {
            updateEditError.printStackTrace();
        }

    }

}
