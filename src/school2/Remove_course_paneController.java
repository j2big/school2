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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class Remove_course_paneController implements Initializable {
    @FXML
    private Button remove_course_button;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void removeCourseButtonClick(MouseEvent event) {
    }
    
}
