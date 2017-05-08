/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class MenuBarController implements Initializable {
    
    @FXML // fx:id="logout"
    private MenuItem logout; // Value injected by FXMLLoader

    @FXML // fx:id="exit"
    private MenuItem exit; // Value injected by FXMLLoader

    @FXML // fx:id="recomm"
    private MenuItem recomm; // Value injected by FXMLLoader

    @FXML // fx:id="record"
    private MenuItem record; // Value injected by FXMLLoader
    
    @FXML // fx:id="review"
    private MenuItem review; // Value injected by FXMLLoader

    @FXML // fx:id="email"
    private MenuItem email; // Value injected by FXMLLoader
    
    @FXML // fx:id="forum"
    private MenuItem forum; // Value injected by FXMLLoader

    @FXML // fx:id="manual"
    private MenuItem manual; // Value injected by FXMLLoader
    
    @FXML // fx:id="qa"
    private MenuItem qa; // Value injected by FXMLLoader

    @FXML // fx:id="about"
    private MenuItem about; // Value injected by FXMLLoader  
    
    
    /**
    * Event handler for MenuItem Register
    */
    @FXML
    void switchToRegisterPane(ActionEvent event) {  
        new SwitchPanes("Register");
    }
    
    /**
    * Event handler for MenuItem Logout
    */
    @FXML
    void switchToLoginPane(ActionEvent event) {  
        HeartRateMonitor.setUser(new User());
        new SwitchPanes("Login");
    }

    /**
    * Event handler for MenuItem Exit
    */
    @FXML
    void popUpExitPane(ActionEvent event) {  
        try {      
            //new AlertPopup();//change it late to dialog window
            new PopupWindow();
            //new PopupWindow("Exit", "Please choose if exit system:");//alternative option
            //new AlertMsg();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
    * Event handler for MenuItem Recommend
    */
    @FXML
    void switchToRecommPane(ActionEvent event) {  
        new SwitchPanes("Homepage");
    }
    
    /**
    * Event handler for MenuItem Record
    */
    @FXML
    void switchToRecordPane(ActionEvent event) {  
        new SwitchPanes("Record");
    }
    
    /**
    * Event handler for MenuItem Review
    */
    @FXML
    void switchToReviewPane(ActionEvent event) {  
        new SwitchPanes("Review");
    }
    
    /**
    * Event handler for MenuItem Email
    */
    @FXML
    void switchToEmailPane(ActionEvent event) {  
        new SwitchPanes("Email");
    }
    
    /**
    * Event handler for MenuItem Forum
    */
    @FXML
    void switchToForumPane(ActionEvent event) {  
        new SwitchPanes("Forum");
    }
    
    /**
    * Event handler for MenuItem Manual
    */
    @FXML
    void switchToManualPane(ActionEvent event) {  
        new SwitchPanes("Manual");
    }
    /**
    * Event handler for MenuItem Q&A
    */
    @FXML
    void switchToQAPane(ActionEvent event) {  
        new SwitchPanes("QA");
    }
    
    /**
    * Event handler for MenuItem About
    */
    @FXML
    void switchToAboutPane(ActionEvent event) {  
        new SwitchPanes("About");
    }
    
    /**
     * Method disableMenu()
     * Disable part of Menu when user hasn't logged in
     */ 
    public void disableMenu(){
        logout.setDisable(true);
        //recomm.setDisable(true);
        record.setDisable(true);
        review.setDisable(true);
        email.setDisable(true);
        forum.setDisable(true);
    }
    
    /**
     * Method enableMenu()
     * Enable all of Menu when user has logged in
     */ 
    public void enableMenu(){
        logout.setDisable(false);
        recomm.setDisable(false);
        record.setDisable(false);
        review.setDisable(false);
        email.setDisable(false);
        forum.setDisable(false);
    }
    
    /**
    * Event handler for Mouse clicked
    * decide if disable menu items
    */
    @FXML
    void checkIfDisableMenu(Event event) {  
        if (HeartRateMonitor.getUser().getUserName().equals("")){
            disableMenu(); 
        } else {            
            enableMenu();
        }
    }
    
    @FXML
    void checkIfDisableMenu2(MouseEvent event) {  
        if (HeartRateMonitor.getUser().getUserName().equals("")){
            disableMenu();     
            System.out.println("disable menu");
        } else {            
            enableMenu();
            System.out.println("enable menu");
        }
    }
    
    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Check if user has logged in
        //Disable/enable menu depending on logged in or not
        if (HeartRateMonitor.getUser().getUserName().equals("")){
            disableMenu();//hide during building program            
        } else {            
            enableMenu();
        }
    }    
    
}