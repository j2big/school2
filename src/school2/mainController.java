/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Joshua
 */
public class mainController implements Initializable {

    private Label label;
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
    private MenuButton main_options_button;
    @FXML
    private MenuButton filter_menu;
    @FXML
    private MenuItem close_option;
    @FXML
    private MenuItem tray_option;
    @FXML
    private AnchorPane scrollpane_pane;
    @FXML
    private ScrollPane scroll_pane;
    @FXML
    private Pane dummy_pane;
    @FXML
    private Button options_button;
    @FXML
    private Button global_button;
    @FXML
    private Button help_button;
    @FXML
    private Label username_info_text;
    @FXML
    private Label school_info_text;
    @FXML
    private ImageView school_logo;
    @FXML
    private ImageView settings_button;
    @FXML
    private ImageView user_avatar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void academicsButtonClick(MouseEvent event) throws Exception {
        loadView("academic_main_pane.fxml");
    }

    @FXML
    private void studeisButtonClick(MouseEvent event) {
    }

    @FXML
    private void calenderButtonClick(MouseEvent event) {
    }

    @FXML
    private void filterMenuClick(MouseEvent event) {
    }

    @FXML
    private void closeOptionClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void mainOptionClicked(MouseEvent event) {
    }

    @FXML
    private void trayOptionClick(ActionEvent event) {
    }

    public void loadView(String fxml) throws Exception {
        main_pane.getChildren().remove(0);
        Node node = FXMLLoader.load(getClass().getResource(fxml));
        main_pane.getChildren().add(node);
    }

    @FXML
    private void optionsButtonClicked(MouseEvent event) {
    }

    @FXML
    private void globalbuttonsClicked(MouseEvent event) {
    }

    @FXML
    private void helpButtonClicked(MouseEvent event) {
    }

    @FXML
    private void schoolLogoClicked(MouseEvent event) {
    }

    @FXML
    private void settingsButtonClicked(MouseEvent event) {
    }

    @FXML
    private void userAvatarClicked(MouseEvent event) {
    }
}
