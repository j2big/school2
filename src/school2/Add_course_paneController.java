/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class Add_course_paneController implements Initializable {

    @FXML
    private TextField course_title_text;
    @FXML
    private TextField course_code_text;
    @FXML
    private TextField course_unit_text;
    @FXML
    private ChoiceBox<String> course_type_choice;
    @FXML
    private TextField course_lecturer_text;
    @FXML
    private Button add_course_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void addCourseButtonClick(MouseEvent event) {
        AddCourseDBHandler addc = new AddCourseDBHandler(getCourseTitle(), getCourseCode(), getCourseUnit(), getCourseType(), getCourseLecturer());
    }

    public String getCourseTitle() {
        return course_title_text.getText();
    }

    public String getCourseCode() {
        return course_code_text.getText();
    }

    public String getCourseUnit() {
        return course_unit_text.getText();
    }

    public String getCourseLecturer() {
        return course_lecturer_text.getText();
    }

    public String getCourseType() {
        String x = null;
        switch (course_type_choice.getValue()) {
            case "Elective":
                x = "Elective";
                break;
            case "Compulsory":
                x = "Compulsory";
                break;
        }
        return x;
    }
}
