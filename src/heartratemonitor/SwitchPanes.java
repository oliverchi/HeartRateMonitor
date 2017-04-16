/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Oliver
 */
public class SwitchPanes {
    
    //create url of FXM file and its name 
    String fxmfile = new String();
    String filename = new String();
    
    //default constructor
    //function: switch to login panel
    public SwitchPanes(){
        try {
            URL loginUrl = getClass().getResource("LoginPane.fxml");
            GridPane loginPane = FXMLLoader.load( loginUrl );
            loginPane.getStyleClass().add("login");
      
            BorderPane border = HeartRateMonitor.getPane();
            border.setCenter(loginPane);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public SwitchPanes(String nameofpane){
        
        switch (nameofpane){            
            case "Register":
                fxmfile = "RegisterPane.fxml";
                break;
            
            case "Homepage":
                fxmfile = "Homepage.fxml";
                break;
                
            case "Recommend":
                fxmfile = "Homepage.fxml";
                break;
                
            case "Record":
                fxmfile = "RecordPane.fxml";
                break;
                
            case "Review":   
                fxmfile = "ReviewPane.fxml";
                break;
                
            case "Email to Doctor":
                fxmfile = "EmailPane.fxml";
                break;
                
            case "Email":
                fxmfile = "EmailPane.fxml";
                break;
                
            case "Forum":
                fxmfile = "ForumPane.fxml";
                break;
                
            case "Manual":
                fxmfile = "ManualPane.fxml";
                break;
                
            case "QA":
                fxmfile = "QAPane.fxml";
                break;
                
            case "About":
                fxmfile = "AboutPane.fxml";
                break;
                
            case "Login":
                fxmfile = "LoginPane.fxml";
                break;
                
            default:
                System.out.println("Wrong Griven Name Of New Pane!");//print error message
                break;
        }         
        
        //filename: css reference (all low case)
        filename = nameofpane;
        if (nameofpane.equals("Email to Doctor")) filename = "Email"; //reunite name
        if (nameofpane.equals("Recommend")) filename = "Homepage"; //recommend page is homepage
        
        //do switching pane
        try {
            URL url = getClass().getResource(fxmfile);
            GridPane newPane = FXMLLoader.load( url );
            newPane.getStyleClass().add(filename.toLowerCase());      
            BorderPane border = HeartRateMonitor.getPane();
            border.setCenter(newPane);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
