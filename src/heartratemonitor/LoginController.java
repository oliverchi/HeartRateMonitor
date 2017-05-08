/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
    @FXML // fx:id="username"
    private TextField username; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader
    
    @FXML // fx:id="invalidMsg"
    private Label invalidMsg; // Value injected by FXMLLoader
    
    private boolean loginValidator(String name,String pwd) {
        try{           
            ConnectLocalDatabase DB = new ConnectLocalDatabase(); 
            DB.connectDB();
            PreparedStatement pst = DB.conn.prepareStatement("Select * from login where username=? and password=?");
            pst.setString(1, name); 
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();                       
            if( rs.next() ){            
                return true;    
            } else {
                return false; 
            }
        } catch(SQLException e){
              e.printStackTrace();
              return false;
        }       
    }
    
    /**
    * Event handler for Button Login
    */
    @FXML
    void handleLoginButtonAction(ActionEvent event) {  
        if (HeartRateMonitor.getUser().getUserName().equals("")){
            //Setup an User object
            User login = new User();
            
            //check if username and password is in database
            if(loginValidator(username.getText(),password.getText())){
                login.setUserName(username.getText());
                login.setPassword(password.getText()); 
                HeartRateMonitor.setUser(login);
                //System.out.println(HeartRateMonitor.getUser().getUserName());//use for test
                new SwitchPanes("Homepage");                 
            } else {
                invalidMsg.setText("incorrect username and password!");
            }
        } else {
            invalidMsg.setText("Duplicate loginning, please logout first!");
        }
    }
    
    
    /**
    * Event handler for Button NewUser
    * switch to register page
    */
    @FXML
    void handleNewUserButtonAction(ActionEvent event) {  
        new SwitchPanes("Register");
    }
    
    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
