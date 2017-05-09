/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

/**
 *
 * @author Oliver
 */
public class ChangeTables {
    public ChangeTables(){
        ConnectLocalDatabase cn = new ConnectLocalDatabase();
    }
    
    public ChangeTables(String user, String key) throws SQLSyntaxErrorException {
        ConnectLocalDatabase cn = new ConnectLocalDatabase();
        if (cn.connectDB()) {
            cn.executeSQL("INSERT INTO login (username, password) VALUES "
                    + "('" + user + "','" + key + "')");
            cn.closeConnection();
        } else {
            System.out.println("connect unsuccessful");
        }
    }
    
    public ChangeTables(String user, Date testdate, Integer testresult)throws SQLException{
        ConnectLocalDatabase cn = new ConnectLocalDatabase();
        if (cn.connectDB()) {
            System.out.println("INSERT INTO results (username, testdate, testresult) VALUES "
                    + "( '" + user + "','" + testdate.toString() + "'," + testresult.toString() + ")");
            cn.executeSQL("INSERT INTO results (username, testdate, testresult) VALUES "
                    + "( '" + user + "','" + testdate.toString() + "'," + testresult.toString() + ")");
            
            cn.closeConnection();
        } else {
            System.out.println("connect unsuccessful");
        }
    }
    
    public ChangeTables(String user, String fn, String ln, Date dob, 
            String mobile, String email, String street, String city, 
            String state, String postcode, String medicare)throws SQLSyntaxErrorException{
        ConnectLocalDatabase cn = new ConnectLocalDatabase();
        if (cn.connectDB()) {
            cn.executeSQL("INSERT INTO patient (username, firstname, "
                    + "lastname, dob, mobile, email, street, city, "
                    + "state, postcode, medicare) VALUES ("
                    + user + "," + fn + ", " + ln + ", " + dob + ", " + mobile
                    + ", " + email + ", " + street + ", " + city + ", " + state
                    + ", " + postcode + ", " + medicare + ")" );
            cn.closeConnection();
        } else {
            System.out.println("connect unsuccessful2");
        }
    }
}
