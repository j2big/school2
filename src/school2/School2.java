/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school2;

import java.awt.TrayIcon;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Joshua
 */
public class School2 extends Application {

    private boolean firstTime;
    private TrayIcon trayIcon;

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseCreator dbc = new DatabaseCreator();
        dbc.create();

        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root);

        // firstTime = true;
        //make stage fit any screen size
        Rectangle2D screen = Screen.getPrimary().getVisualBounds();
        
        stage.setX(screen.getMinX());
        stage.setY(screen.getMinY());
        stage.setWidth(screen.getWidth());
        stage.setHeight(screen.getHeight());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    /*
     make minimise to tray
    
     public void createTrayIcon(final Stage stage) {
     if (SystemTray.isSupported()) {
     // get the SystemTray instance
     SystemTray tray = SystemTray.getSystemTray();
     // load an image
     java.awt.Image image = null;
     try {
     URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
     image = ImageIO.read(url);
     } catch (IOException ex) {
     System.out.println(ex);
     }

     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
     @Override
     public void handle(WindowEvent t) {
     hide(stage);
     }
     });
     // create a action listener to listen for default action executed on the tray icon
     final ActionListener closeListener = new ActionListener() {
     @Override
     public void actionPerformed(java.awt.event.ActionEvent e) {
     System.exit(0);
     }
     };

     ActionListener showListener = new ActionListener() {
     @Override
     public void actionPerformed(java.awt.event.ActionEvent e) {
     Platform.runLater(new Runnable() {
     @Override
     public void run() {
     stage.show();
     }
     });
     }
     };
     // create a popup menu
     PopupMenu popup = new PopupMenu();

     MenuItem showItem = new MenuItem("Show");
     showItem.addActionListener(showListener);
     popup.add(showItem);

     MenuItem closeItem = new MenuItem("Close");
     closeItem.addActionListener(closeListener);
     popup.add(closeItem);
     /// ... add other items
     // construct a TrayIcon
     trayIcon = new TrayIcon(image, "Title", popup);
     // set the TrayIcon properties
     trayIcon.addActionListener(showListener);
     // ...
     // add the tray image
     try {
     tray.add(trayIcon);
     } catch (AWTException e) {
     System.err.println(e);
     }
     // ...
     }
     }

     public void showProgramIsMinimizedMsg() {
     if (firstTime) {
     trayIcon.displayMessage("Some message.",
     "Some other message.",
     TrayIcon.MessageType.INFO);
     firstTime = false;
     }
     }

     private void hide(final Stage stage) {
     Platform.runLater(new Runnable() {
     @Override
     public void run() {
     if (SystemTray.isSupported()) {
     stage.hide();
     showProgramIsMinimizedMsg();
     } else {
     System.exit(0);
     }
     }
     });

     }*/
}
