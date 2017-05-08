/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class RecordPaneController implements Initializable {

    @FXML // fx:id="funcMsg"
    private Label funcMsg; // Value injected by FXMLLoader
        
    @FXML // fx:id="funcBox"
    private ChoiceBox funcBox; // Value injected by FXMLLoader
    
    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialise choice box
        funcBox.setItems(FXCollections.observableArrayList("Record",
                "Recommend","Review","Email to Doctor"));
        
        //ChoiceBox listener
        funcBox.getSelectionModel().selectFirst();
        funcBox.getSelectionModel().selectedItemProperty()
                .addListener( listener -> {
            String selected = funcBox.getSelectionModel()
                    .selectedItemProperty().getValue().toString();
            //System.out.println(selected);//for test 
            new SwitchPanes(selected);
        });
    }    
    
}
