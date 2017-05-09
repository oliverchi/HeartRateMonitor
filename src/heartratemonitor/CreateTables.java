/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heartratemonitor;

/**
 *
 * @author Oliver
 */
public class CreateTables {
    
    
    public CreateTables(){
        ConnectLocalDatabase cn = new ConnectLocalDatabase();
        
        //delete tables
        /*if (cn.connectDB()) {           
            cn.executeSQL("Drop TABLE results");
            cn.executeSQL("Drop TABLE login");
            cn.executeSQL("Drop TABLE patient");
            System.out.println("Delete tables successful");
            cn.closeConnection();
        } else {
            System.out.println("Delete table unsuccessful");
            cn.closeConnection();
        }*/
        
        //create database
        if (cn.createDB()){
            System.out.println("create DB successful");
        } else {
            System.out.println("create DB unsuccessful");
        }
        
        
        //create table for login
        if (cn.connectDB()) {
            System.out.println("connnect successful");
            if (cn.executeSQL ( "CREATE TABLE login ("
                    + " username VARCHAR(40) NOT NULL , "
                    + "password VARCHAR(40) NOT NULL, "
                    + "PRIMARY KEY (username) )" ) ) {
                System.out.println("table operation success");
            } else {
                System.out.println("table error");                
            }
            //cn.executeSQL("");
            //cn.executeSQL("");
            cn.executeSQL("INSERT INTO login (username, password) VALUES "
                    + "('administrator', 'usqcsc8416')");
            cn.closeConnection();
        } else {
            System.out.println("connect unsuccessful");
        }
        
        //create table for patient information
        if (cn.connectDB()) {
            System.out.println("connnect successful2");
            if (cn.executeSQL( "CREATE TABLE patient ( username "
                    + "VARCHAR(40) NOT NULL , firstname VARCHAR(40) NOT NULL ,"
                    + " lastname VARCHAR(40) NOT NULL , dob DATE NOT NULL ,"
                    + " mobile VARCHAR(10) NOT NULL , email VARCHAR(60)"
                    + " NOT NULL , street VARCHAR(60) NOT NULL , city "
                    + "VARCHAR(40) NOT NULL , state VARCHAR(3) NOT NULL , "
                    + "postcode VARCHAR(4) NOT NULL , medicare VARCHAR(11) "
                    + "NOT NULL , PRIMARY KEY (username))" ) ){
                System.out.println("table operation success2");
            } else {
                System.out.println("table error2");                
            }
            //cn.executeSQL("");
            //cn.executeSQL("");
            cn.executeSQL("INSERT INTO patient (username, firstname, "
                    + "lastname, dob, mobile, email, street, city, "
                    + "state, postcode, medicare) VALUES ('administrator',"
                    + " 'oliver', 'chi', '1986-04-04', '0401553311', "
                    + "'oliver.chi@icloud.com', '104 Radford Street', 'Manly', "
                    + "'QLD', '4135', '12345678901')" );
            cn.closeConnection();
        } else {
            System.out.println("connect unsuccessful2");
        }
        
        //create table for test results
        if (cn.connectDB()) {
            System.out.println("connnect successful");
            if (cn.executeSQL ( "CREATE TABLE results ("
                    + " username VARCHAR(40) NOT NULL , "
                    + "testdate DATE NOT NULL, "
                    + "testresult INTEGER NOT NULL, "
                    + "PRIMARY KEY (username, testdate))" ) ) {
                System.out.println("table operation success");
            } else {
                System.out.println("table error");                
            }
            //cn.executeSQL("");
            //cn.executeSQL("");
            cn.executeSQL("INSERT INTO results (username, testdate, testresult) VALUES "
                    + "('administrator', '2016-11-01', 75)");
            cn.closeConnection();
        } else {
            System.out.println("connect unsuccessful");
        }
        
        
    }
}
