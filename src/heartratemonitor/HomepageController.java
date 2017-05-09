/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class HomepageController implements Initializable {

    @FXML
    private Label welcomeText; // Value injected by FXMLLoader    
    
    @FXML
    private Label text1;   
    
    @FXML
    private Label text2;
    
    @FXML
    private ComboBox functions;
    
    @FXML 
    private VBox functionBox;
    
    
    /**
     * Initialises the controller class.
     * @param url
     * @param rb
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
            
        //setup for text1 
        String t1 = "\n\nHRM health system aims to record, analyse\nand "
                + "review patients' heart test results.\n\n\n";
        text1.setText(t1);
        
        //setup for text2 
        String t2 = "choose one function to run";
        text2.setText(t2);
        
        //sign object patient with all values from database 
        try {
            //access database retrieve all information of this patient
            HeartRateMonitor.setPatient(retrieve());
        } catch (SQLException ex) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        //Set welcome message
        welcomeText.setText("Welcome, " + HeartRateMonitor.getPatient().getFirstName() + " " + 
                HeartRateMonitor.getPatient().getLastName());
        
        //Setup functions' name
        //the sequence of functions have to match the squence of index in method doFunction()!!!
        String func0 = "Record Test Result";
        String func1 = "Recommend IF Test";
        String func2 = "Review Test Results";
        String func3 = "Email to Doctor";   
        
        //Setup functional ComboBox
        //the sequence of functions have to match the squence of index in method doFunction()!!!
        functions.setItems(FXCollections.observableArrayList(func0, func1, func2, func3));
        
        //combo box actions
        functions.getSelectionModel().selectedItemProperty()
                .addListener( listener -> {
            Integer selected = functions.getSelectionModel().getSelectedIndex();//index is integer starting from 0
                    //.selectedItemProperty().toString();for test
                    //System.out.println(selected);fro test
            //do functions
            doFunction(selected);
        });
    }   
    
    //retrieve information for patient object
    private Patient retrieve() throws SQLException{
        Patient patient = new Patient();
        ConnectLocalDatabase DB = new ConnectLocalDatabase(); 
        DB.connectDB();
        String name = HeartRateMonitor.getUser().getUserName();
        PreparedStatement pst = DB.conn.prepareStatement("Select * from patient "
                + "where username=?");
        pst.setString(1, name); 
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                patient.setUserName(name);
                patient.setFirstName(rs.getString("FIRSTNAME"));
                patient.setLastName(rs.getString("LASTNAME"));   
                patient.setDate(rs.getDate("DOB"));
                patient.setMobile(rs.getString("MOBILE")); 
                patient.setEmail(rs.getString("EMAIL")); 
                patient.setStreet(rs.getString("STREET")); 
                patient.setCity(rs.getString("CITY")); 
                patient.setState(rs.getString("STATE")); 
                patient.setPostcode(rs.getString("POSTCODE")); 
                patient.setMedicare(rs.getString("MEDICARE")); 
            }
        }
        return patient;
    }
    
    //do functions on request from user's choice in combo box
    private void doFunction(int index){    
        //all indexes match the sequence of items in ComboBox!!!
        switch(index){
            case 0:                                
                recordTestResult();
                break;
                
            case 1:          
                recommendIfTest();                
                break;
                
            case 2:                
                reviewTestResults();
                break;
                
            case 3:                
                emailToDoctor();
                break;
                
            default: 
                //do nothing if error happens
                functionBox.getChildren().clear();
                break;
        }
    }
    
    //do function recording test result
    private void recordTestResult() {
        //Controllers for Function recording test results
        Label t0 = new Label("\nRecord Results from Recent Heart Rate Test\n");
                t0.setStyle("-fx-font:22 \"Agency FB\";");
                
        Label t001 = new Label("\nTest Date:");        
                t001.setStyle("-fx-font:16 \"Agency FB\";");
                
        DatePicker dateForTest = new DatePicker();
                dateForTest.setPrefWidth(100.00);
                dateForTest.setMaxWidth(120.0);
                
        Label t002 = new Label("\nTest Result(beats per min):");
                t002.setStyle("-fx-font:16 \"Agency FB\";");
                
        TextField testResult = new TextField("");
                testResult.setStyle("-fx-fontfill: red;");
                testResult.setPrefWidth(100.0);
                testResult.setMaxWidth(120.0);
                
        Label t003 = new Label("\n");
        
        Button recordSubmit = new Button("Submit Result");
        
        Label t004 = new Label("\n");
        
        //add up all children and set style for function display
        functionBox.getChildren().clear();
        functionBox.getChildren().addAll(t0, t001, dateForTest, t002,
                        testResult, t003, recordSubmit, t004);        
        functionBox.setSpacing(5.0);                
        functionBox.setAlignment(Pos.TOP_LEFT);
                
        //check valid for test date
        dateForTest.setOnAction((ActionEvent e) -> {
            if ( dateForTest.getValue().isBefore((LocalDate.of(2016,1,1)))){
                    //action to give warning error
                    t003.setText("warning: please recheck your input");
            } else {
                t003.setText("\n");
            }
        });
                
        //check valid for test result
        testResult.setOnKeyReleased((KeyEvent e) -> {
            if ( !testResult.getText().matches("\\d+")){
                    //action to give warning error
                    t003.setText("warning: please recheck your input");
            } else {
                    t003.setText("\n");
            }
        });
                
        //submit button action
        recordSubmit.setOnAction((ActionEvent e) -> {
            if ( dateForTest.getValue().isBefore((LocalDate.of(2016,1,1)))
                    || testResult.getText().isEmpty() 
                    || !t003.getText().equals("\n") ){
                //action to give warning error
                t003.setText("warning: please recheck your input");            
            } else {
                //check if it is a dupliated record
                if ( inputIsDuplicate(dateForTest.getValue()) ) {
                    //give warning due to duplicated record
                    t004.setText("Warning: result in the same date occurs\n"
                            + " Please don't dupulicate record test rest");
                    t004.setStyle("-fx-font:16 \"Agency FB\";");
                    t004.setStyle("-fx-background-color: red;");
                    t004.setStyle("-fx-text-fill: white;");
                } else {
                    t004.setText("\n");//delete warning message
                    //submit new input to databases
                    try {                          
                        new ChangeTables(HeartRateMonitor.getUser().getUserName(),
                            Date.valueOf( dateForTest.getValue() ), 
                            Integer.parseInt( testResult.getText() )
                        );
                    } catch (SQLException ex) {                    
                        Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });    
    }
    
    //do function giving recommendation if need testing
    private void recommendIfTest(){
        //Controllers for recommending if need test today
        Label t0 = new Label("Recommend IF Need Heart Rate Test For Today\n");
                t0.setStyle("-fx-font:22 \"Agency FB\";");
                
        Label t001 = new Label("\n");        
                t001.setStyle("-fx-font:18 \"Agency FB\";");           
              
        Label t002 = new Label("\n");
                t002.setStyle("-fx-font:16 \"Agency FB\";");
        
        //add up all children and set style for function display
        functionBox.getChildren().clear();
        functionBox.getChildren().addAll(t0, t001, t002);        
        functionBox.setSpacing(5.0);                
        functionBox.setAlignment(Pos.TOP_LEFT);
        
        if (new AnalyseResults().calculateSevenResults()) {//check if last seven results are healthy
            t001.setText("\nYou don't need to take a test today \n because "
                    + "your previous test results are good.");
        } else {
            t001.setText("\nYou should take a test today \n due to "
                    + "the analysis of your previous test results.");
        }
    }
    
    //do function reviewing preview test results
    private void reviewTestResults() {
        //Controllers for Function reviewing the preview test results
        Label t0 = new Label("\nReview Previous Heart Rate Test Results");
              t0.setStyle("-fx-font:22 \"Agency FB\";");
        
        Label t001 = new Label("\nReview the results of heart rate test since");        
                t001.setStyle("-fx-font:16 \"Agency FB\";");
                
        DatePicker dateForTest = new DatePicker();
                dateForTest.setPrefWidth(100.00);
                dateForTest.setMaxWidth(120.0);
                dateForTest.setPromptText("2017-01-01");
                
        Label t003 = new Label("\n");
        
        Button recordSubmit = new Button("Submit Result");
        
        functionBox.getChildren().clear();
        functionBox.getChildren().addAll(t0, t001, dateForTest, t003, recordSubmit);
        functionBox.setSpacing(5.0);                
        functionBox.setAlignment(Pos.TOP_LEFT);
        
        //check valid for test date
        dateForTest.setOnAction((ActionEvent e) -> {
            if ( dateForTest.getValue().isBefore((LocalDate.of(2016,1,1)))){
                //action to give warning error
                t003.setText("warning: test date is not before 1/1/2016");
            } else {
                t003.setText("\n");
            }
        });
        
        //submit button action
        recordSubmit.setOnAction((ActionEvent e) -> {
            if ( !t003.getText().equals("\n")){
                //action to give warning error
                t003.setText("warning: please choose a proper test date again");            
            } else {
                    //submit new input to database
                    System.exit(0);//for test
            }
        });    
    }
    
    //do function emailing to doctor
    private void emailToDoctor(){
        //Controllers for Function emailing to doctor
        Label t3 = new Label("Email To Our Doctor In QLD Heart Health Clinic");
        
        functionBox.getChildren().clear();
                functionBox.getChildren().addAll(t3);
    }
    
    private Boolean inputIsDuplicate(LocalDate date){
        try {
            if (new SelectFromTable().isExist(
                    HeartRateMonitor.getUser().getUserName(),
                    Date.valueOf(date).toString() )){
                return TRUE;
            } else {
                return FALSE;           
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomepageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FALSE;
    }
}
