/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Oliver
 */
public class HeartRateMonitor extends Application {
    
    //Create a static root to pass to the controller
    //Set BorderPane as layout 
    private final static BorderPane ROOTPANE = new BorderPane();
    
    //Object User
    private static User user = new User();
    
    //Object Patient
    private static Patient patient = new Patient();
    
    //Create main scene
    private static Scene scene;
    
    /**
     * initial stage: start()
     * @param primaryStage
     * @throws IOException 
     */    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        // load FXML resources for First Page
        URL menubarUrl = getClass().getResource("MenuBar.fxml");
        MenuBar menubar = FXMLLoader.load( menubarUrl );
        menubar.getStyleClass().add("menubar");

        URL loginUrl = getClass().getResource("LoginPane.fxml");
        GridPane loginPane = FXMLLoader.load( loginUrl );
        loginPane.getStyleClass().add("login");
        
        //layout controls in the borderpane
        ROOTPANE.setTop(menubar);
        ROOTPANE.setCenter(loginPane);
        
        //construct our scene
        scene = new Scene(ROOTPANE, 800, 600);
        scene.getStylesheets().add(getClass()
                .getResource("Homepage.css").toExternalForm());
        
        //show the stage
        primaryStage.setTitle("Heart Rate Monitor");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        //primaryStage.getIcons().add(new Image(""));
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setMinHeight(460);
        primaryStage.setMinWidth(400);
        primaryStage.show();
    }

    /**
     * main()
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        //new CreateTables();//create DB and create tables for test use
        launch(args);
    }
    
    /**
     * Method getPane()
     * @return root pane
     */
    public static BorderPane getPane() {
        return ROOTPANE;
    }
    
    /**
     * Method getUser()
     * @return user object
     */
    public static User getUser() {
        return user;
    }
    
    /**
     * Method setUser()
     * @param u
     */
    public static void setUser(User u) {
        user = u;
    }
    
    /**
     * Method getPatient()
     * @return patient object
     */
    public static Patient getPatient() {
        return patient;
    }
    
    /**
     * Method setPatient()
     * @param p
     */
    public static void setPatient(Patient p) {
        patient = p;
    }
    
    /**
     * Method getScene()
     * @return main scene
     */
    public static Scene getScene() {
        return scene;
    }
}