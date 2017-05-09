/*
 * 
 * Method createTable(string) executes the whole SQL statement;
 * Method closeConnection() has to be called after all other methods in this class are completed;
 */
package heartratemonitor;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Oliver
 */
public class ConnectLocalDatabase {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String PROTOCOL = "jdbc:derby:";
    private static final String DBNAME = "HRM_data";
    public Connection conn;
    
    public ConnectLocalDatabase(){
        try{
            Class.forName(DRIVER).newInstance();
		System.out.println("Loaded the embedded driver.");
        } catch(ClassNotFoundException | IllegalAccessException 
                | InstantiationException err){
            System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
    }
    
    
    /**
     * Method createDB()
     * @return boolean value if it is successful to create database
     */
    public boolean createDB(){
        try {
            conn = DriverManager.getConnection(PROTOCOL + DBNAME + ";create=true");
            
        } catch(SQLException err){
           System.err.println("SQL error.");
           err.printStackTrace(System.err);
           //System.exit(0);
           return FALSE;
        }
        return TRUE;        
    } 
      
    
    /**
     * Method connectDB()
     * @return boolean value if it is successful to connect database
     */
    public boolean connectDB(){
        try {
            conn = DriverManager.getConnection(PROTOCOL + DBNAME );
            
        } catch(SQLException err){
           System.err.println("SQL error.");
           err.printStackTrace(System.err);
           //System.exit(0);
           return FALSE;
        }
        return TRUE;        
    } 
   
   
    /**
     * Method executeSQL()
     * @param sql: SQL statement for execution
     * @return boolean value if it is successful to execute SQL statement
     */
    public boolean executeSQL(String sql){
        try {
            Statement s = conn.createStatement();
            s.execute(sql);   
            
        } catch(SQLException err){
           System.err.println("SQL error.");
           err.printStackTrace(System.err);
           //System.exit(0);
           return FALSE;
        }
        return TRUE; 
    }  
    
    /**
     * Method closeConnection()
     * This method has to be called after all other methods are completed
     */
    public void closeConnection(){
        try {
            conn.close();   
            
        } catch(SQLException err){
           System.err.println("SQL error.");
           err.printStackTrace(System.err);           
        }
    }
    
}