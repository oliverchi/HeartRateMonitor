/*
 * This file is to identify user class of this application.
 * 
 */
package heartratemonitor;


/**
 *
 * @author Oliver
 */
public class User {
    
    //Login information
    private String username;
    private String password;    
      
    
    /**
     * Constructor
     */
    public User(){
        username  = new String();
        password  = new String();                
    }
    
    /**
     * Method getUserName()
     * @return login name
     */
    public String getUserName(){
        return this.username;
    }
    
    /**
     * Method getPassword()
     * @return login key
     */
    public String getPassword(){
        return this.password;
    }
    
    /**
     * Method setUserName()
     * Write login name
     * @param name
     */
    public void setUserName(String name){
        this.username = name;
    }
    
    /**
     * Method setPassword()
     * Write login key
     * @param key
     */
    public void setPassword(String key){
        this.password = key;
    }   
    
}


