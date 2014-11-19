/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Joshua
 */
public class Academic_main_paneController implements Initializable {

    Logger acd = new Logger();
    @FXML
    private MenuButton courses_menubutton;
    @FXML
    private MenuItem add_course_option;
    @FXML
    private MenuItem remove_course_option;
    @FXML
    private MenuItem edit_course_option;
    @FXML
    private MenuButton session_menubutton;
    @FXML
    private MenuButton scores_menubutton;
    @FXML
    private MenuItem class_work_score_option;
    @FXML
    private MenuItem assignment_score_option;
    @FXML
    private MenuItem test_score_option;
    @FXML
    private MenuItem exam_score_option;
    @FXML
    private MenuButton analysis_menubutton;
    @FXML
    private MenuItem gp_analysis_option;
    @FXML
    private MenuItem performance_analysis_option;
    @FXML
    private AnchorPane academic_display_pane;
    private ObservableList<MenuItem> courses_list;
    @FXML
    private Pane dummy_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void loadView(String fxml) throws Exception {
        academic_display_pane.getChildren().remove(0);
        Node node = FXMLLoader.load(getClass().getResource(fxml));
        academic_display_pane.getChildren().add(node);
    }

    @FXML
    private void coursesMenuButtonClick(ActionEvent event) throws Exception {
    }

    @FXML
    private void sessionMenuButtonClick(ActionEvent event) {
    }

    @FXML
    private void scoresMenuButtonClick(ActionEvent event) {
    }

    @FXML
    private void analysisMenuButtonClick(ActionEvent event) {
    }   

    @FXML
    private void addCourseOptionClick(ActionEvent event) throws Exception {
        loadView("add_course_pane.fxml");
    }

    @FXML
    private void removeCourseOptionClick(ActionEvent event) throws Exception {
        loadView("remove_course_pane.fxml");
    }

    @FXML
    private void editCourseOptionClick(ActionEvent event) throws Exception {
        loadView("edit_course_pane.fxml");
    }

    @FXML
    private void classWorkScoreOptionClick(ActionEvent event) throws Exception {
        loadView("add_classwork_pane.fxml");
    }

    @FXML
    private void assignmentScoreOptionClick(ActionEvent event) throws Exception {
        loadView("add_assignment_pane.fxml");
    }

    @FXML
    private void testScoreOptionClick(ActionEvent event) throws Exception {
        loadView("add_test_pane.fxml");
    }

    @FXML
    private void examScoreOptionClcik(ActionEvent event) throws Exception {
        loadView("add_exam_pane.fxml");
    }

    @FXML
    private void gpAnalysisOptionClick(ActionEvent event) {
    }

    @FXML
    private void performanceAnalysisOptionClcik(ActionEvent event) {
    }

}
