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
        
        //create database
        /*if (cn.createDB()){
            System.out.println("create DB successful");
        } else {
            System.out.println("create DB unsuccessful");
        }*/
        
        //create table
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
    }
}
