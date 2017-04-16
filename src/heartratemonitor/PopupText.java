/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Window;

/**
 *
 * @author Oliver
 */
public class PopupText {
    /**
     * Constructor without args
     * Build an exit popup window
     */
    public PopupText(){
        //message label
        Label msg = new Label("Please confirm that you choose to exit: ");
        msg.setMaxWidth(300);
        msg.setMaxHeight(120);
        
        //popup window
        Popup alertPopup = new Popup();
        
        //Buttons and Actions on them
        Button cancelButton = new Button("Cancel");
        Button okButton = new Button("Confirm");
        cancelButton.setOnAction(e -> {
            alertPopup.hide();
        });
        okButton.setOnAction(e -> {
            alertPopup.getOwnerWindow().hide();
        });
        
        //root pane
        BorderPane popUpPane = new BorderPane();        
        if(alertPopup.getContent().add(popUpPane)){
            //System.out.println("Be successful to add controllers. ");
        }else{
            //System.out.println("Fail to add Pane on stage.");
        }
        popUpPane.setCenter(msg);
        popUpPane.setBottom(new HBox(cancelButton,okButton));
        
        //controllers set positions
        msg.setAlignment(Pos.CENTER);
        cancelButton.setAlignment(Pos.CENTER_LEFT);
        okButton.setAlignment(Pos.CENTER_RIGHT);
        
        //set styles
        popUpPane.getStylesheets().add(getClass()
                .getResource("Homepage.css").toExternalForm());
        popUpPane.getStyleClass().add("popup");
        msg.getStyleClass().add("message");
        
        //show popup window
        Window win = HeartRateMonitor.getScene().getWindow();
        alertPopup.show(win,
                (win.getWidth() - 300)/2 + win.getX(), 
                (win.getHeight() - 120)/2 + win.getY());
    }
    
    /**
     * Constructor with args 
     * Build an alert popup only containing one message
     */
    public PopupText(String message, int W, int H, int x, int y){
        //common popup window constructor
        //args: message in label, W: width of message, H: height of message
        //args: (x,y) : message in position(x,y)
        
        //build message
        Label msg = new Label(message);
        msg.setMaxWidth(W);
        msg.setMaxHeight(H);
        
        //set popup and root pane
        Popup alertPopup = new Popup();        
        AnchorPane popUpPane = new AnchorPane();
        if(alertPopup.getContent().add(popUpPane)){
            //System.out.println("Be successful to add controllers. ");
        }else{
            //System.out.println("Fail to add Pane on stage.");
        }
        popUpPane.getChildren().add(msg);        
        msg.setAlignment(Pos.CENTER);//set display position of message
        
        //set style 
        popUpPane.getStylesheets().add(getClass()
                .getResource("Homepage.css").toExternalForm());
        msg.getStyleClass().add("message");
        
        //set position (x,y)
        Window win = HeartRateMonitor.getScene().getWindow();
        alertPopup.show(win, x, y);
    }
}
