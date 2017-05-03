/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class RegisterPaneController implements Initializable {

    @FXML
    private PasswordField pwdField;
    @FXML
    private PasswordField pwdField2;
    @FXML
    private TextField emailField;
    @FXML
    private Button setup;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private DatePicker birthday;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField cityField;
    @FXML
    private ComboBox<String> state;
    @FXML
    private TextField medicareField;
    @FXML
    private TextField postcodeField;
    @FXML
    private CheckBox readStatement;
    @FXML
    private TextField userNameField;
    @FXML
    private Label pwdText;
    @FXML
    private Label userNameText;
    @FXML
    private Label nameText;
    @FXML
    private Label phoneText;
    @FXML
    private Label pwdText2;
    @FXML
    private Label addressText;
    @FXML
    private Label emailText;
    @FXML
    private Label cityText;
    @FXML
    private Label medicareText;
    @FXML
    private Label postcodeText;
    @FXML
    private Label errorMsg;       
    @FXML
    private Label dateGenderText;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //setup combobox list
        gender.getItems().addAll("Male","Female","Intersex");
        state.getItems().addAll("NSW","VIC","QLD","SA","WA","NT","ACT","TAS");
        
        //setup tooltips
        birthday.setTooltip(new Tooltip("Date of Birth"));
        userNameField.setTooltip(new Tooltip("User name for login"));
        medicareField.setTooltip(new Tooltip("Medicare card number include reference number"));
        phoneField.setTooltip(new Tooltip("Ten digitals Australian mobile number"));
    }    

    //check if user name uses at least 6 characters and provide prompt message
    @FXML
    private void checkUserNameValid(KeyEvent event) {
        if (userNameField.getCharacters().toString().length() < 6 ){
            userNameText.setText("user name uses at least 6 characters");
        } else {
            userNameText.setText("");
        }
    }
    
    //check if password contains at least 1 alphabet and 1 number and at least 8 characters
    @FXML
    private void checkPasswordValid(KeyEvent event) {
        String c = pwdField.getText();
        if (c.length() < 8 ){
            pwdText.setText("password uses at least 8 characters");
        } else if (!c.matches(".*\\d+.*")){//decide if no number include
            pwdText.setText("password contains at least 1 number");
        } else if (!c.matches(".*[a-zA-Z].*")){//decide if no letter include
            pwdText.setText("password contains at least 1 letter");
        } else {
            pwdText.setText("");
        }
    }
    
    //check if passwords matched and provide prompt message
    @FXML
    private void checkPasswordsIfEqual(KeyEvent event) {
        if (pwdField.getText().equals(pwdField2.getText()) ){
            pwdText2.setText("");
        } else {
            pwdText2.setText("These passwords don't match. Try again?");
        }
    }
    
    //check if email valid and provide prompt message
    //use inner class to do email address validation instead InternetAddress API
    //becasue javax.mail.internet package has been removed from java se 1.8 library
    @FXML
    private void checkEmailValid(KeyEvent event) {
        if (new EmailValidator().validate( emailField.getText() ) ){
            emailText.setText("");
        } else {
            emailText.setText("invalid email address, try again?");        
        }
    }
    
    //check if first name is not NULLL and provide prompt message
    @FXML
    private void checkFirstNameValid(KeyEvent event) {
        if (firstNameField.getText().equals("")) 
            nameText.setText("can't accept first name as NULL");
    }

    //check if last name is not NULLL and provide prompt message
    @FXML
    private void checkLastNameValid(KeyEvent event) {        
        if (lastNameField.getText().equals("")) 
            nameText.setText("can't accept last name as NULL");
    }

    //check if input is a valid date
    @FXML
    private void checkBirthdayValid(ActionEvent event) {
        if (birthday.getValue().getYear() >= (LocalDate.now().getYear() - 150) &&
                birthday.getValue().getYear() <= (LocalDate.now().getYear() - 10)){
            dateGenderText.setText("");
        } else {
            dateGenderText.setText("wrong birthday, try again?");        
        }
    }

    @FXML
    private void checkPhoneValid(KeyEvent event) {
        if (phoneField.getText().matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")) {
            phoneText.setText("");
        } else {
            phoneText.setText("wrong mobile number, try again?");
        }
    }

    @FXML
    private void checkAddressValid(KeyEvent event) {
        
    }

    @FXML
    private void checkCityValid(KeyEvent event) {
        
    }

    @FXML
    private void checkMedicareCardValid(KeyEvent event) {
        
    }

    @FXML
    private void checkPostcodeValid(KeyEvent event) {
        
    }

    @FXML
    private void buttonOnAction(ActionEvent event) {
        
    }     
       
    /* INNER CLASS
     * Class EmailValidator
     * referenced from Mike Yong's codes for email address
     * orignal codes can be found in his website
     * @https://www.mkyong.com/
     *
     */
    private class EmailValidator {

	private Matcher matcher;
	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public EmailValidator() {
            /* empty constructor */
	}

	/*
	 * Validate email address with regular expression
	 * @param email; 
	 * @return Boolean; if matched, return true.  
	 */
	public boolean validate(final String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
    }
}
