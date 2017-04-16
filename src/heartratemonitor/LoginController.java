/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class LoginController implements Initializable {

    @FXML // fx:id="loginbutton"
    private Button loginbutton; // Value injected by FXMLLoader
        
    @FXML // fx:id="newuser"
    private Button newuser; // Value injected by FXMLLoader
        
    @FXML // fx:id="username"
    private TextField username; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader
    
    @FXML // fx:id="invalidMsg"
    private Label invalidMsg; // Value injected by FXMLLoader
    
    /**
    * Event handler for Button Login
    */
    @FXML
    void handleLoginButtonAction(ActionEvent event) {  
        
    }
    
    
    /**
    * Event handler for Button NewUser
    */
    @FXML
    void handleNewUserButtonAction(ActionEvent event) {  
        
    }
    
    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
