/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Oliver
 */
public class PopupWindow {
    
    Stage popup;
    GridPane pane;
    Label txt;
    Button btn1, btn2;    
    
    public PopupWindow(){
        //build all controllers
        txt = new Label("Please save all works before exiting system!");        
        btn1 = new Button("Cancel");        
        btn2 = new Button("Exit");
        btn1.setPrefSize(70, 10);
        btn2.setPrefSize(70, 10);        
        
        //cancel button action
        btn1.setOnAction((ActionEvent event) -> {
            popup.close();
        });
        
        //exit button action
        btn2.setOnAction((ActionEvent event) -> {
            popup.getOwner().hide();
        });
        
        //add all controllers to grid pane
        pane = new GridPane();
        pane.add(btn1, 1, 1, 1, 1);
        pane.add(btn2, 2, 1, 1, 1);
        pane.add(txt, 0, 0, 4, 1);
        pane.setVgap(10.0);
        pane.setHgap(txt.getText().length()*2);
        
        //set style
        pane.getStylesheets().add(getClass()
                .getResource("Homepage.css").toExternalForm());
        txt.getStyleClass().add("popuptext");
        btn1.getStyleClass().add("button");
        btn2.getStyleClass().add("button");        
        
        //finalise stage
        popup = new Stage();
        popup.setScene(new Scene(pane));
        popup.setTitle("Pop-up window");
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(HeartRateMonitor.getScene().getWindow());
        popup.showAndWait();
    }
    
    public PopupWindow(String nameofbutton, String msg){
        //build all controllers
        txt = new Label(msg);
        btn1 = new Button("Cancel");
        btn2 = new Button(nameofbutton);
        btn1.setPrefSize(70, 10);
        btn2.setPrefSize(70, 10);
        
        //cancel button action
        btn1.setOnAction((ActionEvent event) -> {
            popup.close();
        });
        
        //exit button action
        btn2.setOnAction((ActionEvent event) -> {
            actionOnButton(nameofbutton);
        });
        
        //add all controllers to grid pane
        pane = new GridPane();
        pane.add(btn1, 1, 1, 1, 1);
        pane.add(btn2, 2, 1, 1, 1);
        pane.add(txt, 0, 0, 4, 1);
        pane.setVgap(10.0);
        pane.setHgap(txt.getText().length()*2);    
        
        //set style
        pane.getStylesheets().add(getClass()
                .getResource("Homepage.css").toExternalForm());
        txt.getStyleClass().add("popuptext");
        btn1.getStyleClass().add("button");
        btn2.getStyleClass().add("button");
        
        //finalise stage
        popup = new Stage();
        popup.setScene(new Scene(pane));
        popup.setTitle("Pop-up window");
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.initOwner(HeartRateMonitor.getScene().getWindow());
        popup.showAndWait();
    }   
    
    void actionOnButton(String nameofButton){
        switch (nameofButton){
            case "Exit" :
                popup.getOwner().hide();
                break;
                
            case "OK":
                popup.hide();
                break;
                
            default:
                popup.hide();
                break;
        }
            
    }
}
