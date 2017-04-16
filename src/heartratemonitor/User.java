/*
 * This file is to identify user class of this application.
 * 
 */
package heartratemonitor;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Oliver
 */
public class User {
    
    //Login information
    String username;
    String password;
    
    //User information
    String[][] propertyOfUser;
    
    //Whole item number of user information
    private final static int NUMOFPROPERTY = 10;
    
    /**
     * Constructor
     */
    public User(){
        username  = new String();
        password  = new String();        
        propertyOfUser = new String[2][NUMOFPROPERTY];
    }
    
    /**
     * Method getUserName()
     * @return login name
     */
    public String getUserName(){
        return username;
    }
    
    /**
     * Method getPassword()
     * @return login key
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * Method setUserName()
     * Write login name
     * @param name
     */
    public void setUserName(String name){
        username = name;
    }
    
    /**
     * Method setPassword()
     * Write login key
     * @param key
     */
    public void setPassword(String key){
        password = key;
    }
    
    /**
     * Method getInformation()
     * @return user information
     */
    public String[][] getInformation(){
        return propertyOfUser;
    }
    
    /**
     * Method setInformation()
     * Write user information
     * @param details
     */
    public void setInformation(String[][] details){
        propertyOfUser = details;
    }
}


