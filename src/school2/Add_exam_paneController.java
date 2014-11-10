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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jafolabi
 */
public class Add_exam_paneController implements Initializable {
    @FXML
    private ChoiceBox<?> course_title_choicebox;
    @FXML
    private TextField course_code_text;
    @FXML
    private TextField total_score_text;
    @FXML
    private TextField your_score_text;
    @FXML
    private Label HEADER;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
