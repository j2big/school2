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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Study_main_paneController implements Initializable {

    @FXML
    private AnchorPane study_display_pane;
    @FXML
    private Pane study_dummy_pane;
    private String ctitle, ccode, cunit, ctype, clecturer;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private String sql = "";
    ArrayList<String> coursesList = new ArrayList();
    @FXML
    private GridPane main_grid_pane= new GridPane();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            createGridView();
        // TODO
    }

    public void createGridView() {
                main_grid_pane.setHgap(5);
                main_grid_pane.setVgap(5);
                
                for(int i =0;i<=9;i++){
                main_grid_pane.add(main_grid_pane, 0, i);
                }
    }

    public ArrayList<String> getCourseTitles() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/school2.db");
            preparedStatement = connection.prepareStatement(sql);

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

}
