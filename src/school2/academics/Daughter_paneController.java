/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2.academics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jafolabi
 */
public class Daughter_paneController implements Initializable {
    @FXML
    private AnchorPane daughter_main_pane;
    @FXML
    private Button academics_button;
    @FXML
    private Button studies_button;
    @FXML
    private Button calender_button;
    @FXML
    private AnchorPane main_pane;
    @FXML
    private AnchorPane updates_pane;
    @FXML
    private MenuButton filter_menu;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private AnchorPane scrollpane_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void academicsButtonClick(MouseEvent event) throws Exception {
        loadView("academics/academic_main_pane.fxml");
    }

    @FXML
    private void studeisButtonClick(MouseEvent event) throws Exception{
        loadView("study/study_main_pane.fxml");
    }

    @FXML
    private void calenderButtonClick(MouseEvent event) throws Exception {
        loadView("calender/calender_main_pane.fxml");
    }


    @FXML
    private void filterMenuClick(MouseEvent event) {
    }
    
     public  void loadView(String fxml) throws Exception {
        main_pane.getChildren().remove(0);
       Node node = FXMLLoader.load(getClass().getResource(fxml));
        main_pane.getChildren().add(node);
    }

    
}
