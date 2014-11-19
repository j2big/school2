/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
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

    private String ctitle, ccode, cunit, ctype, clecturer;
    private Connection connection;
    private Statement statement;

    private ObservableList<String> coursesOList;
    private ArrayList<String> courseAList = new ArrayList<String>();

    /*
    
     * Initializes the controller class.
     */
    Logger rcp = new Logger();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rcp.log("inside Initialize method ");
        coursesOList = FXCollections.observableList(rcdb.getCourseTitles());
        coursesList.setItems(coursesOList);
    }

    @FXML
    private void removeCourseButtonClick(MouseEvent event) {
    }
}
