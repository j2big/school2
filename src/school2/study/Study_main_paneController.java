package school2.study;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import school2.schoolLog;

public class Study_main_paneController implements Initializable {

    private String ctitle, ccode, cunit, ctype, clecturer;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql = "";
    ArrayList<String> coursesList = new ArrayList();

    schoolLog smp = new schoolLog();
    ArrayList<Label> gl = new ArrayList<>();
    Label tx;
    @FXML
    private AnchorPane study_pane_main;
    @FXML
    private VBox study_vbox;
    @FXML
    private ScrollPane grid_scroll_pane;
    @FXML
    private TilePane main_tile_pane = new TilePane();
    ArrayList courses = new ArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        updateTile(getCourseList());
        courses.add(getCourseList());
        // TODO
    }

    public ArrayList<String> getCourseList() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            // preparedStatement = connection.prepareStatement(sql);

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select course_title from course_table ");

            while (resultSet.next()) {
                ctitle = resultSet.getString("course_title");
                coursesList.add(ctitle);
            }

        } catch (Exception er) {
            er.printStackTrace();
        } finally {
            try {
                connection.close();
                resultSet.close();
            } catch (SQLException er) {
                er.printStackTrace();
            }
        }

        return coursesList;

    }

    public void updateTile(ArrayList courses) {
        String c;

        main_tile_pane.setPadding(new Insets(2, 2, 2, 2));
        main_tile_pane.setHgap(5);
        main_tile_pane.setVgap(5);
        main_tile_pane.setPrefRows(5);
        Label title;
        final ArrayList<Label> t_list = new ArrayList<>();
        AnchorPane preview;
        // main_tile_pane.setPrefTileHeight(5);

        Button button = new Button();

        for (int i = 0; i < courses.size(); i++) {
            preview = new AnchorPane(); // set pane to group elements to be shown in the tile
            preview.setPadding(new Insets(2, 2, 2, 2)); // set padding space b
            title = new Label(courses.get(i).toString());
            t_list.add(i, title);
            title.setPrefWidth(Label.USE_COMPUTED_SIZE);
            title.setPadding(new Insets(0, 0, 0, 2));
            button = new Button("" + i);
            button.setPrefSize(200, 100);
            // button.setOnAction(myHandler);
            button.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                //    hand(title);
                }
            });
            preview.getChildren().add(button);
            preview.getChildren().add(title);
            main_tile_pane.getChildren().addAll(preview);
        }
    }

    final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>() {

        @Override
        public void handle(final ActionEvent event) {
            String c = "";
            int i = 0;
            // for (int x = 0; x < courses.size(); x++) {
            while ((i <= courses.size()) || !(event.getSource().toString().equals(courses.get(i).toString()))) {
                System.out.println("Button " + courses.get(i).toString() + " clicked");
                i++;
            }
        }
    };

    public void hand(String x) {

    }

}
