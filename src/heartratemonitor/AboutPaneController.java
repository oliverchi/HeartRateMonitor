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
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class AboutPaneController implements Initializable {

    @FXML // fx:id="aboutText"
    private WebView aboutText; // Value injected by FXMLLoader
        
    @FXML // fx:id="imageView"
    private ImageView imageView; // Value injected by FXMLLoader
    
    @FXML // fx:id="returnButton"
    private Button returnButton; // Value injected by FXMLLoader
    
    /**
    * Event handler for Return Button
    */
    @FXML
    void returnToHomepage(ActionEvent event) {  
        new SwitchPanes("Homepage");//back to homepage
    }
        
    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aboutText.setMinSize(300, 280);
    }    
    
}
