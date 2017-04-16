/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Oliver
 */
public class AlertMsg {
    
    Alert alert;
            
    public AlertMsg(){
        alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText("Attention!!!Save your works!");
        alert.setContentText("Careful with the next step!");
        alert.showAndWait();
    }
    
    //args: AlertType, Window title, Message header, Message text
    public AlertMsg(String type, String title, String header, String msg){
        switch (type){
            case "Information":
                alert = new Alert(AlertType.INFORMATION);
                break;
                
                case "Confirmation":
                alert = new Alert(AlertType.CONFIRMATION);
                break;
                
                case "Error":
                alert = new Alert(AlertType.ERROR);
                break;
                
                case "Warning":
                alert = new Alert(AlertType.WARNING);
                break;
                
            default:
                break;
        }
        
        alert.setTitle(title);
        
        //should insert button actions depending on different title
        
        if (!header.equals("")) alert.setHeaderText(header);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
